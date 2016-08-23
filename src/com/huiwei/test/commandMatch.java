package com.huiwei.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class commandMatch {
	private static HashMap<String, String> commandHashMap = new HashMap<String, String>() {
		{
			put("reset", "reset what");
			put("reset board", "board fault");
			put("board add", "where to add");
			put("board delet", "no board at all");
			put("reboot backplane", "impossible");
			put("backplane abort", "install first");
		}
	};
	private static ArrayList<String> commandList = new ArrayList<String>() {
		{
			add("reset");
			add("reset board");
			add("board add");
			add("board delet");
			add("reboot backplane");
			add("backplane abort");
		}
	};
	public static String findSingle(String command){
		String singleCommandString = commandList.get(0);
		int lenghS = command.length();
		if (lenghS > singleCommandString.length()||lenghS==0) {
			return "unkown command";
		}
		for (int i = 0; i < lenghS; i++) {
			if (command.charAt(i)!=singleCommandString.charAt(i)) {
				return "unkown command";
			}
		}
		return commandHashMap.get(singleCommandString);
	}
	
	public static String findDouble(String command1, String command2){
		boolean[] flag = new boolean[5];
		if (command1.length()==0||command2.length()==0) {
			return "unkown command";
		}
		for (int i = 1; i < 6; i++) {
			boolean flagTemp = true;
			String singleCommandString = commandList.get(i);
			String[] commandSourceStrings = singleCommandString.split(" ");
			int lenghS = command1.length();
			if (lenghS>commandSourceStrings[0].length()) {
				continue;
			}
			for (int j = 0; j < lenghS; j++) {
				if (command1.charAt(j)!=commandSourceStrings[0].charAt(j)) {
					flagTemp = false;
					break;
				}
			}
			if (!flagTemp) {
				continue;
			}
			lenghS = command2.length();
			if (lenghS>commandSourceStrings[1].length()) {
				continue;
			}
			for (int j = 0; j < lenghS; j++) {
				if (command2.charAt(j)!=commandSourceStrings[1].charAt(j)) {
					flagTemp = false;
					break;
				}
			}
			if (!flagTemp) {
				continue;
			}
			flag[i-1] = true;
		}
		int index = 0;
		int num = 0;
		for (int i = 0; i < flag.length; i++) {
			if (flag[i]) {
				index = i;
				num++;
			}
		}
		if (num == 0) {
			return "unkown command";
		}
		else if (num > 1) {
			return "unkown command";
		}
		else if (num == 1) {
			return commandHashMap.get(commandList.get(index+1));
		}
		else return "unkown command";
	}
	public static void main(String[] args) throws IOException {
		try {
			BufferedReader brBufferedReader = new BufferedReader(
					new InputStreamReader(System.in));
//			Scanner scanner = new Scanner(System.in);
			do {
				String commandString = brBufferedReader.readLine();
				String[] commandStrings = commandString.split(" ");
				
				int lengthCommand = commandStrings.length;
				if (lengthCommand == 1) {
					System.out.println(findSingle(commandStrings[0]));
				}
				else if(lengthCommand == 2){
					System.out.println(findDouble(commandStrings[0], commandStrings[1]));
				}
				else System.out.println("unkown command");
			} while (brBufferedReader.ready());

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}
}
