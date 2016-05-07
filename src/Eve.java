import javafx.util.Pair;

import java.io.*;

public class Eve {
	
	//Add Fields if needed

    public Eve(){}

    public Pair<String, Integer> findKey(String index, Puzzle[] puzzles){
    	Pair<String,String> currPair;
    	
    	for (int i=0 ; i<puzzles.length ; i++){
			currPair = solvePuzzle(puzzles[i]);
			if (currPair.getKey().equals(index))
				return new Pair<String,Integer>(currPair.getValue(),i+1);
		}
    	
    	return null;
    }

    public Pair<String, String> solvePuzzle(Puzzle puz){
    	int[] sRiddle = sortPuzzle(puz.getRiddle());
    	int[] sPrivateKey = sortPuzzle(puz.getPrivateKey());
    	
    	return new Pair<String, String>(arrXOR(sRiddle),arrXOR(sPrivateKey));
    }
    
    private int[] sortPuzzle(int[] arr){
    	int n=arr.length;
    	int[] sortedArr=new int[n];
    	for(int i=0;i<n;i++){
    		int loc=(int)(arr[i]/Math.pow(n, 3));
    		sortedArr[loc]=arr[i];
    	}
    	return sortedArr;
    }
    
    private int XOR(int a, int b){
    	if (a!=b)
    		return 1;
    	return 0;
    }
    
    private int intXOR(int num){
    	int curr = num%2;
    	num = num/2;
    	while (num >= 1){
    		curr = XOR(curr,num%2);
    		num = num/2;
    	}
    	return curr;
    }
    
    private String arrXOR(int[] arr){
    	String s="";
    	for (int i=0 ; i<arr.length ; i++)
    		s += intXOR(arr[i]);
    	return s;
    }

}
