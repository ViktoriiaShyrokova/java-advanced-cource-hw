package hw4.task2;

public class TestArtifact {
    private final int id;
    private String name;

    public TestArtifact(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getSummary() {
        return String.format("Artifact #[%d]: [%s]", id,name);
    }

    public void printArtifact(TestArtifact a) {
        System.out.println(a.getSummary());
    }

    @Override
    public String toString() {
        return getSummary();
    }
}
