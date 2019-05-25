import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by Sky on 2019/3/30
 *
 * @author Sky
 */
public class Sample2 extends Thread {

    private SimpleDateFormat sdf2
            = new SimpleDateFormat("yyyy-MM-dd");

    public void run() {
        try {
            sdf2.parse("2019-03-31");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
