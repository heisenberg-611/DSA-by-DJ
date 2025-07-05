public class Bux_Lecture_1_p3 {
    public static void main(String[] args) {
        int []a = {10,20,30,40,50,60};
        System.out.println(a[0]);
        printArray(a);
        System.out.println(a[0]);
    }
    public static void printArray(int[] y) {
        for(int x : y) {
            System.out.println(x);
        }
        y[0] = 250;
    }
}