package com.huiwei.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Stringtest {
	public static String findFilename(String filename){
		if (filename.length() > 16) {
			return filename.substring(filename.length()-16);
		}
		else return filename;
	}
	public static void main(String[] args) {
		try {		
		Map<String, Integer> errorLog = new HashMap<String, Integer>();
		Queue<String> logQueue = new LinkedList<String>();
		BufferedReader sn = new BufferedReader(new InputStreamReader(System.in));
		String currentName;
		do{
			currentName = sn.readLine();
			if (currentName==null||currentName.equals("")) {
				break;
			}

			String logInfo[] = new String[2];
			logInfo[0] = currentName.substring(currentName.lastIndexOf("\\")+1,currentName.indexOf(" "));
			logInfo[1] = currentName.substring(currentName.lastIndexOf(" ")+ 1);
			currentName = logInfo[0] + " " + logInfo[1];
			
			if (errorLog.containsKey(currentName)) {
				errorLog.put(currentName, errorLog.get(currentName)+1);
			}
			else{
				if (logQueue.size() < 8) {
					logQueue.offer(currentName);
					errorLog.put(currentName, 1);
				}
				else {
					String removeLog = logQueue.poll();
					if (removeLog!=null) {
						errorLog.remove(removeLog);
					}
					logQueue.offer(currentName);
					errorLog.put(currentName, 1);
				}
			}
		}while(sn.ready());
		for (String string : logQueue) {
			String[] infoStrings = string.split(" ");
			System.out.println(findFilename(infoStrings[0]) + " " + infoStrings[1] + " " + errorLog.get(string));
		}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
		
}
