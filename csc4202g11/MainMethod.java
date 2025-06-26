package greedy;

public class MainMethod {
    public static void main(String[] args) {
        int[][] dist = DistanceMatrix.getMatrix();
        int start = 0;

        // Measure time for Greedy
        long startTimeGreedy = System.nanoTime();
        int greedyCost = TspGreedy.tspGreedy(dist, start);
        long endTimeGreedy = System.nanoTime();
        double elapsedGreedy = (endTimeGreedy - startTimeGreedy) / 1_000_000.0;
        System.out.printf("Greedy Time Taken: %.3f ms\n", elapsedGreedy);

        System.out.println();

        // Measure time for DP
        long startTimeDP = System.nanoTime();
        int dpCost = TspDP.tspDP(dist);
        long endTimeDP = System.nanoTime();
        double elapsedDP = (endTimeDP - startTimeDP) / 1_000_000.0;
        System.out.printf("DP Time Taken: %.3f ms\n", elapsedDP);
    }
}
