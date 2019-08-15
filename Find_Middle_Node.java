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
	
	char FindMidNode () {
		node slow = head;
		node fast = head;
		if (head != null) {
			while (fast != null && fast.next != null) {
				slow = slow.next;
				fast = fast.next.next;
			}
		}
		return slow.data;
	}

	public static void main(String[] args) {
		MyLinkedList ll = new MyLinkedList();
		String str = "LEVEL";
		for (int i =0; i< str.length(); i++)
			ll.addNode(str.charAt(i));
		ll.printList();
		System.out.println("MidNode= " + ll.FindMidNode());
	}
}
