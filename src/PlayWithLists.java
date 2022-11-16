
public class PlayWithLists {

	public static void main(String[] args) {

		/* Two lists:
		 * 	- one with Cats
		 * 	- one with PetOwners
		 */

        Cat Timmy = new Cat("Timmy");
		Cat Bobby = new Cat("Bobby");
		Cat Floppy = new Cat("Floppy");
		Cat Strange = new Cat("Strange");
		PetOwner Steven = new PetOwner("Steven", true,"Strange");
		PetOwner Bob = new PetOwner("Bob", false, "Bobby");
		PetOwner Bill = new PetOwner("Bill", true, "Floppy");
        PetOwner John = new PetOwner("John", true, "Timmy");

		/* Prints out each list
		 * by using the appropriate method from
		 * the class Nodes
		 */

		Node<Cat> Herd = new Node<Cat>(Timmy);
		Herd.addTail(Bobby);
		Herd.addTail(Floppy);
		Herd.addTail(Strange);

		Node<PetOwner> Friends = new Node<PetOwner>(Steven);
		Friends.addTail(Bob);
		Friends.addTail(Bill);
		Friends.addTail(John);

		String herdstr = Herd.toString();
		String fristr = Friends.toString();

		System.out.println(herdstr);
		System.out.println(fristr);
	}

}
