// Hussein's Binary Tree
// 26 March 2017
// Hussein Suleman
///Edited by Mukundi Mangena for assignment 2


public class BinaryTreeNode
{
   String[] data;
   BinaryTreeNode left;
   BinaryTreeNode right;
   int height;
   
   public BinaryTreeNode ( String[] d, BinaryTreeNode l, BinaryTreeNode r )
   {
      data = d;
      left = l;
      right = r;
      height = 0;
   }
   
   BinaryTreeNode getLeft () { return left; }
   BinaryTreeNode getRight () { return right; }
}
