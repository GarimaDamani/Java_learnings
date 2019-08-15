
public class MyLinkedList {
	class node {
		char data;
		node next;

		public node (char data) {
			this.data = data;
			next = null;
		}
	} // End of node 
	node head;

	void addNode (char value) {
		node newNode = new node(value);
		newNode.next = head;
		head = newNode;
	}

	void printList () {
		node temp = head;
		while (temp != null) {
			System.out.print(temp.data + "->");
			temp = temp.next;
		}
		System.out.println("null");
	}
	
	boolean IsPalindrome () {
		boolean status = true;
		node middle_node = null; // In case of odd nodes
		node prev_slow_node = head;
		node slow = head;
		node fast = head;

		if (head != null) {
			while (fast != null && fast.next != null) {
				prev_slow_node = slow;
				slow = slow.next;
				fast = fast.next.next;
			}
		}
		//fast will become null if even nodes
		//fast not null means odd nodes. there are odd nodes.
		if (fast != null) {
			middle_node = slow;
			slow = slow.next;
		}
		
		node second_half = slow;
		prev_slow_node.next = null;
		second_half = reverse (second_half);
		status = CompareList (head, second_half);
		
		second_half = reverse (second_half);
		if (middle_node != null) {
			prev_slow_node.next = middle_node;
			middle_node.next = second_half;
		}
		else {
			prev_slow_node.next = second_half;
		}
		return status;
	}
	
	node reverse (node second_half) {
		node prev = null;
		node current = second_half;
		node next;
		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		second_half = prev;
		return second_half;
	}
	
	boolean CompareList (node head, node second_half) {
		boolean status = true;
		node list1 = head;
		node list2 = second_half;
		if (list1 == null && list2 == null)
			status = true;
		else {
			while (list1 != null && list2 != null) {
				if (list1.data == list2.data) {
					list1 = list1.next;
					list2 = list2.next;
				}
				else 
					return status = false;
			}
		}
		return status;
	}

	public static void main(String[] args) {
		MyLinkedList ll = new MyLinkedList();
		String str = "REFER";
		for (int i=str.length()-1; i >= 0; i--) {
			ll.addNode(str.charAt(i));
		}
		ll.printList();
		System.out.println("IsPalindrome= " + ll.IsPalindrome());
	}
}
