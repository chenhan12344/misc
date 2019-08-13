import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by 44399 on 2019/8/6
 *
 * @author 44399
 */
public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(10010);
        Socket socket = null;
        int count = 0;
        System.out.println("starting server...");
        socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String info = null;
        while ((info = bufferedReader.readLine()) != null) {
            System.out.println(info);
        }
        socket.shutdownInput();
        OutputStream outputStream = socket.getOutputStream();
        PrintWriter printWriter = new PrintWriter(outputStream);
        printWriter.write("hello this is server");
        printWriter.flush();
        printWriter.close();
        bufferedReader.close();
        inputStreamReader.close();
        inputStream.close();
    }
}
