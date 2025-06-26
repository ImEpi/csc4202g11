package greedy;

import java.util.*;

public class TspDP {
    public static int tspDP(int[][] dist) {
        int n = dist.length;
        int[][] dp = new int[1 << n][n];
        int[][] parent = new int[1 << n][n]; // to reconstruct path

        for (int[] row : dp)
            Arrays.fill(row, Integer.MAX_VALUE / 2);
        for (int[] row : parent)
            Arrays.fill(row, -1);

        dp[1][0] = 0;

        for (int mask = 1; mask < (1 << n); mask++) {
            for (int u = 0; u < n; u++) {
                if ((mask & (1 << u)) == 0) continue;
                for (int v = 0; v < n; v++) {
                    if ((mask & (1 << v)) != 0) continue;
                    int nextMask = mask | (1 << v);
                    int newCost = dp[mask][u] + dist[u][v];
                    if (newCost < dp[nextMask][v]) {
                        dp[nextMask][v] = newCost;
                        parent[nextMask][v] = u;
                    }
                }
            }
        }

        int minCost = Integer.MAX_VALUE;
        int last = -1;
        int fullMask = (1 << n) - 1;

        for (int i = 1; i < n; i++) {
            int cost = dp[fullMask][i] + dist[i][0];
            if (cost < minCost) {
                minCost = cost;
                last = i;
            }
        }

        // Reconstruct path
        List<Integer> path = new ArrayList<>();
        int mask = fullMask;
        while (last != -1) {
            path.add(last);
            int temp = parent[mask][last];
            mask ^= (1 << last);
            last = temp;
        }
        path.add(0); // start
        Collections.reverse(path);
        path.add(0); // return to hub

        // Print route
        System.out.print("DP Route: ");
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i));
            if (i < path.size() - 1) System.out.print(" -> ");
        }
        System.out.println();

        System.out.println("DP Route Cost: " + minCost);
        return minCost;
    }
}

