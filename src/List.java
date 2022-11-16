/* Files:
 * 	- Node1.java
 * 	- List.java
 * 	- Cat.java
 * 	- PetOwner.java
 * 	- PlayWithLists.java
 * 
 * Class List:
 * Generic List class that bundles a Node container -- the head of the list --
 * and the size of the list -- number of Nodes including the head
 */

import java.util.LinkedList;

public class List<T> {

	// Attributes *****************************************************************
	private Node<T> head;
	private int size;

    // Constructors ****************************************************************
	public List(T data) {
		Node<T> N = new Node<T>(data);
		this.head = N;
		this.size = 1;
	}
	
	public List(Node<T> head) {
		this.head = head;
		this.size = head.sizeFromNode();
	}
	
	public List(T[] D) {
		if (D.length == 0) {
			head = null;
			size = 0;
		}
		head = new Node<T>(D[0]);
		Node<T> iter = head;
		size = 1;
		for (int i=1; i<D.length; i++) {
			Node<T> N = new Node<T>(D[i]);
			iter.setNext(N);
			size++;
			iter = iter.getNext();
		}
	}




    // Getters **********************************************************************
	/**
	 * @return the head
	 */
	public Node<T> getHead() {
		return head;
	}
	
	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}
	
    // Setters *********************************************************************
	/**
	 * @param head the head to set
	 */
	public void setHead(Node<T> head) {
		this.head = head;
	}
	
	/**
	 * @param size the size to set
	 */
	public void setSize(int size) {
		this.size = size;
	}

		/* Implements Method addHead that takes as input data d of type T
		 * and adds a new node containing d to the list as the list's new head.
		 * It is a void method.
		 */
		public void addHead(T data) {
			Node<T> newHead = new Node<>(data);

			if(getHead() == null){
				setHead(newHead);
				setSize(1);
				return;
			}

			Node<T> oldHead = head;
			setHead(newHead);
			this.head.setNext(newHead);
			this.head.setNext(oldHead);
			setSize(getSize() + 1);
			return;

		}

		/* Implements Method addTail that takes as input data d of type T
		 * and adds a new node containing d to the list as the list's last node.
		 * It is a void method.
		 */
		public void addTail(T data) {
			Node<T> newTail = new Node<>(data);
			Node<T> curr = this.head;

			if (this.head == null){
				setHead(newTail);
				return;
			}

			while (curr.getNext() != null){
				curr = curr.getNext();
			}

			curr.setNext(newTail);
			setSize(getSize() + 1);
			return;


		}


		/* Implements Method insertAfterNth that takes an integer n
		 * and data d of type T, and that inserts a new node containing d after n nodes
		 * in the list.
		 * It is a void method.
		 */
		public void insertAfterNth(int n, T data) {
			Node<T> curr = this.head;
			Node<T> newData = new Node<>(data);

			if (curr == null || getSize() < n){
				System.out.println("Unable to add data at number given");
				return;
			}
			for(int i = 0; i < getSize(); i++){
				if(i == n){
					if(curr.getNext() != null){
						Node<T> temp = curr.getNext();
						curr.setNext(newData);
						curr.getNext().setNext(temp);

					}
					else curr.setNext(newData);

					setSize(getSize() + 1);
					return;

				}
				else curr = curr.getNext();
			}
		}

		/* Implements Method removeHead that removes the head node
		 * of the list.
		 * It is a void method.
		 */
		public void removeHead() {
			if (head == null) return;
			else if(this.head.getNext() == null)head = null;
			else setHead(this.head.getNext());

			setSize(getSize() - 1);
			return;

		}

		/* Implements Method removeTail that removes the last node
		 * of the list.
		 * It is a void method.
		 */
		public void removeTail() {
			Node<T> curr = this.head;

			if (head == null) return;
			else if (curr.getNext() == null)setHead(null);
			else {
				while (curr.getNext().getNext() != null) {
					curr = curr.getNext();
				}
				curr.setNext(null);
			}
			setSize(getSize() - 1);
			return;
		}

		/* Implements Method insertAfterNth that takes an integer n
		 * and that removes the nth node in the list.
		 * It is a void method.
		 */
		public void removeNth(int n) {
			Node<T> curr = this.head;
			if(head == null || getSize() < n) {
				System.out.println("Number cannot be located");
				return;
			}

			if(n == 0){
				if(curr.getNext() != null){
					curr.setNext(curr.getNext());
					setHead(curr.getNext());
				}
				else setHead(null);

				setSize(getSize() - 1);
				return;
			}

			for (int i = 0; i < getSize(); i++){
				if(i == n - 1){
					if(curr.getNext().getNext() != null)curr.setNext(curr.getNext().getNext());
					else curr.setNext(null);

					setSize(getSize() - 1);
					return;
				}

				else curr = curr.getNext();
			}

		}

		/* Implements Method toString that returns the content of the list
		 * traversing from head to tail, and using Method toString to convert its data to
		 * a String representation.
		 * It is a void method.
		 */

		public String toString() {
			String nodeStr = "";
			Node<T> print = this.head;

			while(print.getNext() != null){
				nodeStr += print.getData() + " ";
				print = print.getNext();
			}

			if(print.getData() == null)return nodeStr;
			return nodeStr + print.getData();
		}

		/* Implemenst Method everyOtherToString that returns the content of
		 * every other node in the list concatenated in a string.
		 * Starts by concatenating the content of the first node, skip the second,
		 * concatenate the content of the third, skip the 4th, and so on and so forth.
		 */
		public String everyOtherToString() {
			Node<T> other = this.head;
			String otherStr = "";

			if (head == null) return "Invalid, Is Null";

			while(other != null){
				otherStr += other.getData() + " ";
				if(other.getNext() == null) break;
				other = other.getNext().getNext();
			}
			return otherStr;

		}

		/* Implement Method reverseToString that returns the content of
		 * the list in reverse order (starting from the tail and all the way to the head).
		 */
		public String reverseToString() {
			Node<T> revStr = this.head;
			String [] tempstr = new String[getSize()];
			String reverse = "";

			if (head == null) return "Invalid, Is Null";
			else {
				for (int i = 0; i < getSize(); i++) {
					tempstr[i] = "" + revStr.getData();
					revStr = revStr.getNext();
				}
				for (int i = tempstr.length - 1; i >= 0; i--) {
					reverse += tempstr[i] + " ";
				}

				return reverse;
			}
		}




//		public static void printlonger(List<String> L, int min){
//			List<String> tip = L;
//
//			while(tip != null){
//				String temp = tip.getHead().getData();
//
//				if(temp.length() >= min){
//					System.out.println(temp);
//				}
//				tip = tip.getHead().getNext();
//			}
//
//		}

}
