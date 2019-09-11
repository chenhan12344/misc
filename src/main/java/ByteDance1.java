import java.util.*;

/**
 * Created by 44399 on 2019/8/25
 *
 * @author 44399
 */
public class ByteDance1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int users = scanner.nextInt();
        int[][] interactMatrix = new int[users][users];
        for (int i = 0; i < users; i++) {
            for (int j = 0; j < users; j++) {
                interactMatrix[i][j] = scanner.nextInt();
            }
        }
        Map<Integer, Edge> edgeHeads = new HashMap<>(users - 1);
        Set<Edge> edgeSet = new HashSet<>(users * (users - 1));
        Edge prev = null;
        for (int i = 0; i < users; i++) {
            for (int j = users - 1; j > i; j--) {
                if (prev == null) {
                    prev = new Edge(i, j, interactMatrix[i][j], null);
                } else {
                    prev = new Edge(i, j, interactMatrix[i][j], prev);
                }
                edgeSet.add(prev);
            }
            edgeHeads.put(i, prev);
            prev = null;
        }
        int res = 0;
        for (int i = 0; i < users; i++) {
            Edge edge = edgeHeads.get(i);
            while (edge != null) {
                LinkedList<Integer> connected = new LinkedList<>();
                while (edge != null) {
                    if (edge.interaction > 3) {
                        if (edgeSet.remove(edge)) {
                            connected.add(edge.j);
                        }
                    }
                    edge = edge.next;
                }
                if (!connected.isEmpty()) {
                    edge = edgeHeads.get(connected.removeFirst());
                } else {
                    edge = null;
                    res++;
                }
            }
        }
        System.out.println(res);
    }

    private static class Edge {
        int i;
        int j;
        int interaction;
        boolean visited;
        Edge next;

        public Edge(int i, int j, int interaction, Edge next) {
            this.i = i;
            this.j = j;
            this.interaction = interaction;
            this.visited = false;
            this.next = next;
        }
    }

}
