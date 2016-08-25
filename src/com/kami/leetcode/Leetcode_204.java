package com.kami.leetcode;


public class Leetcode_204 {
	public int countPrimes(int n) {
		int result = 0;
		if (n<3) {
			return result;
		}
		if(n >= 3) result++;//把2加上
		//跳过除了2的所有偶数
		for(int i = 3; i < n; i+=2){
			if (isPrime(i)) {
				result++;
			}
		}
		return result;
	}
	
	
	
	public boolean isPrime(int num){
//	    if(num == 1) return false;
		int temp = (int)Math.sqrt(num);//会耗时？改用I*I（事实证明每次都进行i*i相对更耗时）
		//如果不含有2，所有的偶数均不用
 		for(int i = 3; i  <= temp; i+=2){
			if (num%i == 0) {
				return false;
			}
		}
		return true;
	}

	//利用位图法
	public int countPrimes2(int n) {
		int result = 0;
		if (n < 3) {
			return result;
		}
		//因为是 less than 
		result = n/2;//cut off the even number
		//create a boolean array 
		boolean[] flag = new boolean[n];
		for(int i = 3; i * i <= n; i+=2){
			if (flag[i]) {//如果他本身不是素数，那么他的倍数肯定个也不是倍数
				continue;
			}
			//如果没有处理的
			for(int j = i*i; j < n; j += i*2){
//				if (j < 0) {
//					//越界之后说明已经超越了int的范围，则无需继续
//					break;
//				}
				//j本身是一个odd，+1是even。直接pass。+2就是odd
				//排除自己的所有倍数
//				if (j >= flag.length || j < 0) {
//					System.out.println(j);
//				}
				if (!flag[j]) {
					--result;
					flag[j] = true;
				}
			}
			
		}
		
		return result;
	}
	public static void main(String[] args){
		Leetcode_204 temp = new Leetcode_204();
		boolean[] tempArray = new boolean[123455];
		for (int i = 0; i < tempArray.length; i++) {
			if (i==123454) {
				System.out.println(tempArray[i]);
			}
		}
		System.out.println(temp.countPrimes(499979));
		System.out.println(temp.countPrimes2(499979));

	}
}
