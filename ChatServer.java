import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ChatServer {

    private static final int PORT = 5000;
    private static Set<ClientHandler> clients = new HashSet<>();
    private static AtomicInteger userIdCounter = new AtomicInteger(1);

    public static void main(String[] args) {
        System.out.println("Chat server started on port " + PORT);

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {

            while (true) {
                Socket socket = serverSocket.accept();
                int userId = userIdCounter.getAndIncrement();

                ClientHandler client = new ClientHandler(socket, userId);
                clients.add(client);

                new Thread(client).start();

                broadcast("User " + userId + " joined the chat.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void broadcast(String message) {
        for (ClientHandler client : clients) {
            client.sendMessage(message);
        }
    }

    public static void removeClient(ClientHandler client) {
        clients.remove(client);
        broadcast("User " + client.getUserId() + " left the chat.");
    }
}
