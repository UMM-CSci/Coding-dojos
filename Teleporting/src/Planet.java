import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

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
		int totalDistance = 0;

		for (int i = 0; i < planets.length; i++) {
			for (int j = (i + 1); j < planets.length; j++) {
				edges.add(new Edge(planets[i], planets[j]));
			}
		}
		
		

		// for (int i = 0; i < planets.length-1; i++) {
		// // take planet i and find the distance between this planet and each
		// other planet *after* it.
		// int[] distances = new int[planets.length-2];
		// for (int j = 1; j < planets.length-1; j++) {
		// //
		// }
		// }
		//

		return edges.poll().distance;
	}

}
