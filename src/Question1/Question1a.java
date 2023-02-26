package Question1;
//Question 1 a)
import java.util.*;


class Country {
    int id;
    int time;
    int cost;

    public Country(int id, int time, int cost) {
        this.id = id;
        this.time = time;
        this.cost = cost;
    }
}

class Question1a {
    public static int findCheapestRoute(int[][] edges, int[] charges, int source, int destination, int timeConstraint) {
        // Create a graph represented as an adjacency list
        Map<Integer, List<Country>> graph = new HashMap<>();
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            int time = edge[2];
            int cost = charges[to];
            List<Country> list = graph.getOrDefault(from, new ArrayList<>());
            list.add(new Country(to, time, cost));
            graph.put(from, list);
        }

        // Initialize the distances and visited flags
        int[] distances = new int[charges.length];
        boolean[] visited = new boolean[charges.length];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[source] = 0;

        // Use a priority queue to select the node with the smallest distance
        PriorityQueue<Country> queue = new PriorityQueue<>((a, b) -> a.time - b.time);
        queue.offer(new Country(source, 0, charges[source]));

        // Dijkstra's algorithm with a time constraint
        while (!queue.isEmpty()) {
            // Get the node with the smallest distance
            Country curr = queue.poll();
            // If we've reached the destination node, return the cost to get there
            if (curr.id == destination) {
                return curr.cost;
            }
            // If we've already visited this node, skip it
            if (visited[curr.id]) {
                continue;
            }
            visited[curr.id] = true;
            // Iterate through the neighbors of the current node
            for (Country neighbor : graph.getOrDefault(curr.id, new ArrayList<>())) {
                int newTime = curr.time + neighbor.time;
                int newCost = curr.cost + charges[neighbor.id];
                // If the new time and cost to reach this neighbor are better than what we've seen before, update our data structures
                if (newTime <= timeConstraint && newCost < distances[neighbor.id]) {
                    distances[neighbor.id] = newCost;
                    queue.offer(new Country(neighbor.id, newTime, newCost));
                }
            }
        }

        // If we reach this point, we couldn't find a path from the source to the destination within the time constraint
        return -1;
    }

    public static void main(String[] args) {
        // Sample input for testing
        int a [][]={{0,1,5}, {0,3,2}, {1,2,5}, {3,4,5}, {4,5,6}, {2,5,5}};
        int[] charges = new int[]{10, 2, 3, 25, 25, 4};
        int source = 0;
        int destination = 5;
        int timeConstraint = 14;
        // Call the function and print the result
        System.out.println(findCheapestRoute(a, charges, source, destination, timeConstraint));
    }
}



