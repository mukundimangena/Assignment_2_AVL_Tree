// Hussein's AVL Tree
// 2 April2017
// Hussein Suleman

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.util.Scanner;

public class AVLTreeTest
{
   public static void main ( String [] args )
   {
      AVLTree bt = new AVLTree ();
      String[] a = new String[3];
   
/*
      // test for single node
      bt.root = new BinaryTreeNode<Integer> (10, null, null);
*/      
   
/*
      // test for 2-level tree
      bt.root = new BinaryTreeNode<Integer> (
          1, 
          new BinaryTreeNode<Integer> (2, null, null),
          new BinaryTreeNode<Integer> (3, null, null)
      );
*/      File filepath = new File("GenericsKB.txt");
        try (Scanner readFile = new Scanner(filepath)) {
            for (int i=0; i<=10; i++){

                   a  = readFile.nextLine().split("\t");
                   bt.insert(a);
              }
      } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
      }

        




      // test for 3-level tree
      // bt.insert (5); 
      // bt.insert (1); 
      // bt.insert (2); 
      // bt.insert (4); 
      // bt.insert (7); 
      // bt.insert (9); 
      // bt.insert (8); 
      // bt.insert (3); 
      // bt.insert (6); 
      
/*
                   5
            1             7
                2      6     9
                  4        8
                 3
*/                 
      System.out.println ("Inorder : ");
      bt.treeOrder ();
  System.out.println("  ");
  System.out.println("  ");

  System.out.println("  ");
  System.out.println("  ");
      System.out.println ("Search isolated organ: "); 
      bt.visit(bt.find ("isolated organ"));

      
      System.out.println ("Search chatterbox : ");
      bt.visit(bt.find ("chatterbox"));
   

      bt.delete("criminologist");
      bt.delete("albatross");
      bt.delete("distinct structure");
      bt.delete("chatterbox");
      bt.delete("computer hardware");
      System.out.println("    ");
      System.out.println("    ");
      System.out.println("    ");
      System.out.println("    ");
      bt.treeOrder();

      // System.out.println ("Delete 2 : ");
      // bt.delete (9);
      // bt.treeOrder ();
      // System.out.println ("Delete 7 : ");
      // bt.delete (6);
      // bt.treeOrder ();
      // System.out.println ("Delete 5 : ");
      // bt.delete (7);
      // bt.treeOrder ();
      // System.out.println ("Delete 3 : ");
      // bt.delete (8);
      // bt.treeOrder ();
      // System.out.println ("Delete 10 : ");
      // bt.delete (5);
      // bt.treeOrder ();
   }
}
