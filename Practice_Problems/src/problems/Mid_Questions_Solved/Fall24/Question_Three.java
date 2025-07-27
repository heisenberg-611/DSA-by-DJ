package problems.Mid_Questions_Solved.Fall24;
import utils.Stack;
public class Question_Three {
    public static void print_total_task(int[][] tasks) {
        Stack startStack = new Stack();
        Stack endStack = new Stack();

        int currentStart = tasks[0][0];
        int currentEnd = tasks[0][1];

        for (int i = 1; i < tasks.length; i++) {
            int nextStart = tasks[i][0];
            int nextEnd = tasks[i][1];

            if (nextStart <= currentEnd) {
                // Merge tasks
                currentEnd = Math.max(currentEnd, nextEnd);
            } else {
                // Push the merged task
                startStack.push(currentStart);
                endStack.push(currentEnd);

                // Start new merge group
                currentStart = nextStart;
                currentEnd = nextEnd;
            }
        }

        // Push the final merged task
        startStack.push(currentStart);
        endStack.push(currentEnd);

        // Print in decreasing order of start time
        Stack printStart = new Stack();
        Stack printEnd = new Stack();

        while (!startStack.isEmpty()) {
            printStart.push(startStack.pop());
            printEnd.push(endStack.pop());
        }

        while (!printStart.isEmpty()) {
            System.out.println(printStart.pop() + " " + printEnd.pop());
        }
    }
    public static void main(String[] args) {
        int[][] tasks = {
            {1, 5},
            {2, 3},
            {4, 6},
            {7, 10},
            {9, 11},
            {12, 15}
        };

        print_total_task(tasks);
    }
}
