package leetcode.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Sky on 2019/5/29
 *
 * @author Sky
 */
public class LC127 {

    public static void main(String[] args) {
        System.out.println(new LC127().ladderLength(
                "hit", "cog",
                Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")
        ));
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int targetWordIndex = wordList.indexOf(endWord);

        int len = wordList.size();
        int[][] distance = new int[len + 1][len + 1];
        for (int i = 0; i < len + 1; i++) {
            for (int j = 0; j < len + 1; j++) {
                distance[i][j] = i == j ? 0 : Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < len; i++) {
            int dis;
            if ((dis = wordDistance(beginWord, wordList.get(i))) <= 1) {
                distance[len][i] = dis;
                distance[i][len] = distance[len][i];
            }
        }

        Set<Integer> traversedWordIndices = new HashSet<>(len);
        int baseDistance = 0;

        int a = len;
        int startingWordIndex = 0;
        do {
            int minDistance = Integer.MAX_VALUE;
            for (int i = 0; i < len; i++) {
                if (!traversedWordIndices.contains(i) && distance[a][i] < minDistance) {
                    startingWordIndex = i;
                }
            }
            if (startingWordIndex == a) {
                return 0;
            }
            traversedWordIndices.add(startingWordIndex);
            String startingWord = wordList.get(startingWordIndex);
            baseDistance += distance[a][startingWordIndex];
            if (startingWordIndex == targetWordIndex) {
                return wordList.contains(beginWord) ? baseDistance : baseDistance + 1;
            }
            if (traversedWordIndices.size() == len) {
                return 0;
            }
            for (int i = 0; i < len; i++) {
                if (!traversedWordIndices.contains(i)) {
                    int dis;
                    if ((dis = wordDistance(startingWord, wordList.get(i))) <= 1) {
                        distance[startingWordIndex][i] = dis;
                        distance[i][startingWordIndex] = dis;
                        if (baseDistance + distance[startingWordIndex][i] < distance[len][i]) {
                            distance[len][i] = baseDistance + distance[startingWordIndex][i];
                            distance[i][len] = distance[len][i];
                        }
                    }
                }
            }
            a = startingWordIndex;
        }
        while (true);

    }

    private static int wordDistance(String word1, String word2) {
        if (word1.equals(word2)) {
            return 0;
        }
        int len = word1.length();
        int distance = 0;
        for (int i = 0; i < len; i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                distance++;
            }
        }
        return distance;
    }

}
