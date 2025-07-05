//Reversing an array
public class Bux_Lecture_2_ex_1 {
    public static void main(String[] args) {
        int []source = {10,20,30,40,50};
        source = reverse(source);
        printArray(source);
    }
    public static int[] reverse(int[] source) {
        int []reversed = new int[source.length];
        for(int i = 0; i < source.length; i++) {
            reversed[i] = source[source.length - 1 - i];
        }
        return reversed;
    }
    public static void printArray(int[] y) {
        for(int x : y) {
            System.out.println(x);
        }
    }
}