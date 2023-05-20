package practice;

import java.util.ArrayList;
import java.util.Scanner;

public class TaskQueue {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		ArrayList<String> oldQueue = new ArrayList<>();

		int oldQueueSize = sc.nextInt();

		for (int i = 0; i < oldQueueSize; i++) {
			oldQueue.add(sc.nextLine());
		}
		sc.nextLine();
		int currentIndex = sc.nextInt();
		String currentIndexMember = oldQueue.get(currentIndex - 1);
		int noOfInactiveMember = sc.nextInt();
		sc.nextLine();
		ArrayList<String> inactiveMember = new ArrayList<>();

		for (int k = 0; k < noOfInactiveMember; k++) {
			inactiveMember.add(sc.nextLine());
		}

		int ans = -1;

		int countOfDeletedMember = 0;

		if (inactiveMember.contains(currentIndexMember)) {
			for (int i = 0; i < currentIndex; i++) {
				if (inactiveMember.contains(oldQueue.get(i))) {
					countOfDeletedMember++;
				}
			}
			ans = currentIndex - countOfDeletedMember + 1;
		} else {
			for (int i = 0; i < currentIndex; i++) {
				if (inactiveMember.contains(oldQueue.get(i))) {
					countOfDeletedMember++;
				}
			}
			ans = currentIndex - countOfDeletedMember;
		}
		oldQueue.removeAll(inactiveMember);
		System.out.println("The New Index is : " + ans);
	}
}
