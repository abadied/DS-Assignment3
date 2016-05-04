import java.io.PrintWriter;

/* Class AVLTree */
class AVLTree
{
    private AVLNode root;

    /* Constructor */
    public AVLTree()
    {
    	root=null;
    }
    /* Function to check if tree is empty */
    public boolean isEmpty()
    {
    	if(root==null)
    		return true;
    	return false;
    }
    /* Make the tree logically empty */
    public void makeEmpty()
    {
    	root=null;
    }
    /* Function to insert data */
    public void insert(Comparable data)
    {
        //Complete Your Code Here
    }
    /* Function to get height of node */
    private int height(AVLNode t)
    {
        return t.height;
    }
    /* Function to max of left/right node */
    private int max(int lhs, int rhs)
    {
        return Math.max(lhs,rhs);
    }
    /* Function to insert data recursively */
    private AVLNode insert(Comparable x, AVLNode t)
    {
        if (t==null)
        	t=new AVLNode(x);
        else if(t.data.compareTo(x)==-1){
        	t.left = insert(x,t.left);
        	if (height(t.left) - height(t.right) == 2){
        		if (x.compareTo(t.left.data)<0)
        			t = rotateWithLeftChild(t);
        		else
        			t = doubleWithLeftChild(t);
        	}
        	
        }
        else if(t.data.compareTo(x)==1){
        	t.right = insert(x,t.right);
	    	if (height(t.right) - height(t.left) == 2){
	    		if (x.compareTo(t.right.data)<0)
	    			t = rotateWithLeftChild(t);
	    		else
	    			t = doubleWithLeftChild(t);
	    	}
        }
        t.height = max(height(t.left), height(t.right)) + 1;
        return t;
    }
    /* Rotate binary tree node with left child */
    private AVLNode rotateWithLeftChild(AVLNode k2)
    {
    	AVLNode x = k2.left;
    	k2.left = x.right;
    	x.right = k2;
    	k2.height = max(height(k2.left), height(k2.right)) + 1;
    	x.height = max(height(x.left), k2.height) + 1;
       	return x;
    }

    /* Rotate binary tree node with right child */
    private AVLNode rotateWithRightChild(AVLNode k1)
    {
    	AVLNode y = k1.right;
    	k1.right = y.left;
    	y.left = k1;
    	k1.height = max(height(k1.left), height(k1.right)) + 1;
    	y.height = max(height(y.right), k1.height) + 1;
    	return y;
    }
    /**
     * Double rotate binary tree node: first left child
     * with its right child; then node k3 with new left child */
    private AVLNode doubleWithLeftChild(AVLNode k3)
    {
    	k3.left = rotateWithRightChild(k3.left);
        return rotateWithLeftChild(k3);
    }
    /**
     * Double rotate binary tree node: first right child
     * with its left child; then node k1 with new right child */
    private AVLNode doubleWithRightChild(AVLNode k1)
    {
    	k1.right = rotateWithLeftChild( k1.right );
        return rotateWithRightChild( k1 );
    }
    /* Functions to count number of nodes */
    public int countNodes()
    {
    	  return countNodes(root);
    }
    private int countNodes(AVLNode r)
    {
    	if(r==null)
    		return 0;
        return countNodes(r.right) + countNodes(r.left) + 1;
    	
    }
    /* Functions to search for an element */
    public boolean search(Comparable val)
    {
    	return(search(root,val));
    }
    private boolean search(AVLNode r, Comparable val)
    {
    	if (r==null)
    		return false;
    	switch (r.data.compareTo(val)){
    		case 1:
    			return search(r.left,val);
    		case -1:
    			return search(r.right,val);
			default:
				return true;
    	}
    }
    /* Function for inorder traversal */
    public void inorder(PrintWriter out)
    {
    	if(root==null)
    		out.write("tree is empty");
    	else
    		inorder(root,out);
    }
    private void inorder(AVLNode r, PrintWriter out)
    {
    	if(r.left!=null)
    		inorder(r.left,out);
    	out.write(r.toString());
    	//TODO: check toString
    	if(r.right!=null)
    		inorder(r.right,out);
    }

    public int[] getPrivateKey(String sIndex) {
        return getPrivateKey(root,sIndex);
    }

    private int[] getPrivateKey(AVLNode r, String sIndex) {
    	if (r==null)
    		return null;
    	switch (r.data.compareTo(sIndex)){
    		case 1:
    			return getPrivateKey(r.left,sIndex);
    		case -1:
    			return getPrivateKey(r.right,sIndex);
			case 0:
				return ((Data)r.data).getPrivateKey();
			default:
				return null;
    	}
    }
}