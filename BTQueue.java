// Hussein's Binary Tree
// 26 March 2017
// Hussein Suleman
//edited By Mukundi Mangena For Assignment 2


public class BTQueue
{   
   BTQueueNode head;
   BTQueueNode tail;
      
   public BTQueue ()
   {
      head = null;
      tail = null;
   }
   
   public BinaryTreeNode getNext ()
   {
      if (head == null)
         return null;
      BTQueueNode qnode = head;
      head = head.next;
      if ( head == null )
         tail = null;
      return qnode.node;
   }
   
   public void enQueue ( BinaryTreeNode node )
   {
      if (tail == null)
      {   
         tail = new BTQueueNode (node, null);
         head = tail;
      }   
      else
      {
         tail.next = new BTQueueNode (node, null);
         tail = tail.next;
      }   
   }   
}
