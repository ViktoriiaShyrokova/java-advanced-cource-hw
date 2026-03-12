package hw5.task1;

public interface Prioritizable {

    int getPriority();
    String getPriorityLabel();

    default boolean isHigherPriorityThan(Prioritizable other) {
        return this.getPriority() < other.getPriority();
    }

}
