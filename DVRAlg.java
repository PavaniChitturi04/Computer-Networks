import java.util.Arrays;
public class DVRAlg {
private static final int NUM_NODES = 4;
private static final int[][] networkTopology = {
{0, 1, 3, Integer.MAX_VALUE},
{1, 0, 1, 2},
{3, 1, 0, 1},
{Integer.MAX_VALUE, 2, 1, 0}
};
private static final int[][] routingTable = new int[NUM_NODES][NUM_NODES];

public static void main(String[] args) {
for (int i = 0; i < NUM_NODES; i++) {
for (int j = 0; j < NUM_NODES; j++) {
routingTable[i][j] = networkTopology[i][j];
}
}
boolean updated;
int iteration = 1;
do {
updated = false;
System.out.println("Iteration: " + iteration++);
for (int i = 0; i < NUM_NODES; i++) {
for (int j = 0; j <NUM_NODES; j++) {
int minDist = routingTable[i][j];
for (int k = 0; k < NUM_NODES; k++) {
if (routingTable[i][k] == Integer.MAX_VALUE || networkTopology[k][j] ==
Integer.MAX_VALUE) {
continue;
}
int newDist = routingTable[i][k] + networkTopology[k][j];
if (newDist < minDist) {
minDist = newDist;
routingTable[i][j] = newDist;
updated = true;
}
}
}
}
printRoutingTable();
} while (updated);
System.out.println("\nFinal Routing Table:");
printRoutingTable();
}
private static void printRoutingTable() {
for (int i = 0; i< NUM_NODES; i++) {
System.out.printf("Routing table for Node %d:\n", i);
for (int j = 0; j < NUM_NODES; j++) {
if (routingTable[i][j] == Integer.MAX_VALUE) {
System.out.printf("Destination: %d, Distance: Infinity\n", j);
} else {
System.out.printf("Destination: %d, Distance: %d\n", j, routingTable[i][j]);
}
}
System.out.println();
}
}
}
