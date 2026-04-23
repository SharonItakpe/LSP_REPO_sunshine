package org.howard.edu.lsp.finalexam.question3;

/**
 * Calculates score averages, letter grades, and passing status.
 */
public class GradeCalculator {

    /**
     * Calculates the average of three valid scores.
     *
     * @param score1 first score
     * @param score2 second score
     * @param score3 third score
     * @return average of the three scores
     */
    public double average(int score1, int score2, int score3) {
        validateScore(score1);
        validateScore(score2);
        validateScore(score3);
        return (score1 + score2 + score3) / 3.0;
    }

    /**
     * Returns the letter grade for an average.
     *
     * @param average numeric average
     * @return letter grade
     */
    public String letterGrade(double average) {
        if (average >= 90) return "A";
        else if (average >= 80) return "B";
        else if (average >= 70) return "C";
        else if (average >= 60) return "D";
        else return "F";
    }

    /**
     * Determines whether an average is passing.
     *
     * @param average numeric average
     * @return true if average is at least 60, otherwise false
     */
    public boolean isPassing(double average) {
        return average >= 60;
    }

    private void validateScore(int score) {
        if (score < 0 || score > 100) {
            throw new IllegalArgumentException("Score must be between 0 and 100");
        }
    }
}