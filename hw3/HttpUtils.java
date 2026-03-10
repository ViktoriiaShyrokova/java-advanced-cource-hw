package hw3;

public class HttpUtils {
    public static int HTTP_OK = 200;
    public static int HTTP_CREATED = 201;
    public static int HTTP_NO_CONTENT = 204;
    public static int HTTP_BAD_REQUEST = 400;
    public static int HTTP_UNAUTHORIZED = 401;
    public static int HTTP_NOT_FOUND = 404;
    public static int HTTP_SERVER_ERROR = 500;

    public static boolean isSuccess(int code) {
        return code >= 200 && code <= 299;
    }

    public static boolean isClientError(int code) {
        return code >= 400 && code <= 499;
    }

    public static boolean isServerError(int code) {
        return code >= 500 && code <= 599;
    }

    public static String getStatusDescription(int code) {
        switch (code) {
            case 200:
                return "HTTP_OK";
            case 201:
                return "HTTP_CREATED";
            case 204:
                return "HTTP_NO_CONTENT";
            case 400:
                return "HTTP_BAD_REQUEST";
            case 401:
                return "HTTP_UNAUTHORIZED";
            case 404:
                return "HTTP_NOT_FOUND";
            case 500:
                return "HTTP_SERVER_ERROR";
            default:
                return "Unknown";
        }
    }
    private HttpUtils(){}
}
