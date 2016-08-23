package com.huiwei.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class ErrorRecord {
	public static void main(String args[]){
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String fileName= null;
		int lineNumber = 0;
		Map<String, Integer> map = new HashMap<String, Integer>();
		Queue<String> recordQueue = new LinkedList<String>();
		String inte;
		try {
			do{
				fileName = in.readLine();
				if(fileName.equals("")){
					break;
				}
				inte = fileName.substring(fileName.lastIndexOf(' ') + 1, fileName.length());
				lineNumber = Integer.valueOf(inte);
				fileName = fileName.substring(0,fileName.indexOf(' '));
				int a = fileName.lastIndexOf('\\');
				fileName = fileName.substring(a + 1, fileName.length());
				if(fileName.length() > 16){
					fileName = fileName.substring(fileName.length() -16, fileName.length());
				}
				
				String record = fileName + " " +  lineNumber;
				if(!map.containsKey(record) && map.size() >= 8){
					String str = recordQueue.poll();
					map.remove(str);
					recordQueue.add(record);
					map.put(record, 1);
					continue;
				}
				else if(map.containsKey(record)){
					map.put(record, map.get(record) + 1);
				}
				else{
					recordQueue.add(record);
					map.put(record, 1);
				}
			}while(in.ready());
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Iterator<String> iterator = recordQueue.iterator();
		while(iterator.hasNext()){
			String str = iterator.next();
			System.out.println(str + " " + map.get(str));
		}
	}	
}