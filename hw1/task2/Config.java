package hw1.task2;

public class Config {
    String host;
    int port;
    int timeout;

    public Config() {
    }

    public Config(String host, int port, int timeout) {
        this.host = host;
        this.port = port;
        this.timeout = timeout;
    }

    public Config(Config other) {
        this(other.host,other.port,other.timeout);
    }
}
