package com.kami.leetcode;
public class leetcode_234 {
	
    public boolean searchMatrix(int[][] matrix, int target) {
       int line =  findRowFront(matrix, target);
       int endLine  = findRowEnd(matrix, target);
       if (target == matrix[line][0]) {
		return true;
	}
       else if(target == matrix[endLine][matrix[endLine].length - 1]){
    	   return true;
	}
       else{ 
    	   while(line>=0&&line>endLine){
    		   if (findInLine(matrix, line, target)) {
				return true;
			}
    		   line--;
    	   }
    		   }
       
       return false;
    }
    //找到最接近target，但是比他小的数字
    public int findRowFront(int[][] matrix, int target){
    	int length = matrix.length;
    	int middle = length/2;
    	int left = 0;
    	int right = length-1;
    	while(left < right){
    		middle = left+(right-left)/2;
    		if (target == matrix[middle][0]) {
    			return middle;
			}
    		else if (target > matrix[middle][0]) {
    			left = middle + 1;
    			continue;
			}
    		else if(target < matrix[middle][0]){
    			right = middle -1;
    			continue;
    		}
    	}
    	return left;
    	
    }
    public int findRowEnd(int[][] matrix, int target){
    	int length = matrix.length;
    	int middle = length/2;
    	int left = 0;
    	int right = length-1;
    	while(left < right){
    		middle = left+(right-left)/2;
    		int end = matrix[middle].length-1;
    		if (target == matrix[middle][end]) {
    			return middle;
			}
    		else if (target > matrix[middle][end]) {
    			left = middle + 1;
    			continue;
			}
    		else if(target < matrix[middle][end]){
    			right = middle -1;
    			continue;
    		}
    	}
    	return left;
    	
    }
   
    
    public boolean findInLine(int[][] matrix, int line, int target){
    	int length = matrix[line].length;
    	int middle = length/2;
    	int left = 0;
    	int right = length-1;
    	while(left < right){
    		middle = left+(right-left)/2;
    		if (target == matrix[line][middle]) {
    			return true;
			}
    		else if (target > matrix[line][middle]) {
    			left = middle + 1;
    			continue;
			}
    		else if(target < matrix[line][middle]){
    			right = middle -1;
    			continue;
    		}
    	}
    	if (target==matrix[line][left]) {
			return true;
		}
    	return false;
    	
    }
    
    public static void main(String[] args){
    	int[][] matric = {{1,3,5}};
    	new leetcode_234().searchMatrix(matric,3);
    	
    }
}