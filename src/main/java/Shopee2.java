import java.util.*;

/**
 * Created by 44399 on 2019/8/10
 *
 * @author 44399
 */
public class Shopee2 {

    static class ThirdLibrary {
        String name;
        List<String> solvedBugs;
        List<String> newBugs;

        public ThirdLibrary(String name, int s, int n) {
            this.name = name;
            this.solvedBugs = new ArrayList<>(s);
            this.newBugs = new ArrayList<>(n);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int bugNum = scanner.nextInt();
        int thirdLibraryNum = scanner.nextInt();
        List<String> bugNames = new ArrayList<>(bugNum);
        for (int i = 0; i < bugNum; i++) {
            bugNames.add(scanner.next());
        }
        ThirdLibrary[] thirdLibraries = new ThirdLibrary[thirdLibraryNum];
        for (int i = 0; i < thirdLibraryNum; i++) {
            String name = scanner.next();
            int s = scanner.nextInt();
            int n = scanner.nextInt();
            thirdLibraries[i] = new ThirdLibrary(name, s, n);
            for (int j = 0; j < s; j++) {
                thirdLibraries[i].solvedBugs.add(scanner.next());
            }
            for (int j = 0; j < n; j++) {
                thirdLibraries[i].newBugs.add(scanner.next());
            }
        }
        fixBug(bugNames, thirdLibraries);
    }

    private static void fixBug(List<String> bugNames, ThirdLibrary[] thirdLibraries) {
        // 初始化，现将所有三方库都列为需要的库
        Set<String> requiredLibraries = new HashSet<>(thirdLibraries.length);
        for (ThirdLibrary thirdLibrary : thirdLibraries) {
            requiredLibraries.add(thirdLibrary.name);
        }
        // 统计所有三方库以及原有的bug，不管是否重复出现，只要出现就记1次
        Map<String, Integer> bugMap = new HashMap<>();
        for (String bugName : bugNames) {
            bugMap.put(bugName, 1);
        }
        for (ThirdLibrary thirdLibrary : thirdLibraries) {
            for (String bugName : thirdLibrary.newBugs) {
                bugMap.put(bugName, 1);
            }
        }
        // 遍历所有三方库，对于每一个三方库，将其所能修复的bug数量都-1
        for (ThirdLibrary thirdLibrary : thirdLibraries) {
            for (String bugName : thirdLibrary.solvedBugs) {
                bugMap.put(bugName, bugMap.getOrDefault(bugName, 0) - 1);
            }
        }
        /*
         * 如果此时仍有bug的数量大于1，说明该bug无法被修复，则输出无法修复并返回
         * 如果某一个bug数量为0，说明该bug恰好能被修复，则将该bug移除
         * 如果某一个bug的数量小于0，则说明三方库之间有重复
         */
        Iterator<Map.Entry<String, Integer>> iterator = bugMap.entrySet().iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getValue() == 0) {
                iterator.remove();
                continue;
            }
            if (iterator.next().getValue() > 0) {
                System.out.println("impossible");
                return;
            }
        }
        // 找出所有三方库中可以共同修复的bug
        Set<String> remainingBugs = bugMap.keySet();
        // 将三方库按可修复bug的数量进行排序，因为题目需要尽可能少的三方库
        Arrays.sort(thirdLibraries, Comparator.comparingInt(lib -> lib.solvedBugs.size()));
        /*
         * 对一个三方库，如果一个三方库可修复的bug被包含于所有三方库中可以共同修复的bug中
         * 那么可以认为这个三方库是多余的，则将该三方库剔除
         * 然后更新剩余所有的三方库中可以共同修复的bug
         * 重复直到所有三方库都被遍历一遍
         */
        for (ThirdLibrary thirdLibrary : thirdLibraries) {
            if (remainingBugs.containsAll(thirdLibrary.solvedBugs)) {
                requiredLibraries.remove(thirdLibrary.name);
                for (String bugName : thirdLibrary.solvedBugs) {
                    int n = bugMap.get(bugName);
                    if (n == -1) {
                        bugMap.remove(bugName);
                    } else {
                        bugMap.put(bugName, n + 1);
                    }
                }
                for (String bugName : thirdLibrary.newBugs) {
                    bugMap.put(bugName, bugMap.getOrDefault(bugName, 0) - 1);
                }
                remainingBugs = bugMap.keySet();
            }
        }
        List<String> result = new ArrayList<>(requiredLibraries);
        Collections.sort(result);
        for (String libName : result) {
            System.out.println(libName);
        }
    }
}
