package leetcode.medium;

/**
 * Created by DJH on 2018/11/13
 */
public class LC65 {

    public static void main(String[] args) {
        System.out.println(isNumber("4e1.e"));
    }

    public static boolean isNumber(String s) {
        try {
            Double.parseDouble(s);
        } catch (Exception ignored) {
            if (s.contains("e")) {
                if (s.substring(s.indexOf("e")).contains("e")) {
                    return false;
                }
                String[] sci = s.split("e");
                try {
                    Double.parseDouble(sci[0]);
                } catch (Exception ignored1) {
                    return false;
                }
                try {
                    Double.parseDouble(sci[1]);
                } catch (Exception ignored1) {
                    return false;
                }
                return true;
            } else {
                return false;
            }
        }
        return true;
    }
}
