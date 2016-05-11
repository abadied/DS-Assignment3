import java.io.PrintWriter;

public class Alice {

    private Puzzle [] puzzlesArray;
    private AVLTree tree;

    /**
     * constructor
     */
    public Alice(){
    	puzzlesArray=null;
    	tree=new AVLTree();
    }
    
    /**
     * 
     * @return a copy of puzzlesArray
     */
    public Puzzle[] getPuzzlesCopy(){
        Puzzle[] puzzlesCopy = new Puzzle[puzzlesArray.length];
        for(int i = 0; i < puzzlesArray.length; i++){
            puzzlesCopy[i] = new Puzzle(puzzlesArray[i]);
        }
        return puzzlesCopy;
    }
    
    /**
     * create new puzzles
     * @param n the size of an array
     * @param k the number of arrays
     */
    public void createPuzzles(int n, int k){
    	puzzlesArray=new Puzzle[k];
    	Data newPuz=null;
    	int[] key,riddle;
    	for (int i=0 ; i < k ; i++){
    		key = new int[n];
    		riddle = new int[n];
    		for (int j=0 ; j < n ; j++){
    			key[j] = (int)((j+Math.random())*Math.pow(n, 3));
    			riddle[j] = (int)((j+Math.random())*Math.pow(n, 3));
    		}
    		newPuz= new Data(arrXOR(riddle),key);
    		if(!tree.search(newPuz)){
    			tree.insert(newPuz);
    			puzzlesArray[i] = new Puzzle(key,riddle);
    		}
    		else{
    			i--;
    		}
    			
    			
    	}
    }
    
    /**
     * shuffles a given array
     * @param arr
     */
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
     * finds the key matching to sIndex
     * @param sIndex
     * @return a pair of the matching key and number of checks until found
     */
    public Pair<String, Integer> findKey(String sIndex){
    	Pair<int[], Integer> keyPair = tree.getPrivateKey(sIndex);
        String privateKey = arrXOR(keyPair.getKey());
        
        return new Pair(privateKey,keyPair.getValue());
    }




}
