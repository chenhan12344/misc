package thread.ipc;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * Created by 44399 on 2019/8/16
 *
 * @author 44399
 */
public class PipeDemo {

    public static void main(String[] args) throws IOException {
        PipedWriter pipedWriter = new PipedWriter();
        PipedReader pipedReader = new PipedReader();
        pipedWriter.connect(pipedReader);
        new ReaderThread(pipedReader).start();
        new WriterThread(pipedWriter).start();

    }


}

class ReaderThread extends Thread {

    PipedReader in;

    public ReaderThread(PipedReader in) {
        this.in = in;
    }

    @Override
    public void run() {
        if (in != null) {
            try {
                int msg;
                while ((msg = in.read()) != -1) {
                    System.out.println("Receiving msg: " + msg);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}

class WriterThread extends Thread {

    PipedWriter out;

    public WriterThread(PipedWriter out) {
        this.out = out;
    }

    @Override
    public void run() {
        if (out != null) {
            int i = 0;
            try {
                while (i < 20) {
                    System.out.println("Sending msg: " + i);
                    out.write(i++);
                    out.flush();
                    Thread.sleep(200);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}