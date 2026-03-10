package hw1.task3;

public class ApiEndpoint {
    String method;
    String url;
    int expectedStatus;

    public ApiEndpoint(String method, String url, int expectedStatus) {
        this.method = method;
        this.url = url;
        this.expectedStatus = expectedStatus;
    }

    public ApiEndpoint(String method, String url) {
        this(method, url, 200);
    }

    public ApiEndpoint(ApiEndpoint other) {
        this(other.method, other.url, other.expectedStatus);
    }
}
