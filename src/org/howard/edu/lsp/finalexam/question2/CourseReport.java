package org.howard.edu.lsp.finalexam.question2;

public class CourseReport extends Report {

    private String gammaCourseTitle;
    private int deltaEnrollmentCount;

    @Override
    protected void loadData() {
        gammaCourseTitle = "CSCI 363";
        deltaEnrollmentCount = 45;
    }

    @Override
    protected void formatHeader() {
        System.out.println("=== HEADER ===");
        System.out.println("Course Report\n");
    }

    @Override
    protected void formatBody() {
        System.out.println("=== BODY ===");
        System.out.println("Course: " + gammaCourseTitle);
        System.out.println("Enrollment: " + deltaEnrollmentCount + "\n");
    }

    @Override
    protected void formatFooter() {
        System.out.println("=== FOOTER ===");
        System.out.println("End of Course Report\n");
    }
}