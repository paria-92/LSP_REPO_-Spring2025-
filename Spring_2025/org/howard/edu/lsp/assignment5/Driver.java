package org.howard.edu.lsp.assignment5;

public class Driver {
    public static void main(String[] args) {
        System.out.println("----- Testing IntegerSet Class -----");

        IntegerSet set1 = new IntegerSet();
        IntegerSet set2 = new IntegerSet();

        // Add elements
        set1.add(1);
        set1.add(3);
        set1.add(5);
        set2.add(3);
        set2.add(4);
        set2.add(5);

        System.out.println("Set1: " + set1);
        System.out.println("Set2: " + set2);

        // Contains
        System.out.println("Set1 contains 3? " + set1.contains(3));
        System.out.println("Set2 contains 1? " + set2.contains(1));

        // Length
        System.out.println("Length of Set1: " + set1.length());

        // Smallest and Largest
        try {
            System.out.println("Smallest in Set1: " + set1.smallest());
            System.out.println("Largest in Set1: " + set1.largest());
        } catch (IntegerSetException e) {
            System.out.println(e.getMessage());
        }

        // Equality
        System.out.println("Are Set1 and Set2 equal? " + set1.equals(set2));

        // Union
        set1.union(set2);
        System.out.println("Union of Set1 and Set2: " + set1);

        // Intersection
        set1.clear();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set2.clear();
        set2.add(3);
        set2.add(4);
        set1.intersect(set2);
        System.out.println("Intersection of Set1 and Set2: " + set1);

        // Difference
        set1.clear();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set2.clear();
        set2.add(2);
        set2.add(4);
        set1.diff(set2);
        System.out.println("Difference of Set1 and Set2: " + set1);

        // Remove
        set1.remove(1);
        System.out.println("Set1 after removing 1: " + set1);

        // Clear
        set1.clear();
        System.out.println("Set1 after clearing: " + set1);
        System.out.println("Is Set1 empty? " + set1.isEmpty());
    }
}

//REFERENCES:
//Java ArrayList API - https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html
//Java Exception Handling - https://docs.oracle.com/javase/tutorial/essential/exceptions/index.html
//Overriding toString and equals - https://www.geeksforgeeks.org/overriding-equals-method-in-java/
//Java List operations - https://www.w3schools.com/java/java_arraylist.asp

//Force update to show in Git Staging
