package hw4.task2;

public class Screenshot extends TestArtifact{

    private String resolution;

    public Screenshot(int id, String name, String resolution) {
        super(id, name);
        this.resolution = resolution;
    }

    @Override
    public String getSummary() {
        return super.getSummary() + "[Screenshot: " + resolution + "]";
    }

    @Override
    public String toString() {
        return getSummary();
    }
}
