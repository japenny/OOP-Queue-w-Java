public class PetOwner {

	/* Attributes **********************************************/
	private String name; 
	private boolean cat; // true if the pet is a cat
	private String petName;
	
	/* Constructors **********************************************/
	public PetOwner() {}

	public PetOwner(String name, boolean cat, String petName) {
		super();
		this.name = name;
		this.cat = cat;
		this.petName = petName;
	}

	/* Getters & Setters ****************************************/
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the cat
	 */
	public boolean isCat() {
		return cat;
	}

	/**
	 * @return the petName
	 */
	public String getPetName() {
		return petName;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param cat the cat to set
	 */
	public void setCat(boolean cat) {
		this.cat = cat;
	}

	/**
	 * @param petName the petName to set
	 */
	public void setPetName(String petName) {
		this.petName = petName;
	} 
	
	/* Other methods ********************************************/
	
	/* PRINTS */
	public void print() {
		System.out.print(name);
		if (cat) System.out.println("This person has a cat named " + petName);
		else System.out.println("This person has an unidentified pet named " + petName);
	}
	
	/* TOSTRING */
	public String toString() {
		String result = name;
		if (cat) result += " This person has a cat named ";
		else result += " This person has an unidentified pet named ";
		result += petName + "\n";
		return result;
	}
	
}
