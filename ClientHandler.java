import java.io.*;
import java.net.*;

public class ClientHandler implements Runnable {

    private Socket socket;
    private int userId;
    private PrintWriter out;
    private BufferedReader in;

    public ClientHandler(Socket socket, int userId) throws IOException {
        this.socket = socket;
        this.userId = userId;

        // FIX: streams initialized here
        out = new PrintWriter(socket.getOutputStream(), true);
        in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
    }

    @Override
    public void run() {
        try {
            out.println("Welcome! You are User " + userId);

            String message;
            while ((message = in.readLine()) != null) {
                ChatServer.broadcast("User " + userId + ": " + message);
            }

        } catch (IOException e) {
            // client disconnected
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            ChatServer.removeClient(this);
        }
    }

    public void sendMessage(String message) {
        out.println(message);
    }

    public int getUserId() {
        return userId;
    }
}
