package org.howard.edu.lsp.finalexam.question2;

public class StudentReport extends Report {

    private String alphaStudentName;
    private double betaGpaValue;

    @Override
    protected void loadData() {
        alphaStudentName = "John Doe";
        betaGpaValue = 3.8;
    }

    @Override
    protected void formatHeader() {
        System.out.println("=== HEADER ===");
        System.out.println("Student Report\n");
    }

    @Override
    protected void formatBody() {
        System.out.println("=== BODY ===");
        System.out.println("Student Name: " + alphaStudentName);
        System.out.println("GPA: " + betaGpaValue + "\n");
    }

    @Override
    protected void formatFooter() {
        System.out.println("=== FOOTER ===");
        System.out.println("End of Student Report\n");
    }
}