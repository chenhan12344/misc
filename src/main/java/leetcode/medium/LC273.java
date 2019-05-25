package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Sky on 2019/1/7
 *
 * @author Sky
 */
public class LC273 {

    private static Map<Character, String> onesMap = new HashMap<>(10);

    static {
        onesMap.put('1', "One");
        onesMap.put('2', "Two");
        onesMap.put('3', "Three");
        onesMap.put('4', "Four");
        onesMap.put('5', "Five");
        onesMap.put('6', "Six");
        onesMap.put('7', "Seven");
        onesMap.put('8', "Eight");
        onesMap.put('9', "Nine");
    }

    private static Map<Integer, String> twoTensMap = new HashMap<>(10);

    static {
        twoTensMap.put(10, "Ten");
        twoTensMap.put(11, "Eleven");
        twoTensMap.put(12, "Twelve");
        twoTensMap.put(13, "Thirteen");
        twoTensMap.put(14, "Fourteen");
        twoTensMap.put(15, "Fifteen");
        twoTensMap.put(16, "Sixteen");
        twoTensMap.put(17, "Seventeen");
        twoTensMap.put(18, "Eighteen");
        twoTensMap.put(19, "Nineteen");
    }

    private static Map<Character, String> tensMap = new HashMap<>(10);

    static {
        tensMap.put('1', "Ten");
        tensMap.put('2', "Twenty");
        tensMap.put('3', "Thirty");
        tensMap.put('4', "Forty");
        tensMap.put('5', "Fifty");
        tensMap.put('6', "Sixty");
        tensMap.put('7', "Seventy");
        tensMap.put('8', "Eighty");
        tensMap.put('9', "Ninety");
    }

    private static Map<Integer, String> numberMap = new HashMap<>();

    static {
        numberMap.put(1, "Thousand");
        numberMap.put(2, "Million");
        numberMap.put(3, "Billion");
    }

    public static void main(String[] args) {
        System.out.println(new LC273().numberToWords(12));
    }

    public String numberToWords(int num) {
        return null;
    }
}
