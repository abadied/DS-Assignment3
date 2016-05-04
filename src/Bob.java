import javafx.util.Pair;

import java.io.*;

public class Bob {

    //Add Fields if needed
	//TODO:check if save of key and riddle needed

    public Bob(){
        //Complete Your Code Here
    }

    public Pair<String, String> choosePuzzle(Puzzle[] puzzles){
		int n = puzzles.length;
		Puzzle p = puzzles[(int)(Math.random()*n)];
		return solvePuzzle(p);
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
    
    public String arrXOR(int[] arr){
    	String s="";
    	for (int i=0 ; i<arr.length ; i++)
    		s += intXOR(arr[i]);
    	return s;
    }
    
    public static void main(String[] args){
    	Bob b=new Bob();
    	int[] arr = new int[2];
    	arr[0]=5;
    	arr[1]=10;
    	System.out.println(b.arrXOR(arr));
    }
}
