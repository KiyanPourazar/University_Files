import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    static ArrayList<Socket> clientSockets = new ArrayList<>();
    static ArrayList<ObjectOutputStream> objectOutputStreams = new ArrayList<>();

    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(6000)) {
            System.out.println("Server is running ...");
            try {
                while (true) {

                    Socket client = serverSocket.accept();
                    clientSockets.add(client);
                    objectOutputStreams.add(new ObjectOutputStream(client.getOutputStream()));
                    Thread clientThread = new Thread(new ClientHandler(client));
                    clientThread.start();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class ClientHandler implements Runnable {

    private Socket socket;
    private ObjectInputStream input;


    public ClientHandler(Socket socket) {
        this.socket = socket;
        try {
            input = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        try{
            while(true) {

                try {
                    Protocol protocol = (Protocol) input.readObject();
                    for(ObjectOutputStream element : Server.objectOutputStreams) {
                        element.writeObject(protocol);
                        element.flush();
                    }
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        } catch (IOException e) {
            // nothing :)
        }
    }
}
