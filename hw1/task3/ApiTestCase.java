package hw1.task3;

public class ApiTestCase {

    String name;
    ApiEndpoint endpoint;
    String description;

    public ApiTestCase(String name, ApiEndpoint endpoint, String description) {
        this.name = name;
        this.endpoint = endpoint;
        this.description = description;
    }

    public ApiTestCase(ApiTestCase other) {
        this(other.name,new ApiEndpoint(other.endpoint), other.description);
    }
}
