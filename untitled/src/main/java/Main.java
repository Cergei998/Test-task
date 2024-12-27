import java.util.Map;
import second_task.CityGraph;

public class Main {

    public static void main(String[] args) {
        CityGraph cityGraph = new CityGraph();
        cityGraph.addConnection("a", "b", 4);
        cityGraph.addConnection("a", "c", 2);
        cityGraph.addConnection("b", "c", 5);
        cityGraph.addConnection("b", "d", 10);
        cityGraph.addConnection("c", "d", 3);
        cityGraph.addConnection("d", "e", 11);

        Map<String, Map<String, Integer>> shortestPaths = cityGraph.findAllShortestPaths();

        for (String startCity : shortestPaths.keySet()) {
            System.out.println("Shortest paths from " + startCity + ":");
            for (Map.Entry<String, Integer> entry : shortestPaths.get(startCity).entrySet()) {
                System.out.println("  to " + entry.getKey() + " -> " + entry.getValue());
            }
        }
    }
}
