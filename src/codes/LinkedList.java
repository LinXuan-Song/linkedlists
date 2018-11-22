package codes;

public class LinkedList {

	private Node first;
	private Node last;
	private int length;
	
	public LinkedList () {
		first = null;
		last = null;
		length = 0;
	}
	
	public int getLength() {
		return length;
	}
	
	public void add (int data) { // adds a number to the list
		
		Node node = new Node(data) ;
		
		if (first == null) { //when list is empty
			first = node;
		}
		else { //when there's 1 or more in list
			node.setPrevious (last);
			last.setNext (node);
		}
		
		length++;
		last = node;
		
	} //end add

	public void display () { // display the list forward and backwards

		Node node = first;
		
		while (node != null) { //prints forward
			System.out.print(node.getData() + " ");
			node = node.getNext();
		}
		
		System.out.println();
		node = last;
		
		while (node != null) { //prints backwards
			System.out.print(node.getData() + " ");
			node = node.getPrevious();
		}
		
	}// end display

	public void pop () {//deletes the last of the list
		
		if (first == null) // nothing in the list
		{}
		else if (first.getData() == last.getData()) { //one thing in the array
			last = null;
			first = null;
			length = 0;
		}
		else { // more than one in list
			last = last.getPrevious();
			last.setNext(null);
			length--;
		}
		
	}// end pop

	public void selectivePop(int input) {//deletes the first occurance of the data
		
		Node node = first;
		
		if (first == null) { // if there's nothing in the list
		}
		
		else if (first == last) {// when there's only one thing in list
			first = null;
			last = null;
			length = 0;
		}
		
		else { // when there's more than one in list
			
			while (node != null && node.getData() != input) { //finds the data in the list
				node = node.getNext();
			}
			
			if (node == null) {//not found
				System.out.println("Not in the list!");
			}
			
			else if (node == last) //if the data is last
				pop();
			
			else if (node == first) { //if the data is first
				first = first.getNext();
				first.setPrevious(null);
				length--;
			}
			
			else { //if the data is between
				node.getPrevious().setNext(node.getNext());
				node.getNext().setPrevious(node.getPrevious());
				length--;
			}
		}
		
	} //end selectivePop
	
	public int find (int data) { //finds and returns the first occurance of the data
		
		Node node = first;
		int index = 0;
		
		while (node != null && node.getData() != data) { //finds the data in the list
			node = node.getNext();
			index++;
		}
		
		return index;
		
	} //end find

	public void swap (int indexOne, int indexTwo) { // swaps two items in the list
		// the first index of the list is 0
		
		if (indexOne > indexTwo) { //makes sure that indexOne is greater than indexTwo
			swap(indexTwo,indexOne);
			return;
		}
		
		if (indexOne < 0 || indexOne > length - 1 || indexTwo < 0 || indexTwo > length - 1) { // if the index is in the list
			return;
		}
		
		else { // if the index is valid
			
			Node nodeOne = first;
			Node nodeTwo = first;
			
			for (int x = 0; x < indexOne; x++) { //sets nodeOne to be where indexOne is at
				nodeOne = nodeOne.getNext();
			}
			for (int x = 0; x < indexTwo; x++) { //sets nodeTwo to be where indexTwo is at
				nodeTwo = nodeTwo.getNext();
			}
			
			// split into: first and last, first and middle, middle and last, middle and middle
			
			boolean includeFirst = false;
			boolean includeLast = false;
			boolean adjacent = false;
			
			if (nodeOne == first) { //if one of the swapping nodes are first
				includeFirst = true;
			}
			if (nodeTwo == last) { // if one of the swapping nodes are last
				includeLast = true;
			}
			if (nodeOne.getNext() == nodeTwo) { // if they are adjacent
				adjacent = true;
			}

			// swapping start
			
			if (includeFirst && !includeLast) { // swapping first and middle
				nodeOne.getNext().setPrevious(nodeTwo);
				display();
				nodeOne.setNext(nodeTwo.getNext());
				display();
				nodeOne.setPrevious(nodeTwo.getPrevious());
				display();
				nodeTwo.getPrevious().setNext(nodeOne);
				display();
				nodeTwo.getNext().setPrevious(nodeOne);
				display();
				nodeTwo.setNext(first.getNext());
				display();
				nodeTwo.setPrevious(null);
			}
			
			else if (includeFirst && includeLast) { // swapping both first and last
				
			} //end swapping both first and last
			
		} //end if index is valid
		
	} // end swap
	
}
