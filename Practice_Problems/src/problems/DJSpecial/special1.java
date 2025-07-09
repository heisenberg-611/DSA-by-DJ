package problems.DJSpecial;

public class special1 {
    /* Given a 2D integer matrix, write a 
    function to calculate the sum of the 
    top row and the sum of the last column, 
    then subtract the sum of the secondary 
    diagonal from this total and return the result.
    */
    public static int spec1(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int sum = 0;
        for (int j = 0; j < m; j++) {
            sum += matrix[0][j];
        }
        for (int i = 1; i < n; i++) {
            sum += matrix[i][m - 1];
        }
        for (int i = 0; i < n; i++) {
            sum -= matrix[i][(m - 1) - i];
        }
        return sum;
    }
    public static void main(String[] args) {
        // Your code here
        int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        System.out.println(spec1(matrix));
    }
}