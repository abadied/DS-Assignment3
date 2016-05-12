import java.io.*;

public class Eve {

    public Eve(){}
    
    /**
     * this function finds the "pair" of the index
     * @param index contains the solved riddle as a string
     * @param puzzles contains all the puzzles
     * @return a pair that contains the key and the number of checks eve did
     */
    public Pair<String, Integer> findKey(String index, Puzzle[] puzzles){
    	Pair<String,String> currPair;
    	for (int i=0 ; i<puzzles.length ; i++){
			
			if(equalRiddle(index,puzzles[i].getRiddle())){
				currPair = solvePuzzle(puzzles[i]);
				if (currPair.getKey().equals(index))
					return new Pair<String,Integer>(currPair.getValue(),i+1);
    		}
			
		}
    	
    	return null;
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
    
    /**
     * The function returns true id the string index is the same as the array arr
     * @param index
     * @param arr
     * @return true if equals
     */
    private boolean equalRiddle(String index,int[] arr){
    	for(int i=0 ; i<arr.length ; i++){
    		if(index.charAt(i)!=(char)intXOR(arr[i])+'0'){
    			return false;
    		}
    	}
    	return true;
    }
}
