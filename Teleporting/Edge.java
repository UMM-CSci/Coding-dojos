
public class Edge {
	public Planet toPlanet;
	public Planet fromPlanet;
	public int distance;
	
	public Edge(Planet fromPlanet, Planet toPlanet, int distance) {
		this.toPlanet = toPlanet;
		this.fromPlanet = fromPlanet;
		this.distance = distance;
	}

}
