package hw5.task2;

public interface Archivable {

    void archive();
    default boolean isArchived() {
        return false;
    }
}
