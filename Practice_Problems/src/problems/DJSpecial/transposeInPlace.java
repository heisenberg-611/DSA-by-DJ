package problems.DJSpecial;

import arr.Arr;
public class transposeInPlace {
    public static void transposeInPlace(Object[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < m; j++) {
                Object temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        Object[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        transposeInPlace(matrix);
        Arr.print2D(matrix);
    }
}