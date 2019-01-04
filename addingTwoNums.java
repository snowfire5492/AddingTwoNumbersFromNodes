//You are given two non-empty linked lists representing two non-negative 
integers. The digits are stored in reverse order and each of their nodes 
contain a single digit. Add the two numbers and return it as a linked 
list.
//
//You may assume the two numbers do not contain any leading zero, except 
the number 0 itself.
//
//Example:
//
//Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
//Output: 7 -> 0 -> 8
//Explanation: 342 + 465 = 807.


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class addingTwoNums {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		
		ListNode head = new ListNode(0); // using a "dummy" head 
init at 0 in order to simplify code from extra conditional statements
		ListNode listOne = l1, listTwo = l2, currentList = head;	
// creating lists to work with
		int carry = 0;					// will 
need a carry value to store values of 1 when the sum >= 10
		
		while(listOne != null || listTwo != null) {	// while 
either list has a node that exists 
			
			int firstVal = (listOne != null) ? listOne.val : 
0;	// getting firstValue if one exists
			int secVal = (listTwo != null) ? listTwo.val : 
0;	// getting secondValue if one exists
			
			int sum = firstVal + secVal + carry;				
// getting sum. need to include carry value if one exists
			
			carry = sum / 10;									
// getting a new carry value. will only be 1 if sum >= 10
			
			currentList.next = new ListNode(sum % 10);			
// gets only first digit and creates a new listnode with it
			
			currentList = currentList.next;						
// go to next listNode
			
			if(listOne != null) listOne = listOne.next;			
// go to next listNode if current node exists
			if(listTwo != null) listTwo = listTwo.next;			
// go to next listNode if current node exists
				
		}
		
		if(carry > 0) currentList.next = new ListNode(carry);
		
		
		return head.next;
	}
}

