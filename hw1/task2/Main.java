package hw1.task2;

public class Main {

    public static void main(String[] args) {

        Config prodConfig = new Config("host", 2035, 3000);
        Config configCopy1 = prodConfig;
        Config configCopy2 = new Config(prodConfig);

        configCopy2.port = 9999;
        System.out.println("prodConfig port:" + prodConfig.port);
        System.out.println("порт оригинала не меняется, мы поменяли значение только у копии");
        configCopy1.port = 9999;
        System.out.println("prodConfig port:" + prodConfig.port);
        System.out.println("изменился оригинал, мы поменяли его, т.к. " +
                "обращались к тому же объекту, просто через другую переменную");
    }
}
