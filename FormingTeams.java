import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FormingTeams {
    static int n, m;
    static List<Integer>[] graph;
    static int[] color;
    static boolean[] visited;

    static class Component {
        int zero;
        int one;

        Component(int zero, int one) {
            this.zero = zero;
            this.one = one;
        }
    }

    static boolean bipartite;
    static int cnt0, cnt1;

    static void dfs(int node) {
        visited[node] = true;

        if (color[node] == 0) {
            cnt0++;
        } else {
            cnt1++;
        }

        for (int next : graph[node]) {
            if (!visited[next]) {
                color[next] = 1 - color[node];
                dfs(next);
            } else if (color[next] == color[node]) {
                bipartite = false;
            }
        }
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

        color = new int[n];
        visited = new boolean[n];

        Arrays.fill(color, -1);

        List<Component> components = new ArrayList<>();

        int removed = 0;

        // Find connected components
        for (int i = 0; i < n; i++) {

            if (visited[i]) {
                continue;
            }

            cnt0 = 0;
            cnt1 = 0;
            bipartite = true;

            color[i] = 0;
            dfs(i);

            if (!bipartite) {
                // Odd cycle.
                // Remove one student.
                removed++;
            } else {
                components.add(new Component(cnt0, cnt1));
            }
        }

        /*
         * DP:
         * dp[x] = maximum number of students that can be placed
         *         in Team 1 such that the total number of used
         *         students is balanced as much as possible.
         *
         * Easier approach:
         * We need to choose orientation of every component.
         */

        boolean[][] dp = new boolean[components.size() + 1][n + 1];
        dp[0][0] = true;

        int total = 0;

        for (int i = 0; i < components.size(); i++) {

            Component c = components.get(i);

            int a = c.zero;
            int b = c.one;

            total += a + b;

            for (int x = 0; x <= n; x++) {

                if (!dp[i][x]) {
                    continue;
                }

                // Put color 0 into Team 1
                if (x + a <= n) {
                    dp[i + 1][x + a] = true;
                }

                // Put color 1 into Team 1
                if (x + b <= n) {
                    dp[i + 1][x + b] = true;
                }
            }
        }

        /*
         * Find the largest even number of students that can be
         * divided equally.
         */
        int best = 0;

        for (int team1 = 0; team1 <= total; team1++) {

            if (!dp[components.size()][team1]) {
                continue;
            }

            int team2 = total - team1;

            if (team1 == team2) {
                best = total;
                break;
            }
        }

        /*
         * Odd cycles need one student removed each.
         * If the remaining students can be balanced, count those.
         */
        if (removed > 0) {
            /*
             * Since each odd cycle loses one student,
             * the remaining graph is bipartite.
             *
             * For this problem's degree <= 2 constraint,
             * removing one vertex from every odd cycle is sufficient.
             */
            total += 0; // kept for clarity
        }

        // Recalculate with removed students.
        int answer = n - (best + removed);

        System.out.println(answer);
    }
}
    

