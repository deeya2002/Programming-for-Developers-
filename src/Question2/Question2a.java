package Question2;

//Question 2 a)

import java.util.*;

public class Question2a {

    // Method to find the greatest common divisor (GCD) of two numbers using Euclid's algorithm
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

    // Method to find the nearest ancestor with relative prime value
    public static int nearest(int[] values, int[][] edges, int node) {
        // Base case: If the current node is the root node (i.e., has no parent)
        if (node == 0) {
            return -1;
        }

        int parent = -1;
        int gcdValue = 0;

        // Traverse the path from the current node to the root node
        while (node != 0 && gcdValue != 1) {
            // Find the parent of the current node
            for (int i = 0; i < edges.length; i++) {
                if (edges[i][1] == node) {
                    parent = edges[i][0];
                    break;
                }
            }
            gcdValue = gcd(values[node], values[parent]);
            node = parent;
        }

        if (gcdValue == 1) {
            return parent;
        } else {
            return -1;
        }
    }

    // Main method to find the nearest ancestors for all nodes
    public static int[] nearestAncestors(int[] values, int[][] edges) {
        int n = values.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);

        // Iterate over all nodes and find their nearest ancestor with relative prime value
        for (int i = 0; i < n; i++) {
            result[i] = nearest(values, edges, i);
        }

        return result;
    }

    // Main method to test the solution
    public static void main(String[] args) {
        int[] values = {3, 2, 6, 6, 4, 7, 12};
        int[][] edges = {{0, 1}, {0, 2}, {1, 3}, {1, 4}, {2, 5}, {2, 6}};
        int[] result = nearestAncestors(values, edges);

        // Print the result
        System.out.println(Arrays.toString(result));
    }
}
//class Solution {
//    public int gcd(int n1, int n2) {
//        if (n2 == 0) {
//            return n1;
//        }
//        return gcd(n2, n1 % n2);
//    }
//
//    public void dfs(int[] nums, LinkedList<Integer>[] tree, int depth, int node, boolean[] visited, int[] ans, Map<Integer, int[]> map, boolean[][] poss) {
//        if (visited[node]) return;
//        visited[node] = true;
//        int ancestor = -1;
//        int d = Integer.MAX_VALUE;
//        for (int i = 1; i < 51; i++) {
//            if (poss[nums[node]][i] && map.containsKey(i)) {
//                if (depth - map.get(i)[0] <= d) {
//                    d = depth - map.get(i)[0];
//                    ancestor = map.get(i)[1];
//                }
//            }
//        }
//        ans[node] = ancestor;
//        int[] exist = (map.containsKey(nums[node])) ? map.get(nums[node]) : new int[]{-1, -1};
//        map.put(nums[node], new int[]{depth, node});
//        for (int child : tree[node]) {
//            if (visited[child]) continue;
//            dfs();
//        }
//    }
//}
//2a
