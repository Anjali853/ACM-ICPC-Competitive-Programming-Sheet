import java.util.Scanner;

public class TheSeasonalWar {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int imageNumber = 1;

        while (sc.hasNextInt()) {

            int n = sc.nextInt();

            String[] grid = new String[n];

            // Grid input
            for (int i = 0; i < n; i++) {
                grid[i] = sc.next();
            }

            int count = 0;

            // Traverse the complete grid
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {

                    if (grid[i].charAt(j) == '1') {

                        // New eagle found
                        count++;

                        // Mark the complete connected eagle
                        markConnected(grid, i, j, n);
                    }
                }
            }

            System.out.println(
                    "Image number " + imageNumber +
                            " contains " + count + " war eagles.");

            imageNumber++;
        }

        sc.close();
    }

    // DFS: checks all 8 directions
    private static void markConnected(
            String[] grid, int row, int col, int n) {

        // Boundary check
        if (row < 0 || row >= n ||
                col < 0 || col >= n ||
                grid[row].charAt(col) != '1') {
            return;
        }

        // Mark current cell as visited
        StringBuilder line = new StringBuilder(grid[row]);
        line.setCharAt(col, '0');
        grid[row] = line.toString();

        // Check all 8 directions
        for (int rowDelta = -1; rowDelta <= 1; rowDelta++) {

            for (int colDelta = -1; colDelta <= 1; colDelta++) {

                // Don't check the current cell itself
                if (rowDelta != 0 || colDelta != 0) {

                    markConnected(
                            grid,
                            row + rowDelta,
                            col + colDelta,
                            n);
                }
            }
        }
    }
}