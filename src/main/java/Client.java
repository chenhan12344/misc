import java.io.IOException;
import java.net.Socket;

/**
 * Created by 44399 on 2019/8/6
 *
 * @author 44399
 */
public class Client {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("192.168.1.1", 10010);
//        OutputStream os = socket.getOutputStream();
//        PrintWriter printWriter = new PrintWriter(os);
//        printWriter.write("Hello server, I am client");
//        printWriter.flush();
//        socket.shutdownOutput();
//        InputStream inputStream = socket.getInputStream();
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
//        String info = null;
//        while ((info = bufferedReader.readLine()) != null) {
//            System.out.println(info);
//        }
//        bufferedReader.close();
//        inputStream.close();
//        printWriter.close();
//        os.close();
//        socket.close();
    }
}
