import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Socket socket;
        Scanner scanner = new Scanner(System.in);

        {
            try {
                System.out.print("Enter your username: ");
                String username = scanner.nextLine();
                System.out.println(TerminalColor.ANSI_PURPLE + "****************************************");
                System.out.println(TerminalColor.ANSI_CYAN + "Welcome to my chatroom");
                System.out.println(TerminalColor.ANSI_PURPLE + "****************************************" + TerminalColor.ANSI_RESET);

                socket = new Socket("127.0.0.1", 6000);
                Thread listenerThread = new Thread(new Listener(socket, username));
                listenerThread.start();

                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                out.writeObject(new Protocol("UserEntered", username, "joined chatroom!"));

                while(true) {
                    String text = scanner.nextLine();
                    if(text.equals("#exit")) {
                        break;
                    }
                    out.writeObject(new Protocol("writeMessage", username, text));
                }

                out.writeObject(new Protocol("UserLeft", username, "Left"));

                out.close();
                socket.close();
                listenerThread.interrupt();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class Listener implements Runnable{

    private Socket socket;
    private String username;

    public Listener(Socket socket, String username) {
        this.socket = socket;
        this.username = username;
    }

    @Override
    public void run() {
        ObjectInputStream input = null;
        try {
            input = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        while(true) {

            Protocol protocol = null;
            try {
                protocol = (Protocol) input.readObject();
            } catch (IOException e) {
                try {
                    input.close();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                break;
            } catch (ClassNotFoundException e) {
                try {
                    input.close();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                break;
            }
            if(!protocol.getUsername().equals(username)) {
                if(protocol.getOrder().equals("UserEntered")) {
                    System.out.println(TerminalColor.ANSI_CYAN + protocol + TerminalColor.ANSI_RESET);
                }
                else if(protocol.getOrder().equals("UserLeft")) {
                    System.out.println(TerminalColor.ANSI_RED + protocol + TerminalColor.ANSI_RESET);
                }
                else {
                    System.out.println(protocol);
                }
            }
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
