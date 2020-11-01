import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Klient {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String host = "netology.homework";
        int port = 7777;
        try (Socket clientSocket = new Socket(host, port);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

            readIn(in);

            String nameKlient = scanner.nextLine();
            writeOut(out, nameKlient);

            readIn(in);

            String answerKlient = scanner.nextLine();

            if ("yes".equals(answerKlient)) {
                writeOut(out, answerKlient);
            } else {
                writeOut(out, answerKlient);
            }

            readIn(in);

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeOut(PrintWriter out, String string) {
        out.write(string);
        out.write("\r\n");
        out.flush();
    }

    public static void readIn(BufferedReader in) throws IOException {
        String string = in.readLine();
        System.out.println(string);
    }

}
