import javafx.util.Pair;

import java.io.*;

public class Bob {

	/**
	 * constructor
	 */
    public Bob(){
    }
    
    /**
     * choose randomly a puzzle from the puzzle array
     * @param puzzles
     * @return chosen puzzle using the function solePuzzle
     */
    public Pair<String, String> choosePuzzle(Puzzle[] puzzles){
		int n = puzzles.length;
		Puzzle p = puzzles[(int)(Math.random()*n)];
		return solvePuzzle(p);
    }
    
    /**
     * this functions solve one puzzle by XORing it
     * @param puz contains a pair of arrays
     * @return a pair with the solved puzzle as string
     */
    public Pair<String, String> solvePuzzle(Puzzle puz){
    	int[] sRiddle = sortPuzzle(puz.getRiddle());
    	int[] sPrivateKey = sortPuzzle(puz.getPrivateKey());
    	
    	return new Pair<String, String>(arrXOR(sRiddle),arrXOR(sPrivateKey));
    }
    
    /** 
     * the function sorts an array
     * @param arr
     * @return sorted array
     */
    private int[] sortPuzzle(int[] arr){
    	int n=arr.length;
    	int[] sortedArr=new int[n];
    	for(int i=0;i<n;i++){
    		int loc=(int)(arr[i]/Math.pow(n, 3));
    		sortedArr[loc]=arr[i];
    	}
    	return sortedArr;
    }
    
    /**
     * this function XORing two int parameters
     * @param a
     * @param b
     * @return XOR of a and b
     */
    private int XOR(int a, int b){
    	if (a!=b)
    		return 1;
    	return 0;
    }
    
    /**
     * this function turns a number on 10 base to a binary number
     * @param num
     * @return binary number(num)
     */
    private int intXOR(int num){
    	int curr = num%2;
    	num = num/2;
    	while (num >= 1){
    		curr = XOR(curr,num%2);
    		num = num/2;
    	}
    	return curr;
    }
    
    /**
     * the function XOR an array
     * @param arr
     * @return XORed array
     */
    private String arrXOR(int[] arr){
    	String s="";
    	for (int i=0 ; i<arr.length ; i++)
    		s += intXOR(arr[i]);
    	return s;
    }
}
