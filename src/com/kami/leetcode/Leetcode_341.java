package com.kami.leetcode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;


//Flatten Nested List Iterator

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */

public class Leetcode_341 {

	public static void main(String[] args){
		Leetcode_341 temp = new Leetcode_341();
		char[] chars = "123123".toCharArray();
		int a = chars[0];
		System.out.println(chars[0]);
	}
}


/**
 * iterate and initialize the data and queue at the class instantiated
 * @author shidian
 *
 */
class NestedIterator implements Iterator<Integer>{
	
	Queue<Integer> queue;
	
	public NestedIterator(List<NestedInteger> nestedList) {
		queue = new LinkedList<>();
		if (nestedList!=null) {
			for (Iterator iterator = nestedList.iterator(); iterator.hasNext();) {
				NestedInteger nestedInteger = (NestedInteger) iterator.next();
				updateQueue(nestedInteger);
			}
		}
	}
	
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return !queue.isEmpty();
	}

	@Override
	public Integer next() {
		// TODO Auto-generated method stub
		return queue.poll();
	}
	
	/**
	 * iterate the data to queue
	 * @param nestedInteger
	 */
	private void updateQueue(NestedInteger nestedInteger){
		if (nestedInteger == null) {
			return;
		}
		if (nestedInteger.isInteger()) {
			queue.offer(nestedInteger.getInteger());
		}
		else {
			List<NestedInteger> nestedIntegers = nestedInteger.getList();
			for (Iterator iterator = nestedIntegers.iterator(); iterator.hasNext();) {
				NestedInteger temp = (NestedInteger) iterator.next();
				updateQueue(temp);
			}
		}
	}

}

/**
 * take the number when it needed, qith stack
 * no recursive
 * @author shidian
 *
 */
class NestedIterator_real implements Iterator<Integer>{
	
	Stack<Iterator<NestedInteger>> iterator_reals;
	Integer nextNumber = null;
	
	public NestedIterator_real(List<NestedInteger> nestedList) {
		if (nestedList != null) {
			iterator_reals = new Stack<>();
			iterator_reals.push(nestedList.iterator());
		}
		
	}
	
	/**
	 * it must be sure that the first is number so we have a number to store it
	 */
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		while (!iterator_reals.isEmpty()) {
			Iterator<NestedInteger> currentIt = iterator_reals.peek();
			if (currentIt.hasNext()) {
				NestedInteger currentInt = currentIt.next();
				if (currentInt.isInteger()) {
					nextNumber = currentInt.getInteger();
					return nextNumber!=null;
				}
				else {
					iterator_reals.push(currentInt.getList().iterator());
				}
			}
			else {
				iterator_reals.remove(iterator_reals.size()-1);
				continue;
			}
		}
		return false;
	}

	/**
	 * here we should pay attention, if the method is used like {if(it.hasNext()){temp = it.next();}},we should not use hasNext in next method.
	 */
	@Override
	public Integer next() {
		// TODO Auto-generated method stub
		if (hasNext()) {
			int result = nextNumber;
			nextNumber = null;
			return result;
		}
		return null;
	}
	
	public static void main(String[] args){
		
	}

}
