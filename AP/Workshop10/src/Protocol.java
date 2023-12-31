import java.io.Serializable;

public class Protocol implements Serializable {
    private String order;
    private String username;
    private String message;

    public Protocol(String order, String username, String message) {
        this.order = order;
        this.username = username;
        this.message = message;
    }

    public String getOrder() {
        return order;
    }

    public String getUsername() {
        return username;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return username + " | " + message;
    }
}
