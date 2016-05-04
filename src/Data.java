
public class Data implements Comparable{
	
	private String index;
	private int[] privateKey;
	
	public Data(String index, int[] privateKey){
		this.index = new String(index);
		this.privateKey = privateKey;
	}
	
	public int[] getPrivateKey(){
		return privateKey;
	}
	
	@Override
	public int compareTo(Object o) {
		if (o instanceof String)
			return index.compareTo((String)o);
		return -2;
	}
	
}
