//Reversing an array in place
public class Bux_Lecture_2_ex_2 {
    public static void main(String[] args) {
        int []source = {10,20,30,40,50,60};
        printArray(source);
        reverseinplace(source);
        printArray(source);
    }
    public static void reverseinplace(int[] source){
        int n = source.length;
        for(int i = 0; i < n/2; i++) {
            int temp = source[i];
            source[i] = source[n - 1 - i];
            source[n - 1 - i] = temp;
        }
    }
    public static void printArray(int[] y) {
        for(int x : y) {
            System.out.print(x);
            System.out.print(", ");
        }
    }
}