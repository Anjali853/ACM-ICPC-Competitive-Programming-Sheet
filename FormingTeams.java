import java.util.*;

public class FormingTeams {

    static int n, m;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;

    // State:
    // -1 = Team 1
    //  0 = Bench
    // +1 = Team 2

    static boolean compatible(int prev, int cur) {
        // If one of them is on bench, no problem.
        if (prev == 0 || cur == 0) {
            return true;
        }

       
        return prev != cur;
    }
    static HashMap<Integer, Integer> solveComponent(ArrayList<Integer> order,
                                                     boolean isCycle) {

        HashMap<Integer, Integer> result = new HashMap<>();

        if (!isCycle) {

            // dp[lastState][difference] = maximum selected students
            int[][] dp = new int[3][2 * n + 1];

            for (int[] row : dp) {
                Arrays.fill(row, -1000000);
            }

            dp[1][n] = 0;

            for (int i = 0; i < order.size(); i++) {

                int[][] next = new int[3][2 * n + 1];

                for (int[] row : next) {
                    Arrays.fill(row, -1000000);
                }

                for (int prev = 0; prev < 3; prev++) {

                    int prevValue = prev - 1;

                    for (int diffIndex = 0;
                         diffIndex <= 2 * n;
                         diffIndex++) {

                        if (dp[prev][diffIndex] < 0) {
                            continue;
                        }

                        for (int cur = 0; cur < 3; cur++) {

                            int curValue = cur - 1;

                            if (!compatible(prevValue, curValue)) {
                                continue;
                            }

                            int newDiff =
                                    diffIndex + curValue;

                            if (newDiff < 0 || newDiff > 2 * n) {
                                continue;
                            }

                            int selected =
                                    dp[prev][diffIndex]
                                    + (curValue != 0 ? 1 : 0);

                            next[cur][newDiff] =
                                    Math.max(
                                            next[cur][newDiff],
                                            selected
                                    );
                        }
                    }
                }

                dp = next;
            }

            for (int last = 0; last < 3; last++) {

                for (int diffIndex = 0;
                     diffIndex <= 2 * n;
                     diffIndex++) {

                    int value = dp[last][diffIndex];

                    if (value < 0) {
                        continue;
                    }

                    int difference = diffIndex - n;

                    result.put(
                            difference,
                            Math.max(
                                    result.getOrDefault(difference, -1000000),
                                    value
                            )
                    );
                }
            }

        } else {

        
            for (int firstValue = -1;
                 firstValue <= 1;
                 firstValue++) {

                int[][] dp = new int[3][2 * n + 1];

                for (int[] row : dp) {
                    Arrays.fill(row, -1000000);
                }

                int firstState = firstValue + 1;

                dp[firstState][n + firstValue] =
                        firstValue != 0 ? 1 : 0;

                // Process remaining vertices
                for (int i = 1; i < order.size(); i++) {

                    int[][] next =
                            new int[3][2 * n + 1];

                    for (int[] row : next) {
                        Arrays.fill(row, -1000000);
                    }

                    for (int prev = 0; prev < 3; prev++) {

                        int prevValue = prev - 1;

                        for (int diffIndex = 0;
                             diffIndex <= 2 * n;
                             diffIndex++) {

                            if (dp[prev][diffIndex] < 0) {
                                continue;
                            }

                            for (int cur = 0; cur < 3; cur++) {

                                int curValue = cur - 1;

                                if (!compatible(prevValue, curValue)) {
                                    continue;
                                }

                                int newDiff =
                                        diffIndex + curValue;

                                if (newDiff < 0 ||
                                    newDiff > 2 * n) {
                                    continue;
                                }

                                int selected =
                                        dp[prev][diffIndex]
                                        + (curValue != 0 ? 1 : 0);

                                next[cur][newDiff] =
                                        Math.max(
                                                next[cur][newDiff],
                                                selected
                                        );
                            }
                        }
                    }

                    dp = next;
                }

                for (int last = 0; last < 3; last++) {

                    int lastValue = last - 1;

                    if (!compatible(firstValue, lastValue)) {
                        continue;
                    }

                    for (int diffIndex = 0;
                         diffIndex <= 2 * n;
                         diffIndex++) {

                        int value = dp[last][diffIndex];

                        if (value < 0) {
                            continue;
                        }

                        int difference =
                                diffIndex - n;

                        result.put(
                                difference,
                                Math.max(
                                        result.getOrDefault(
                                                difference,
                                                -1000000
                                        ),
                                        value
                                )
                        );
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {

            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;

            graph[a].add(b);
            graph[b].add(a);
        }

        visited = new boolean[n];

        /*
         * globalDP[difference] =
         * maximum students selected so far
         */
        HashMap<Integer, Integer> globalDP =
                new HashMap<>();

        globalDP.put(0, 0);

        for (int start = 0; start < n; start++) {

            if (visited[start]) {
                continue;
            }

            // Find component
            ArrayList<Integer> component =
                    new ArrayList<>();

            Stack<Integer> stack = new Stack<>();
            stack.push(start);
            visited[start] = true;

            while (!stack.isEmpty()) {

                int u = stack.pop();

                component.add(u);

                for (int v : graph[u]) {

                    if (!visited[v]) {
                        visited[v] = true;
                        stack.push(v);
                    }
                }
            }

            /*
             * Build an ordered path/cycle.
             */

            ArrayList<Integer> order =
                    new ArrayList<>();

            boolean isCycle = true;

            if (component.size() == 1) {

                order.add(component.get(0));
                isCycle = false;

            } else {

                // A cycle has every vertex degree 2.
                for (int u : component) {

                    if (graph[u].size() != 2) {
                        isCycle = false;
                        break;
                    }
                }

                if (isCycle) {

                    // Start from any vertex
                    int first = component.get(0);

                    order.add(first);

                    int prev = -1;
                    int cur = first;

                    while (true) {

                        int next;

                        if (graph[cur].get(0) != prev) {
                            next = graph[cur].get(0);
                        } else {
                            next = graph[cur].get(1);
                        }

                        if (next == first) {
                            break;
                        }

                        order.add(next);

                        prev = cur;
                        cur = next;
                    }

                } else {

                    // Path: start from an endpoint
                    int endpoint = -1;

                    for (int u : component) {

                        if (graph[u].size() <= 1) {
                            endpoint = u;
                            break;
                        }
                    }

                    int prev = -1;
                    int cur = endpoint;

                    while (true) {

                        order.add(cur);

                        int next = -1;

                        for (int v : graph[cur]) {

                            if (v != prev) {
                                next = v;
                                break;
                            }
                        }

                        if (next == -1) {
                            break;
                        }

                        prev = cur;
                        cur = next;
                    }
                }
            }

            // DP for this component
            HashMap<Integer, Integer> componentDP =
                    solveComponent(order, isCycle);

            // Merge with global DP
            HashMap<Integer, Integer> newGlobal =
                    new HashMap<>();

            for (Map.Entry<Integer, Integer> e1
                    : globalDP.entrySet()) {

                int diff1 = e1.getKey();
                int selected1 = e1.getValue();

                for (Map.Entry<Integer, Integer> e2
                        : componentDP.entrySet()) {

                    int diff2 = e2.getKey();
                    int selected2 = e2.getValue();

                    int newDiff = diff1 + diff2;

                    int newSelected =
                            selected1 + selected2;

                    newGlobal.put(
                            newDiff,
                            Math.max(
                                    newGlobal.getOrDefault(
                                            newDiff,
                                            -1000000
                                    ),
                                    newSelected
                            )
                    );
                }
            }

            globalDP = newGlobal;
        }

        // Difference must be 0 => equal teams
        int maximumStudents = globalDP.get(0);

        int answer = n - maximumStudents;

        System.out.println(answer);
    }
}
    

