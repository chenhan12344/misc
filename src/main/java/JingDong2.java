import java.util.*;

/**
 * Created by 44399 on 2019/8/24
 *
 * @author 44399
 */
public class JingDong2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] relate = new int[m][2];
        Map<Integer, Node> graph = new HashMap<>();
        for (int i = 0; i < m; i++) {
            relate[i][0] = scanner.nextInt();
            relate[i][1] = scanner.nextInt();
            Node left = graph.get(relate[i][0]);
            if (left == null) {
                left = new Node(relate[i][0]);
                graph.put(relate[i][0], left);
            }
            Node right = graph.get(relate[i][1]);
            if (right == null) {
                right = new Node(relate[i][1]);
                graph.put(relate[i][1], right);
            }
            left.connectTo(right, true);
        }
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>((o1, o2) -> {
            if (o1.neighbors.size() != o2.neighbors.size()) {
                return o2.neighbors.size() - o1.neighbors.size();
            }
            return o1.number - o2.number;
        });

        for (Map.Entry<Integer, Node> entry : graph.entrySet()) {
            priorityQueue.add(entry.getValue());
        }

        List<Node> result = new ArrayList<>();
        while (!priorityQueue.isEmpty()) {
            Node node = priorityQueue.peek();
            if (node.neighbors.size() == 0) {
                break;
            }
            node.remove();
            result.add(priorityQueue.remove());
        }
        System.out.println(result.size());
        result.sort(Comparator.comparingInt(o -> o.number));
        if (result.size() != 0) {
            for (int i = 0; i < result.size() - 1; i++) {
                System.out.println(result.get(i).number + " ");
            }
            System.out.println(result.get(result.size() - 1).number + " ");
        }
    }

    private static class Node {
        Set<Node> neighbors = new HashSet<>();
        int number;

        public Node(int number) {
            this.number = number;
        }

        public void connectTo(Node other, boolean first) {
            neighbors.add(other);
            if (first) {
                other.connectTo(this, false);
            }
        }

        public void remove() {
            for (Node node : neighbors) {
                node.neighbors.remove(this);
            }
        }
    }
}
