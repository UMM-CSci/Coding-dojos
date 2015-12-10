
public class Edge implements Comparable<Edge>{
	public Planet toPlanet;
	public Planet fromPlanet;
	public int distance;
	
	public Edge(Planet fromPlanet, Planet toPlanet) {
	this.toPlanet = toPlanet;
	this.fromPlanet = fromPlanet;
	this.distance = Planet.distance(fromPlanet, toPlanet);
}

	@Override
	public int compareTo(Edge edge) {
		return this.distance - edge.distance;
	}

}
