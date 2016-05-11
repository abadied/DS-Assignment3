/**
 * Contains the AVLNode data
 *
 */
public class Data implements Comparable{
	
	private String index;
	private int[] privateKey;
	
	/**
	 * constructor
	 * @param index represent the comp string
	 * @param privateKey an array that represent the key
	 */
	public Data(String index, int[] privateKey){
		this.index = new String(index);
		this.privateKey = privateKey;
	}
	/**
	 * 
	 * @return the privateKey
	 */
	public int[] getPrivateKey(){
		return privateKey;
	}
	
	@Override
	/**
	 * @returns a value of int 1,0,-1 depends if the objects are equal or not
	 */
	public int compareTo(Object o) {
		if (o instanceof String)
			return index.compareTo((String)o);
		return index.compareTo(((Data)o).index);
	}
	
}
