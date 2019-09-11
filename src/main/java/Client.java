import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by 44399 on 2019/8/6
 *
 * @author 44399
 */
public class Client {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("125.216.242.248", 9999);
        System.out.println("connected to server!");
        OutputStream os = socket.getOutputStream();
        PrintWriter printWriter = new PrintWriter(os);
        Scanner scanner = new Scanner(System.in);
        for (String s = scanner.next(); !s.equals("end"); s = scanner.next()) {
            printWriter.write(s);
            printWriter.flush();
        }
        printWriter.write("close");
//        printWriter.write("Hello server, I am client");
//        printWriter.flush();
//        socket.shutdownOutput();
//        InputStream inputStream = socket.getInputStream();
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
//        String info;
//        while ((info = bufferedReader.readLine()) != null) {
//            System.out.println(info);
//        }
        printWriter.close();
        os.close();
        socket.close();
    }
}
