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
    	}
    	//TODO: test
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

    public Pair<String, Integer> findKey(String sIndex){
        //Complete Your Code Here
    }




}
