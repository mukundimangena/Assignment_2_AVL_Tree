//Created By Mukundi Mangena  

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;



public class  GenericsKbAVLApp 
{
   public static void main ( String [] args )
   {
      AVLTree bt = new AVLTree ();
      String[] a = new String[3];

      
      /**
       * adding GenericsKB.txt the data Structure
       */
   
   File filepath = new File("GenericsKB.txt");
        try (Scanner readFile = new Scanner(filepath)) {
            while (readFile.hasNextLine()){

                   a  = readFile.nextLine().split("\t");
                   bt.insert(a);
                //    System.out.println("Insert Counter  : " + bt.getInsertCount());
                //    bt.setInsertCount(0);
              }
              readFile.close();
      } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
      }

bt.find("criminologist");
System.out.println("The Search count : " + bt.getSearchCount());
bt.setSearchCount(0);
bt.find("riptide");
System.out.println("The Search count : " + bt.getSearchCount());

 

/**
 *Seaching for the queries using GenericsKB-queries.txt
 */
    File file  = new File("GenericsKB-queries.txt");
    try (Scanner input = new Scanner(file)){
        while (input.hasNextLine()) {
            String word  = input.nextLine();// Creates a string out of Generics Queries file 
            BinaryTreeNode node = bt.find(word);
            if( node ==null){//if find returns null meaning we are unable to find this word in the Data Structure 
                System.out.println(word + " : Not found!!");
                bt.setSearchCount(0);//reset the search counter to zero to enable each and every insert to have a new 
                System.out.println("**********************************************************");

            }else {
                //if 
              
                System.out.println( word +" : " + node.data[1]  + " Score : " + node.data[2] );
                System.out.println("The Search count : " + bt.getSearchCount());
                bt.setSearchCount(0);
            }
            
        }
        
    } catch (FileNotFoundException e) {
        // TODO: handle exception
    }


    
  




    
   }
}
