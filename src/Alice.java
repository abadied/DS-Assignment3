import java.io.PrintWriter;

import javafx.util.Pair;


public class Alice {

    private Puzzle [] puzzlesArray;
    private AVLTree tree;
    //Add Fields if needed

    public Alice(){
    	puzzlesArray=null;
    	tree=new AVLTree();
    }

    public Puzzle[] getPuzzlesCopy(){
        Puzzle[] puzzlesCopy = new Puzzle[puzzlesArray.length];
        for(int i = 0; i < puzzlesArray.length; i++){
            puzzlesCopy[i] = new Puzzle(puzzlesArray[i]);
        }
        return puzzlesCopy;
    }

    public void createPuzzles(int n, int k){
    	puzzlesArray=new Puzzle[k];
    	int[] key,riddle;
    	for (int i=0 ; i < k ; i++){
    		key = new int[n];
    		riddle = new int[n];
    		for (int j=0 ; j < n ; j++){
    			key[j] = (int)((j+Math.random())*Math.pow(n, 3));
    			riddle[j] = (int)((j+Math.random())*Math.pow(n, 3));
    		}
    		puzzlesArray[i] = new Puzzle(key,riddle);
    		tree.insert(new Data(arrXOR(riddle),key));
    	}
    }
    
    private void RandomShuffle(int[] arr){
    	int n = arr.length;
    	int temp,loc;
    	for (int i=0 ; i<n ; i++){
    		temp = arr[i];
    		loc = (int)((Math.random()*(n-i))+i);
    		arr[i] = arr[loc];
    		arr[loc] = temp;
    	}
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

    public Pair<String, Integer> findKey(String sIndex){
        String privateKey = arrXOR(tree.getPrivateKey(sIndex));
        int checkNum = tree.deep(sIndex);
        
        return new Pair(privateKey,checkNum);
    }




}
