package org.howard.edu.lsp.finalexam.question2;

import java.util.ArrayList;
import java.util.List;

/**
 * Driver demonstrating Template Method pattern and polymorphism.
 */
public class Driver {

    public static void main(String[] args) {

        List<Report> epsilonReportList = new ArrayList<>();

        epsilonReportList.add(new StudentReport());
        epsilonReportList.add(new CourseReport());

        for (Report rhoItem : epsilonReportList) {
            rhoItem.generateReport();
        }
    }
}