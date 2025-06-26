package greedy;

import java.util.Arrays;

public class TspGreedy {

    public static int tspGreedy(int[][] dist, int start) {
        int n = dist.length;
        boolean[] visited = new boolean[n];
        int[] route = new int[n + 1];

        int totalCost = 0;
        int current = start;
        visited[current] = true;
        route[0] = current;

        for (int i = 1; i < n; i++) {
            int next = -1;
            int minDist = Integer.MAX_VALUE;

            for (int j = 0; j < n; j++) {
                if (!visited[j] && dist[current][j] < minDist) {
                    minDist = dist[current][j];
                    next = j;
                }
            }

            visited[next] = true;
            route[i] = next;
            totalCost += minDist;
            current = next;
        }

        // Return to start (optional — comment this out if not needed)
        totalCost += dist[current][start];
        route[n] = start;

        // Output route
        System.out.print("Greedy Route: ");
        for (int i = 0; i <= n; i++) {
            System.out.print(route[i] + (i < n ? " -> " : "\n"));
        }

        System.out.println("Greedy Route Cost: " + totalCost);
        return totalCost;
    }
}

