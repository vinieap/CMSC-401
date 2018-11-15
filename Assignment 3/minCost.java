//Vinit Patel

import java.util.*;

public class minCost {

    private static HashMap<Integer, Node> nodes;
    private static int maxInt = Integer.MAX_VALUE;

    public static void main(String[] args) {
        readInput();
        System.out.println(dijkstrasImplementation(nodes.get(1),nodes.get(2)));
    }

    private static int dijkstrasImplementation(Node start, Node end) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(Node::getWeight));

        end.setDistanceFromSource(maxInt);
        start.setDistanceFromSource(0);
        pq.add(start);

        while(!pq.isEmpty()) {
            Node u = pq.poll();

            for(Edge e : u.getNeighbors()) {
                int vDistance = e.getN2().getWeight();
                int eDistance = e.getWeight();

                int distanceFromSource = e.getN2().getDistanceFromSource();
                int relaxedDistance = vDistance + eDistance + u.getDistanceFromSource();

                if(distanceFromSource > relaxedDistance) {
                    e.getN2().setDistanceFromSource(relaxedDistance);
                    pq.add(e.getN2());
                }
            }
        }

        return end.getDistanceFromSource();
    }

    private static void readInput() {
        nodes = new HashMap<>();

        nodes.put(1, new Node(0));
        nodes.put(2, new Node(0));

        Scanner scan = new Scanner(System.in);
        int cities = scan.nextInt();
        int highways = scan.nextInt();

        for(int i = 0; i < cities -2; i++) {
            int vertexLabel = scan.nextInt();
            nodes.put(vertexLabel,new Node(scan.nextInt()));
            nodes.get(vertexLabel).setDistanceFromSource(maxInt);
        }

        for(int j = 0; j < highways; j++) {
            Node temp1 = nodes.get(scan.nextInt());
            Node temp2 = nodes.get(scan.nextInt());
            int weight = scan.nextInt();
            temp1.addNeighbor(new Edge(temp2, weight));
            temp2.addNeighbor(new Edge(temp1, weight));
        }
    }
}

class Node {
    private int weight;
    private int distanceFromSource;
    private ArrayList<Edge> neighbors;

    Node(int weight) {
        this.weight = weight;
        this.neighbors = new ArrayList<>();
        this.distanceFromSource = 0;
    }

    public void setDistanceFromSource(int n) {
        this.distanceFromSource = n;
    }

    public int getDistanceFromSource() {
        return this.distanceFromSource;
    }

    public void addNeighbor(Edge e) {
        neighbors.add(e);
    }

    public ArrayList<Edge> getNeighbors() {
        return this.neighbors;
    }

    public int getWeight() {
        return this.weight;
    }

}

class Edge {
    private final Node n2;
    private int weight;

    Edge(Node n2, int weight) {
        this.n2 = n2;
        this.weight = weight;
    }

    public Node getN2() {
        return this.n2;
    }

    public int getWeight() {
        return this.weight;
    }
}
