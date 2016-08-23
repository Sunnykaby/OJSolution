package com.acmCoder.bestCoder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		while (number > 0) {
			int TownPeopleNumber = sc.nextInt();
			int relationNumber = sc.nextInt();
			Map<Integer, Boolean> candidateState = new HashMap<Integer, Boolean>();
			Map<Integer, Integer> candidateMap = new HashMap<Integer, Integer>();
			int fromPeople = 0;
			int toPeople = 0;
			while (relationNumber > 0) {
				fromPeople = sc.nextInt();
				toPeople = sc.nextInt();
				if (fromPeople == toPeople) {
					continue;
				} else {
					if (candidateState.containsKey(fromPeople)) {
						if (candidateState.get(fromPeople)) {
							candidateState.put(fromPeople, false);
						}
					} else
						candidateState.put(fromPeople, true);
					if (!candidateState.containsKey(toPeople)) {
						candidateState.put(fromPeople, true);
					}
					if (candidateState.get(toPeople)) {
						if (candidateMap.get(toPeople) == null) {
							candidateMap.put(toPeople, 1);
						} else
							candidateMap.put(toPeople,
									candidateMap.get(toPeople) + 1);
					} else
						candidateMap.remove(toPeople);
				}
				relationNumber--;
			}
			if (candidateMap.isEmpty()) {
				System.out.println(0);
				System.out.println();
				continue;
			}
			int max = 0;
			ArrayList<Integer> masterIndex = new ArrayList<Integer>();
			for (Map.Entry<Integer, Integer> currentEntry : candidateMap
					.entrySet()) {
				if (currentEntry.getValue()>max) {
					max = currentEntry.getValue();
				}
			}
			for (Map.Entry<Integer, Integer> currentEntry : candidateMap
					.entrySet()) {
				if (currentEntry.getValue()==max) {
					masterIndex.add(currentEntry.getKey());
				}
			}
			System.out.println(masterIndex.size());
			for (Integer integer : masterIndex) {
				System.out.print(integer+" ");
			}
			System.out.println();
			number--;
		}

	}
}
