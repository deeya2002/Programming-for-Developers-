package Question8;
//Question 8 a)
import java.util.Stack;
class Question8a {
    public static int maxSquareArea(int[][] matrix) {
        int m = matrix.length; // number of rows in the matrix
        int n = matrix[0].length; // number of columns in the matrix
        int[] heights = new int[n + 1]; // an array to store the heights of the bars in the histogram
        int maxArea = 0; // variable to store the maximum area found so far

        // iterate over each row in the matrix
        for (int i = 0; i < m; i++) {
            Stack<Integer> stack = new Stack<>(); // create a new stack for each row

            // iterate over each column (plus one extra column) in the row
            for (int j = 0; j <= n; j++) {
                if (j < n) {
                    // if the current cell in the matrix is 0, increment the height of the corresponding bar in the histogram
                    if (matrix[i][j] == 0) {
                        heights[j]++;
                    } else {
                        // if the current cell in the matrix is 1, reset the height of the corresponding bar in the histogram to 0
                        heights[j] = 0;
                    }
                }
                // while the stack is not empty and the height of the current bar is less than the height of the bar at the top of the stack
                while (!stack.isEmpty() && heights[stack.peek()] > heights[j]) {
                    // pop the top bar from the stack and calculate the area of the largest square that can be formed using that bar as the minimum height
                    int height = heights[stack.pop()];
                    int width = stack.isEmpty() ? j : j - stack.peek() - 1;
                    maxArea = Math.max(maxArea, Math.min(height, width) * Math.min(height, width));
                }
                // push the index of the current bar onto the stack
                stack.push(j);
            }
        }
        // return the maximum area found
        return maxArea;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 0, 1, 0, 0},
                {0, 1, 1, 1, 1},
                {0, 0, 0, 0, 1},
                {0, 0, 0, 1, 1},
                {0, 1, 0, 1, 1}};
        System.out.println(maxSquareArea(matrix));

    }
}
