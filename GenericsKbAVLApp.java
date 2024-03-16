

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
              }
              readFile.close();
      } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
      }
/**
 *Seaching for the queries using GenericsKB-queries.txt
 */
    File file  = new File("GenericsKB-queries.txt");
    try (Scanner input = new Scanner(file)){
        while (input.hasNextLine()) {
            String word  = input.nextLine();// Creates a string out of Generics Queries file 
            if( bt.find(word) ==null){//if find returns null meaning we are unable to find this word in the Data Structure 
                System.out.println(word + " : Not found!!");
                System.out.println("**********************************************************");

            }else {
                //if we return somethinf 
                System.out.println( word +" : " + bt.find(word).data[1]  + " Score : " + bt.find(word).data[2] );
            }
            
        }
        
    } catch (FileNotFoundException e) {
        // TODO: handle exception
    }



             
//       System.out.println ("Inorder : ");
//       bt.treeOrder ();
//   System.out.println("  ");
//   System.out.println("  ");

//   System.out.println("  ");
//   System.out.println("  ");
//       System.out.println ("Search isolated organ: "); 
//       bt.visit(bt.find ("isolated organ"));

      
//       System.out.println ("Search chatterbox : ");
//       bt.visit(bt.find ("chatterbox"));
   

//       bt.delete("criminologist");
//       bt.delete("albatross");
//       bt.delete("distinct structure");
//       bt.delete("chatterbox");
//       bt.delete("computer hardware");
//       System.out.println("    ");
//       System.out.println("    ");
//       System.out.println("    ");
//       System.out.println("    ");
//       bt.treeOrder();
System.out.println(bt.find("insurance broker").data[1]);
    
   }
}
