package hw3;

public class HttpUtilsMain {

    public static void main(String[] args) {

        System.out.println(HttpUtils.getStatusDescription(200) + ", isSuccess? " + HttpUtils.isSuccess(200));
        System.out.println(HttpUtils.getStatusDescription(201) + ", isClientError? " + HttpUtils.isClientError(201));
        System.out.println(HttpUtils.getStatusDescription(204) + ", isServerError? " + HttpUtils.isServerError(204));
        System.out.println(HttpUtils.getStatusDescription(400) + ", isClientError? " + HttpUtils.isClientError(400));
        System.out.println(HttpUtils.getStatusDescription(401) + ", isSuccess? " + HttpUtils.isSuccess(401));
        System.out.println(HttpUtils.getStatusDescription(404) + ", isServerError? " + HttpUtils.isServerError(404));
        System.out.println(HttpUtils.getStatusDescription(500) + ", isServerError? " + HttpUtils.isServerError(500));
        System.out.println(HttpUtils.getStatusDescription(100) + ", isSuccess? " + HttpUtils.isSuccess(100));
        System.out.println();
    }
}
