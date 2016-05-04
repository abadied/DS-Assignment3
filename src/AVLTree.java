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
        //Complete Your Code Here
    }
    /* Function to max of left/right node */
    private int max(int lhs, int rhs)
    {
        //Complete Your Code Here
    }
    /* Function to insert data recursively */
    private AVLNode insert(Comparable x, AVLNode t)
    {
        //Complete Your Code Here
    }
    /* Rotate binary tree node with left child */
    private AVLNode rotateWithLeftChild(AVLNode k2)
    {
        //Complete Your Code Here
    }

    /* Rotate binary tree node with right child */
    private AVLNode rotateWithRightChild(AVLNode k1)
    {
        //Complete Your Code Here
    }
    /**
     * Double rotate binary tree node: first left child
     * with its right child; then node k3 with new left child */
    private AVLNode doubleWithLeftChild(AVLNode k3)
    {
        //Complete Your Code Here
    }
    /**
     * Double rotate binary tree node: first right child
     * with its left child; then node k1 with new right child */
    private AVLNode doubleWithRightChild(AVLNode k1)
    {
        //Complete Your Code Here
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
        //Complete Your Code Here
    }

    private int[] getPrivateKey(AVLNode r, String sIndex) {
        //Complete Your Code Here
    }
}