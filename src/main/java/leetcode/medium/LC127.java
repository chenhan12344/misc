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
            distance[len][i] = wordDistance(beginWord, wordList.get(i)) == 1 ? 1 : Integer.MAX_VALUE;
            distance[i][len] = distance[len][i];
        }

        Set<Integer> traversedWordIndices = new HashSet<>(len);
        int baseDistance = 0;

        int a = 0;
        int startingWordIndex = 0;
        do {
            int minDistance = Integer.MAX_VALUE;
            for (int i = 0; i < len; i++) {
                if (distance[a][i] < minDistance) {
                    startingWordIndex = i;
                }
            }
            traversedWordIndices.add(startingWordIndex);
            String startingWord = wordList.get(startingWordIndex);
            baseDistance += distance[a][startingWordIndex];
            if (startingWordIndex == targetWordIndex) {
                return baseDistance;
            }
            if (traversedWordIndices.size() == len) {
                return 0;
            }
            for (int i = 0; i < len; i++) {
                if (!traversedWordIndices.contains(i)) {
                    if (wordDistance(startingWord, wordList.get(i)) == 1) {
                        distance[startingWordIndex][i] = 1;
                        distance[i][startingWordIndex] = 1;
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
