
public class MerklePuzzles {

    private Alice alice;
    private Bob bob;
    private Eve eve;
    String key;
    String privateKey;
    
    public long aliceCheckTime;
    public long eveCheckTime;
    public int aliceCompCount;
    public int eveCompCount;

    public MerklePuzzles(){
        alice = new Alice();
        bob = new Bob();
        eve = new Eve();
        key = null;
        privateKey = null;
    }

    private void Alice_createPuzzles(int n, int k){
        long startTime = System.nanoTime();
        alice.createPuzzles(n, k);
        long endTime = System.nanoTime();
        System.out.println("The time it took Alice to create the puzzles: " + (endTime - startTime));
    }

    private void Bob_choosePuzzles(){
        Puzzle[] puz = alice.getPuzzlesCopy();
        long startTime = System.nanoTime();
        Pair<String, String> bobAns = bob.choosePuzzle(puz);
        long endTime = System.nanoTime();
        key = bobAns.getKey();
        privateKey = bobAns.getValue();
        System.out.println("The time it took Bob to choose the puzzle: " + (endTime - startTime));
        System.out.println("The puzzle index Bob chose: " + key);
        System.out.println("The private key of the puzzle Bob chose: " + privateKey);
    }

    private void Alice_findKey(){
        long startTime = System.nanoTime();
        Pair<String,Integer> aliceAns = alice.findKey(key);
        long endTime = System.nanoTime();
        System.out.println("The private key of the puzzle Alice found: " + aliceAns);
        aliceCompCount = aliceAns.getValue();
        System.out.println("The number of comparisons Alice had done: " + aliceAns.getValue());
        aliceCheckTime = endTime - startTime;
        System.out.println("The time it took Alice to find the puzzle: " + (endTime - startTime));
    }

    private void Eve_findKey(){
        Puzzle[] puz = alice.getPuzzlesCopy();
        long startTime = System.nanoTime();
        Pair<String,Integer> eveAns = eve.findKey(key,puz);
        long endTime = System.nanoTime();
        System.out.println("The private key of the puzzle Eve found: " + eveAns.getKey());
        eveCompCount = eveAns.getValue();
        System.out.println("The number of comparisons Eve had done: " + eveAns.getValue());
        eveCheckTime = endTime - startTime;
        System.out.println("The time it took Eve to find the puzzle: " + (endTime - startTime));
    }

    public void fullTest(int n, int k){
        Alice_createPuzzles(n,k);
        Bob_choosePuzzles();
        Alice_findKey();
        Eve_findKey();
    }

    public static void main(String args[]){
    	MerklePuzzles mp = new MerklePuzzles();
    	long ACT=0,ECT=0;
    	int ACC=0,ECC=0;
    	for (int i=0 ; i<10 ; i++){
    		mp.fullTest(100, 10000);
    		ACT+=mp.aliceCheckTime;
    		ECT+=mp.eveCheckTime;
    		ACC+=mp.aliceCompCount;
    		ECC+=mp.eveCompCount;
    	}
    	System.out.println(ACC/10);
    	System.out.println(ACT/10);
    	System.out.println(ECC/10);
    	System.out.println(ECT/10);
    }

}