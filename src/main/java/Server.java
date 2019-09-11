import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;

/**
 * Created by 44399 on 2019/8/6
 *
 * @author 44399
 */
public class Server {

    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocket serverSocket = new ServerSocket(9999);
        Socket socket;
        System.out.println("listening...");
        socket = serverSocket.accept();
        System.out.println("connected!");
        InputStream inputStream = socket.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String info;
        while ((info = bufferedReader.readLine()) != null) {
            if ("close".equals(info)) {
                break;
            }
            System.out.println(info);
        }
        socket.shutdownInput();
//        OutputStream outputStream = socket.getOutputStream();
//        PrintWriter printWriter = new PrintWriter(outputStream);
//        printWriter.write("server is closing...");
//        printWriter.flush();
//        for (int i = 0; i < 10; i++) {
//            printWriter.write(i);
//            printWriter.flush();
//            Thread.sleep(500);
//        }
//        printWriter.close();
        bufferedReader.close();
        inputStreamReader.close();
        inputStream.close();
    }
}
