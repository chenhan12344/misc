package offer;

/**
 * Created by Sky on 2019/8/26
 *
 * @author Sky
 */
public class PostorderTraverseOfBST {

    public static void main(String[] args) {
        System.out.println(new PostorderTraverseOfBST().VerifySquenceOfBST(
                new int[]{7, 4, 6, 5}
        ));
    }

    public boolean VerifySquenceOfBST(int[] sequence) {
        int n = sequence.length;
        for (int i = 0; i < n - 1; i++) {
            if (sequence[i] > sequence[i + 1]) {
                int begin = i;
                while (begin < n - 1 && sequence[begin] > sequence[begin + 1]) {
                    begin++;
                }
                if (begin >= n) {
                    continue;
                }
                for (int j = begin + 1; j < n; j++) {
                    if (sequence[j] < sequence[i]) {
                        return false;
                    }
                }
            }

        }
        return true;
    }

}
