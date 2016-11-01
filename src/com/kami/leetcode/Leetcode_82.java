package com.kami.leetcode;


public class Leetcode_82 {
	public ListNode deleteDuplicates(ListNode head) {
		ListNode lastNode;
		ListNode preNode = head;
		boolean repeated = false;
		if(head == null) return head;
		lastNode = preNode.next;
		while(lastNode !=null){
			if(lastNode.next != null){
				if(lastNode.val == preNode.val){
					//if the same 
					preNode.next = lastNode.next;
					repeated = true;
				}
				else {
					if(repeated){
						preNode.val = lastNode.val;
						preNode.next = lastNode.next;
						repeated = false;
					}
					else preNode = preNode.next;
				}
				lastNode = preNode.next;
			}
			else{
				if(repeated) {
					preNode.val = lastNode.val;
					preNode.next = null;
					repeated =false;
				}
				else preNode = preNode.next;
				lastNode = preNode.next;
			}
		}
		if(repeated) preNode = null;
		return head;
	}

	public static void main(String[] args) {
		Leetcode_82 leetcode_82 = new Leetcode_82();
		ListNode head = new ListNode(1);
		ListNode l2 = new ListNode(2);
		head.next = l2;
		leetcode_82.deleteDuplicates(head);
	}
}
