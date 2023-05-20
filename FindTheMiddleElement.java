package practice;

import java.util.Scanner;

public class FindTheMiddleElement {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		LinkedList list = new LinkedList();
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			list.insert(sc.nextInt());
		}
		sc.close();

		int middleElement = list.getMiddle();
		System.out.println("Middle element: " + middleElement);
	}
}

class Node {
	int data;
	Node next;

	public Node(int data) {
		this.data = data;
		this.next = null;
	}
}

class LinkedList {
	Node head;

	public void insert(int data) {
		Node newNode = new Node(data);

		if (head == null) {
			head = newNode;
		} else {
			Node current = head;
			while (current.next != null) {
				current = current.next;
			}
			current.next = newNode;
		}
	}

	public int getMiddle() {
		
		if (head == null) {
			throw new IllegalStateException("Linked list is empty");
		}

		Node slowPtr = head;
		Node fastPtr = head;

		while (fastPtr != null && fastPtr.next != null) {
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;
		}

		return slowPtr.data;
	}
}
