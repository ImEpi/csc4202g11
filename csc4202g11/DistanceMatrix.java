package greedy;

public class DistanceMatrix {
    public static int[][] getMatrix() {
        return new int[][] {
        	{ 0, 13, 17, 25, 30, 29 },
            { 13, 0, 14, 22, 27, 24 },
            { 17, 14, 0, 10, 20, 19 },
            { 25, 22, 10, 0, 15, 14 },
            { 30, 27, 20, 15, 0, 11 },
            { 29, 24, 19, 14, 11, 0 }
        };
    }
}
