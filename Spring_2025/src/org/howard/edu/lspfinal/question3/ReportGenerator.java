package org.howard.edu.lspfinal.question3;

/**
 * Abstract class that defines the template for report generation.
 */
public abstract class ReportGenerator {
    
    // Template Method
    public final void generateReport() {
        loadData();
        formatData();
        printReport();
    }

    protected abstract void loadData();
    protected abstract void formatData();
    protected abstract void printReport();
}

