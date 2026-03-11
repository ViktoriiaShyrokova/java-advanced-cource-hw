package hw4.task2;

public class ArtifactMain {

    public static void main(String[] args) {

        TestArtifact artifact1 = new LogFile(1,"app log", 245);
        TestArtifact artifact2 = new Screenshot(2,"login page", "1920x1080");
        TestArtifact artifact3 = new TestArtifact(3,"general artifact");

        artifact1.printArtifact(artifact1);
        artifact2.printArtifact(artifact2);
        artifact3.printArtifact(artifact3);

    }
}
