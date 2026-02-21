/**
 * Name: Sharon
 */
package org.howard.edu.lsp.assignment3;

/**
 * Entry point for Assignment 3. Runs the ETL pipeline using the same input, output,
 * transformations, and error handling as Assignment 2.
 */
public class ETLPipelineA3 {
    /**
     * Program entry point.
     * @param args command line arguments (unused)
     */
    public static void main(String[] args) {
        ETLRunner runner = new ETLRunner();
        runner.run();
    }
}