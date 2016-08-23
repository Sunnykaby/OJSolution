package com.kami.leetcode;

import java.util.List;

public class Leetcode_23 {
	public ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length == 0) {
			return null;
		}
		return mergeLists(lists, 0,lists.length-1);
	}

	public ListNode mergeLists(ListNode[] listNodes, int left, int right){
		if ((left + 1) == right) {
			return mergerTwoList(listNodes[left], listNodes[right]);
		}
		if (left == right) {
			return listNodes[left];
		}
		else return mergerTwoList(mergeLists(listNodes, left, left+(right-left)/2), 
				mergeLists(listNodes, left+(right-left)/2 + 1, right));
	}

	public ListNode mergerTwoList(ListNode left, ListNode right){
		if (left == null) {
			return right;
		}
		if (right == null) {
			return left;
		}
		ListNode leftIterator = left;
		ListNode rightIterator = right;
		ListNode result = new ListNode(0);//先初始化一个节点,返回的时候在去掉
		ListNode tail = result;

		while(leftIterator!=null&&rightIterator!=null){
			if (leftIterator.val <= rightIterator.val) {//考虑有重复的情况
				tail.next = leftIterator;
				leftIterator = leftIterator.next;
			}
			else if (leftIterator.val > rightIterator.val){
				tail.next = rightIterator;
				rightIterator = rightIterator.next;
			}
			tail = tail.next;
		}
		if (rightIterator!=null) {
			tail.next = rightIterator;
		}
		if (leftIterator!=null) {
			tail.next = leftIterator;
		}
		return result.next;

	}

	public static void main(String[] args){
		ListNode[] src = new ListNode[3];
		src[1] = null;
		src[0] = new ListNode(2);
		src[2] = new ListNode(-1);
		Leetcode_23 leetcode_23 = new Leetcode_23();
		System.out.println(leetcode_23.mergeKLists(src));
	}
}
