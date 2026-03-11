package hw4.task1;

import java.util.Objects;

public class TestStep {
    private int stepNumber;
    private String description;
    private String expectedResult;
    private boolean isPassed;

    public TestStep(int stepNumber, String description, String expectedResult) {
        this.stepNumber = stepNumber;
        this.description = description;
        this.expectedResult = expectedResult;
    }

    public int getStepNumber() {
        return stepNumber;
    }

    public String getDescription() {
        return description;
    }

    public String getExpectedResult() {
        return expectedResult;
    }

    public boolean isPassed() {
        return isPassed;
    }

    public void markPassed() {
        this.isPassed = true;
    }

    @Override
    public String toString() {
        return String.format("Step #%d: [%s] → Expected: [%s] | %s",
                stepNumber,description,expectedResult, isPassed ? "PASSED" : "FAILED");
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestStep testStep = (TestStep) o;
        return stepNumber == testStep.stepNumber && Objects.equals(description, testStep.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stepNumber, description);
    }
}
