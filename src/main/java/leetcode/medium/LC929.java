package leetcode.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by DJH on 2018/11/13
 */
public class LC929 {

    public static void main(String[] args) {

    }

    public static int numUniqueEmails(String[] emails) {
        Set<String> mailSet = new HashSet<>();
        for (String email : emails) {
            String[] components = email.split("@");
            if (components[0].contains("+")) {
                mailSet.add(components[0].substring(0, components[0].indexOf("+")).replace(".", "") + "@" + components[1]);
            } else {
                mailSet.add(email.replace(".", ""));
            }
        }
        return mailSet.size();
    }
}
