public class Cat {

	/* Attributes **********************************************/
	private String breed; 
	private String name;
	private int age;
	
	/* Constructors **********************************************/
	public Cat() {} 
	
	public Cat(int num) {
		age = num;
	}
	
	public Cat(String name) {
		this.name = name;
	}
	
	public Cat(String breed, String name, int age) {
		this.breed = breed;
		this.name = name;
		this.age = age;
	}
	
	/* Getters & Setters ****************************************/
	/**
	 * @return the breed
	 */
	public String getBreed() {
		return breed;
	}

	/**
	 * @param breed the breed to set
	 */
	public void setBreed(String breed) {
		this.breed = breed;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}	
	
	
	/* Other methods ********************************************/
	
	/* MEOW */
	public void meows() {
		System.out.println("meow");
	}
	
	/* PLAYS */
	public void plays() {
		System.out.println("It really depends on the cat");
	}
	
	/* PRINTS */
	public void print() {
		System.out.print(name);
		if (breed != null) System.out.print(": " + breed);
		if (age != 0) System.out.print(" of " + age + " year(s)");
		System.out.println();
	}
	
	/* TOSTRING */
	public String toString() {
		String result = name;
		if (breed != null) result += ": " + breed;
		if (age != 0) result += " of " + age + " year(s)";
		//result += "\n";
		return result;
	}
}
