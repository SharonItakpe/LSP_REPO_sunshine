package org.howard.edu.lsp.finalexam.question3;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * JUnit 5 tests for GradeCalculator.
 */
public class GradeCalculatorTest {

    @Test
    public void testAverageReturnsCorrectValue() {
        GradeCalculator sigmaCalculator = new GradeCalculator();

        double thetaAverage = sigmaCalculator.average(80, 90, 100);

        assertEquals(90.0, thetaAverage, 0.001);
    }

    @Test
    public void testLetterGradeReturnsCorrectLetter() {
        GradeCalculator sigmaCalculator = new GradeCalculator();

        assertEquals("A", sigmaCalculator.letterGrade(95));
        assertEquals("B", sigmaCalculator.letterGrade(85));
        assertEquals("C", sigmaCalculator.letterGrade(75));
        assertEquals("D", sigmaCalculator.letterGrade(65));
        assertEquals("F", sigmaCalculator.letterGrade(50));
    }

    @Test
    public void testIsPassingReturnsTrueForPassingAverage() {
        GradeCalculator sigmaCalculator = new GradeCalculator();

        assertTrue(sigmaCalculator.isPassing(60));
        assertTrue(sigmaCalculator.isPassing(75));
    }

    @Test
    public void testBoundaryScoreZeroIsValid() {
        GradeCalculator sigmaCalculator = new GradeCalculator();

        double thetaAverage = sigmaCalculator.average(0, 0, 0);

        assertEquals(0.0, thetaAverage, 0.001);
    }

    @Test
    public void testBoundaryScoreOneHundredIsValid() {
        GradeCalculator sigmaCalculator = new GradeCalculator();

        double thetaAverage = sigmaCalculator.average(100, 100, 100);

        assertEquals(100.0, thetaAverage, 0.001);
    }

    @Test
    public void testNegativeScoreThrowsException() {
        GradeCalculator sigmaCalculator = new GradeCalculator();

        assertThrows(IllegalArgumentException.class, () -> {
            sigmaCalculator.average(-1, 80, 90);
        });
    }

    @Test
    public void testScoreAboveOneHundredThrowsException() {
        GradeCalculator sigmaCalculator = new GradeCalculator();

        assertThrows(IllegalArgumentException.class, () -> {
            sigmaCalculator.average(80, 90, 101);
        });
    }
}