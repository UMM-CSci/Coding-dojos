

public class Person {
	String name;
	Integer age;
	String color;
	String iceCream;
	String city;
	
	
	public Person(String name, Integer age,
			String color, String iceCream, String city) {
		this.name = name;
		this.age = age;
		this.iceCream = iceCream;
		this.city = city;
		this.color = color;
	}
	
	public Person(String[] personAttributes){
		this(personAttributes[0].trim(), Integer.parseInt(personAttributes[1].trim()), personAttributes[2].trim(),
				personAttributes[3].trim(), personAttributes[4].trim());
	}

	public String getName() {
		return name;
	}

	public Integer getAge() {
		return age;
	}

	public String getColor() {
		return color;
	}

	public String getIceCream() {
		return iceCream;
	}

	public String getCity() {
		return city;
	}
	
	
	
	

	
	
}
