public class Puzzle {

    private int[] privateKey;
    private int[] riddle;
    /**
     * constructor
     * @param privateKey
     * @param riddle
     */
    public Puzzle(int[] privateKey, int[] riddle){
        this.privateKey = privateKey;
        this.riddle = riddle;
    }
    
    /**
     * copies a Puzzle
     * @param o other puzzle to copy
     */
    public Puzzle(Puzzle o){
        int [] oRiddle = o.getRiddle();
        int [] oPrivateKey = o.getPrivateKey();
        privateKey = new int[oPrivateKey.length];
        riddle = new int[oRiddle.length];
        for (int i = 0; i < oPrivateKey.length; i++){
            privateKey[i] = oPrivateKey[i];
        }
        for (int i = 0; i < oRiddle.length; i++){
            riddle[i] = oRiddle[i];
        }
    }
    /**
     * 
     * @return privateKey
     */
    public int[] getPrivateKey(){
        return privateKey;
    }
    
    /**
     * 
     * @return riddle
     */
    public int[] getRiddle() {
        return riddle;
    }
}
