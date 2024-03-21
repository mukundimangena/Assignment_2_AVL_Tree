// Hussein's AVL Tree
// 2 April 2017
// Hussein Suleman
// reference: kukuruku.co/post/avl-trees/

import java.util.Arrays;


public class AVLTree extends BinaryTree
{ 
/**
 * @param searchCount // we use this to count every time we loop through to find a node in a data structure
 * @param insertCount // used to count the times we loop thought bt to insert a new node 
 * getter and setters are also set to ensure that the variable are not accessible globally 
 */
   private int searchCount = 0;
   public void setSearchCount(int searchCount) {
      this.searchCount = searchCount;
   }
   private int insertCount = 0;


   public void setInsertCount(int insertCount) {
      this.insertCount = insertCount;
   }

   public int getSearchCount() {
      return searchCount;
   }
   
    public int getInsertCount() {
      return insertCount;
   }

   public int height ( BinaryTreeNode node )
   {
      if (node != null)
         return node.height;
      return -1;
   }
   
   public int balanceFactor ( BinaryTreeNode node )
   {
      return height (node.right) - height (node.left);
   }
   
   public void fixHeight ( BinaryTreeNode node )
   {
      node.height = Math.max (height (node.left), height (node.right)) + 1;
   }
   
   public BinaryTreeNode rotateRight ( BinaryTreeNode p )
   {
      BinaryTreeNode q = p.left;
      p.left = q.right;
      q.right = p;
      fixHeight (p);
      fixHeight (q);
      return q;
   }

   public BinaryTreeNode rotateLeft ( BinaryTreeNode q )
   {
      BinaryTreeNode p = q.right;
      q.right = p.left;
      p.left = q;
      fixHeight (q);
      fixHeight (p);
      return p;
   }
   
   public BinaryTreeNode balance ( BinaryTreeNode p )
   {
      fixHeight (p);
      if (balanceFactor (p) == 2)
      {
         if (balanceFactor (p.right) < 0)
            p.right = rotateRight (p.right);
         return rotateLeft (p);
      }
      if (balanceFactor (p) == -2)
      {
         if (balanceFactor (p.left) > 0)
            p.left = rotateLeft (p.left);
         return rotateRight (p);
      }
      return p;
   }

   


 /**
  * 
  * @param d string of the term, statement and score to be added to the bt
  *the insertion is changed to allow for the key of the node to be the term
  @param insert count is increment everytime that we use a comparator in the code 
  */

    public void insert(String[] d )
    {
       root = insert(d, root);
    }
    public BinaryTreeNode insert ( String[] d, BinaryTreeNode node )
    {
       if (node == null){
          insertCount++;
          return new BinaryTreeNode (d, null, null);}
          
       if (d[0].compareTo(node.data[0]) <= 0){
         insertCount++;
          node.left = insert (d, node.left);
          
          }
          
       else{
          insertCount++;
          node.right = insert (d, node.right);
          
          }
          
       return balance (node);
    }
 
/**
 * 
 * @param d we sure a string for deletion to aid in ease of execution and also the key of the node is a string
 */
public void delete ( String d )
{
   root = delete (d, root);
}   
public BinaryTreeNode delete (String d, BinaryTreeNode node )
{
   if (node == null) return null;
   if (d.compareTo (node.data[0]) < 0)
      node.left = delete (d, node.left);
   else if (d.compareTo (node.data[0]) > 0)
      node.right = delete (d, node.right);
   else
   {
      BinaryTreeNode q = node.left;
      BinaryTreeNode r = node.right;
      if (r == null)
         return q;
      BinaryTreeNode min = findMin (r);
      min.right = removeMin (r);
      min.left = q;
      return balance (min);
   }
   return balance (node);
}




   
   public BinaryTreeNode findMin ( BinaryTreeNode node )
   {
      if (node.left != null)
         return findMin (node.left);
      else
         return node;
   }

   public BinaryTreeNode removeMin ( BinaryTreeNode node )
   {
      if (node.left == null)
         return node.right;
      node.left = removeMin (node.left);
      return balance (node);
   }

   public BinaryTreeNode find ( String d )
   {
      if (root == null)
         return null;
      else
         return find (d, root);
   }
   public BinaryTreeNode find ( String d, BinaryTreeNode node )
   {
      if (d.compareTo (node.data[0]) == 0){ 
         searchCount++;
         return node;}
      else if (d.compareTo (node.data[0]) < 0){
         searchCount++;
         return (node.left == null) ? null : find (d, node.left);}
      else{
         searchCount++;
         return (node.right == null) ? null : find (d, node.right);}
   }
   
   public void treeOrder ()
   {
      treeOrder (root, 0);
   }
   public void treeOrder ( BinaryTreeNode node, int level )
   {
      if (node != null)
      {
         for ( int i=0; i<level; i++ )
            System.out.print (" ");
         System.out.println (Arrays.toString(node.data));
         treeOrder (node.left, level+1);
         treeOrder (node.right, level+1);
      }
   }
}

