package org.howard.edu.lsp.assignment2;

import java.io.*;
import java.util.*;

public class ETLPipeline {

    public static void main(String[] args) {
        // Input and Output file paths
        String inputFilePath = "data/products.csv";
        String outputFilePath = "data/transformed_products.csv";

        try {
            // Read the file
            List<String> lines = readFile(inputFilePath);
            if (lines.isEmpty()) {
                System.err.println("Error: Input file is empty.");
                return;
            }

            // Transform Phase(Process extracted data)
            List<String> transformedLines = transformData(lines);

            // Print transformed data to console
            System.out.println("\n===== Transformed Data =====");
            for (String line : transformedLines) {
                System.out.println(line);
            }

            // Load Phase(Write the transformed data)
            writeFile(outputFilePath, transformedLines);
            System.out.println("\n✅ Transformed data saved to: " + outputFilePath);

        } catch (IOException e) {
            System.err.println("Error processing the file: " + e.getMessage());
        }
    }

    public static List<String> readFile(String filePath) throws IOException {
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (FileNotFoundException e) {
            throw new IOException("Error: File not found -> " + filePath);
        }
        return lines;
    }

    public static List<String> transformData(List<String> lines) {
        List<String> transformed = new ArrayList<>();
        String header = "ProductID,Name,Price,Category,PriceRange";
        transformed.add(header);

        for (int i = 1; i < lines.size(); i++) {
            String line = lines.get(i).trim();
            if (line.isEmpty()) {
                System.err.println("Skipping empty line.");
                continue;
            }

            String[] parts = line.split(",\\s*");
            if (parts.length != 4 || parts[0].trim().isEmpty() || parts[1].trim().isEmpty() 
                || parts[2].trim().isEmpty() || parts[3].trim().isEmpty()) {
                System.err.println("Skipping invalid or incomplete line: " + line);
                continue;
            }

            try {
                int productId = Integer.parseInt(parts[0].trim());
                String name = parts[1].trim().toUpperCase();
                double price = Double.parseDouble(parts[2].trim());
                String category = parts[3].trim();
                String priceRange;

                if (category.equalsIgnoreCase("Electronics")) {
                    price = Math.round((price * 0.9) * 100.0) / 100.0; // Apply discount and round
                }

                if (price > 500) {
                    category = "Premium Electronics";
                }

                if (price <= 10) {
                    priceRange = "Low";
                } else if (price <= 100) {
                    priceRange = "Medium";
                } else if (price <= 500) {
                    priceRange = "High";
                } else {
                    priceRange = "Premium";
                }

                String transformedLine = productId + "," + name + "," + price + "," + category + "," + priceRange;
                transformed.add(transformedLine);

            } catch (NumberFormatException e) {
                System.err.println("Skipping malformed line: " + line);
            }
        }
        return transformed;
    }

    public static void writeFile(String filePath, List<String> lines) throws IOException {
        File outputFile = new File(filePath);
        outputFile.getParentFile().mkdirs();

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
            for (String line : lines) {
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}
