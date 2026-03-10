package hw1.task3;

public class Main {

    public static void main(String[] args) {

        ApiEndpoint endpointHomepage = new ApiEndpoint("GET", "https://www.my-ait.com/");
        ApiTestCase testCase1 = new ApiTestCase("Open homepage", endpointHomepage, "User can open homepage");

        ApiEndpoint endpointProfilePage = new ApiEndpoint("GET", "https://www.my-ait.com/account/my-account", 200);
        ApiTestCase testCase2 = new ApiTestCase("Open Profile page",endpointProfilePage,"User can open his profile");


        ApiTestCase testCase3 = new ApiTestCase(testCase2);
        testCase3.endpoint.expectedStatus = 403;

        System.out.println(testCase2.endpoint.expectedStatus);
        System.out.println(testCase3.endpoint.expectedStatus);
    }
}
