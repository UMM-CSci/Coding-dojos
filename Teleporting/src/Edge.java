
public class Edge implements Comparable<Edge>{
	public Planet fromPlanet;
	public Planet toPlanet;
	public int distance;
	
	public Edge(Planet fromPlanet, Planet toPlanet) {
		this.fromPlanet = fromPlanet;
	this.toPlanet = toPlanet;
	this.distance = Planet.distance(fromPlanet, toPlanet);
}

	@Override
	public int compareTo(Edge edge) {
		return this.distance - edge.distance;
	}

}
