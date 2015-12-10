import java.util.Hashtable;
import java.util.LinkedHashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Planet {
	public int x;
	public int y;
	public int z;

	public Planet(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static int distance(Planet first, Planet second) {
		int xDistance = Math.abs(first.x - second.x);
		int yDistance = Math.abs(first.y - second.y);
		int zDistance = Math.abs(first.z - second.z);

		return Math.min(Math.min(xDistance, yDistance), zDistance);
	}

	public static int minTotalDistance(Planet[] planets) {
		PriorityQueue<Edge> edges = new PriorityQueue<Edge>();

		for (int i = 0; i < planets.length; i++) {
			for (int j = (i + 1); j < planets.length; j++) {
				edges.add(new Edge(planets[i], planets[j]));
			}
		}

		Hashtable<Planet, Set<Edge>> subTrees = new Hashtable<Planet, Set<Edge>>(
				planets.length);

		while (!edges.isEmpty()) {
			Edge currentEdge = edges.poll();
			Set<Edge> fromTree = subTrees.get(currentEdge.fromPlanet);
			Set<Edge> toTree = subTrees.get(currentEdge.toPlanet);

			// handle nulls?

			if (fromTree == null) {
				if (toTree == null) {// both are null => new blob of connected
										// nodes
					fromTree = new LinkedHashSet<Edge>();
					fromTree.add(currentEdge);
					subTrees.put(currentEdge.toPlanet, fromTree);
				} else {// add this new edge to the toTree blob
					toTree.add(currentEdge);
					subTrees.put(currentEdge.fromPlanet, toTree);
				}
			} else if (toTree == null) {// add this new edge to the fromTree
										// blob
				fromTree.add(currentEdge);
				subTrees.put(currentEdge.toPlanet, fromTree);
			} else if (toTree != fromTree) {// they aren't the same, merge them
				fromTree.addAll(toTree);
				for (Edge thisEdge : toTree) {
					subTrees.put(thisEdge.fromPlanet, fromTree);
					subTrees.put(thisEdge.toPlanet, fromTree);
				}
				fromTree.add(currentEdge);
			}// else, we must have both planets covered. Next Edge!!
		}

		Set<Edge> spanningTree = subTrees.get(planets[0]);
		int result = 0;
		for (Edge thisEdge : spanningTree) {
			result += thisEdge.distance;
		}
		return result;

	}

}
