package second_task;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class CityGraph {
    private Map<String, Map<String, Integer>> graph;
    public CityGraph() {
        graph = new HashMap<>();
    }

    private static class CityNode {
        String city;
        int cost;

        CityNode(String city, int cost) {
            this.city = city;
            this.cost = cost;
        }
    }

    // Add a connection between two cities with the given cost
    public void addConnection(String city1, String city2, int cost) {
        graph.putIfAbsent(city1, new HashMap<>());
        graph.putIfAbsent(city2, new HashMap<>());
        graph.get(city1).put(city2, cost);
        graph.get(city2).put(city1, cost);
    }

    // Dijkstra's algorithm to find the shortest path from a source city
    public Map<String, Integer> dijkstra(String startCity) {
        PriorityQueue<CityNode> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(node -> node.cost));
        Map<String, Integer> distances = new HashMap<>();
        Set<String> visited = new HashSet<>();

        for (String city : graph.keySet()) {
            distances.put(city, Integer.MAX_VALUE);
        }
        distances.put(startCity, 0);
        priorityQueue.add(new CityNode(startCity, 0));

        while (!priorityQueue.isEmpty()) {
            CityNode currentNode = priorityQueue.poll();
            String currentCity = currentNode.city;

            if (visited.contains(currentCity)) {
                continue;
            }
            visited.add(currentCity);

            for (Map.Entry<String, Integer> neighborEntry : graph.get(currentCity).entrySet()) {
                String neighborCity = neighborEntry.getKey();
                int edgeCost = neighborEntry.getValue();
                int newDist = distances.get(currentCity) + edgeCost;

                if (newDist < distances.get(neighborCity)) {
                    distances.put(neighborCity, newDist);
                    priorityQueue.add(new CityNode(neighborCity, newDist));
                }
            }
        }
        return distances;
    }

    // Find the shortest paths between all pairs of cities
    public Map<String, Map<String, Integer>> findAllShortestPaths() {
        Map<String, Map<String, Integer>> allShortestPaths = new HashMap<>();
        for (String city : graph.keySet()) {
            allShortestPaths.put(city, dijkstra(city));
        }
        return allShortestPaths;
    }
}
