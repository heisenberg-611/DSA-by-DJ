package problems.LinkedList.SWG;

public class saddlePoints {
    public static int saddlePoint(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        for (int i = 0; i < n; i++) {
            int min = matrix[i][0];
            int min_Col_index = 0;
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] < min) {
                    min = matrix[i][j];
                    min_Col_index = j;
                }
            }
            int max = matrix[0][min_Col_index];
            for (int k = 0; k < n; k++) {
                if (matrix[k][min_Col_index] > max) {
                    max = matrix[k][min_Col_index];
                }
            }
            if (max == min) {
                return max;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] matrix2 = { {3,8,7,6,5}, {9,4,3,2,1}, {10,15,12,11,8}, {14,13,9,7,6} };
        System.out.println(saddlePoint(matrix2));
    }
}