package problems.Mid_Questions_Solved.Spring25;

public class Question_One {
    public static int[][] unlockSafe(int[][] matrix, int[] combination) {
        for (int col = 0; col < 5; col++) {
            int target = combination[col], rowIndex = 0;
            while (matrix[rowIndex][col] != target) rowIndex++;

            int up = (rowIndex - 4 + 9) % 9;    // ⬅️ changed 3 ➝ 4
            int down = (4 - rowIndex + 9) % 9;

            int steps = Math.min(up, down);
            boolean rotateUp = (up <= down);

            while (steps-- > 0) {
                if (rotateUp) {
                    int temp = matrix[0][col];
                    for (int i = 0; i < 8; i++) matrix[i][col] = matrix[i + 1][col];
                    matrix[8][col] = temp;
                } else {
                    int temp = matrix[8][col];
                    for (int i = 8; i > 0; i--) matrix[i][col] = matrix[i - 1][col];
                    matrix[0][col] = temp;
                }
            }
        }
        return matrix;
    }
    public static void main(String[] args) {
        int[][] matrix = {
        {2, 8, 9, 6, 7},
        {4, 2, 5, 8, 5},
        {6, 7, 1, 4, 3},
        {9, 6, 7, 2, 9},
        {7, 9, 3, 5, 6},
        {8, 1, 6, 9, 2},
        {5, 4, 2, 7, 1},
        {3, 3, 8, 1, 4},
        {1, 5, 4, 3, 8}
    };

        int[] combination = {1,2,3,4,5};

        System.out.println("Before unlocking:");
        printMatrix(matrix);

        unlockSafe(matrix, combination);

        System.out.println("\nAfter unlocking:");
        printMatrix(matrix);
    }
    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
