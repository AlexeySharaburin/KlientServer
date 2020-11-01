import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {
        int port = 7777;
        System.out.println("New connection accepted");
        ServerSocket serverSocket = new ServerSocket(port);
        Socket clientSocket = serverSocket.accept();
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        printOut(out, "Hallo! Write your name, please!");

        final String name = in.readLine();

        printOut(out, "Are you child? (yes/no)");

        final String answer = in.readLine();

        if ("yes".equals(answer)) {
            out.println(String.format("Welcome to the kids area, %s! Let's play!", name));
            out.flush();
        } else {
            out.println(String.format("Welcome to the adult zone, %s! Have a good rest, or a good working day!", name));
            out.flush();
        }

    }

    public static void printOut(PrintWriter out, String string) {
        out.println(string);
        out.flush();
    }

}
