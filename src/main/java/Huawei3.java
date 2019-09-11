import java.util.*;

/**
 * Created by 44399 on 2019/8/21
 *
 * @author 44399
 */
public class Huawei3 {

    public static void main(String[] args) {
        main2();
    }

    public static void main1() {
        Scanner scanner = new Scanner(System.in);
        String firstPerson = scanner.nextLine();
        int numOfGroups = scanner.nextInt();
        if (numOfGroups == 0) {
            System.out.println(0);
            return;
        }
        scanner.nextLine();

        // 记录群组信息
        List<Set<String>> groups = new ArrayList<>(numOfGroups);

        // 记录每个人所在的群组
        Map<String, List<Integer>> groupMap = new HashMap<>();

        // 记录所有能收到消息的人
        Set<String> allNames = new HashSet<>();


        for (int i = 0; i < numOfGroups; i++) {
            String membersString = scanner.nextLine();
            String[] members = membersString.split(",");
            Set<String> group = new HashSet<>(members.length);
            for (String member : members) {
                group.add(member);
                if (groupMap.containsKey(member)) {
                    groupMap.get(member).add(i);
                } else {
                    List<Integer> groupIndices = new ArrayList<>(numOfGroups);
                    groupIndices.add(i);
                    groupMap.put(member, groupIndices);
                }
            }
            groups.add(group);
        }

        // 记录已经访问过的群组，该群组中所有人都能收到消息
        boolean[] mark = new boolean[numOfGroups];
        if (!groupMap.containsKey(firstPerson)) {
            System.out.println(0);
            return;
        }
        for (int groupIndex : groupMap.get(firstPerson)) {
            mark[groupIndex] = true;
            allNames.addAll(groups.get(groupIndex));
        }

        // 记录已经发送过消息的人
        Set<String> checked = new HashSet<>();
        checked.add(firstPerson);

        outer:
        while (!allNames.equals(checked)) {
            for (String person : allNames) {
                if (checked.contains(person)) {
                    continue;
                }
                for (int groupIndex : groupMap.get(person)) {
                    if (!mark[groupIndex]) {
                        mark[groupIndex] = true;
                        allNames.addAll(groups.get(groupIndex));
                    }
                }
                checked.add(person);
                continue outer;
            }
        }
        System.out.print(allNames.size());
    }

    private static void main2() {
        Scanner scanner = new Scanner(System.in);
        String start = scanner.next();
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            String str = scanner.next();
            String[] split = str.split(",");
            for (int j = 0; j < split.length; j++) {
                for (int k = 0; k < split.length; k++) {
                    addEdge(split[j], split[k]);
                    addEdge(split[k], split[j]);
                }
            }
        }
        ans = 0;
        vis.put(start, 1);
        dfs(start);
        System.out.println(ans);
    }

    static Map<String, Integer> edgeHead = new HashMap<>();
    static int edgeCount;
    static List<Edge> edges = new ArrayList<>();
    static int ans = 0;
    static Map<String, Integer> vis = new HashMap<>();

    static void addEdge(String u, String v) {
        Edge edge = new Edge(u, v);
        edge.next = edgeHead.get(u);
        edges.add(edgeCount, edge);
        edgeHead.put(u, edgeCount++);
    }

    private static void dfs(String str) {
        for (Integer index = edgeHead.get(str); index != null; index = edges.get(index).next) {
            String visit = edges.get(index).v;
            if (vis.get(visit) == null) {
                vis.put(visit, 1);
                ans++;
                dfs(visit);
            }
        }
    }
}

class Edge {
    String u;
    String v;
    Integer next;

    public Edge(String u, String v) {
        this.u = u;
        this.v = v;
    }
}