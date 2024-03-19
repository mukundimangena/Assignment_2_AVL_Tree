//Created By Mukundi Mangena  

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;



public class  GenericsKbAVLApp 
{

   /**
 * @return i will be the maximum number O(n) we will get int the searc algorithmn
 */
static int search(AVLTree tree){
    ArrayList<Integer> list = new ArrayList<Integer>();
   try (Scanner file = new Scanner(new File("GenericsKB-queries.txt"))) {

       while (file.hasNextLine()) {
           String word  = file.nextLine();
           BinaryTreeNode node = tree.find(word);
           
            list.add(tree.getSearchCount());
            tree.setSearchCount(0);

    
           
       }


        file.close();

   } catch (FileNotFoundException e) {
       // TODO Auto-generated catch block
       e.printStackTrace();
   }



   return Collections.max(list);
  }























   public static void main ( String [] args )
   {
      AVLTree bt = new AVLTree ();
      String[] a = new String[3];
      int[] size = {10,100,1000,10000,50000};
      int[] searchO_n  = new int[5];


      
      /**
       * adding GenericsKB.txt the data Structure
       */
      //add the data incrementally such that we add 10, 100 and so on till the data structure is
      //full. When we add the data  to bt we run a search query for the query file 
      //we will append the highest value of the search O(n) into array 
      File filepath = new File("GenericsKB.txt"); 
      try(Scanner readFile = new Scanner(filepath)) {

        while (readFile.hasNextLine()) {
            for (int i =0; i<=10 ; i++){
                bt.insert(readFile.nextLine().split("\t"));
            }
            searchO_n[0] = search(bt);
         


            for (int i =11; i<=100 ; i++){
                bt.insert(readFile.nextLine().split("\t"));
            }
            searchO_n[1] = search(bt);
         

            for (int i =101; i<=1000 ; i++){
                bt.insert(readFile.nextLine().split("\t"));
            }
            searchO_n[2] = search(bt);
         
            for (int i =1001; i<=10000 ; i++){
                bt.insert(readFile.nextLine().split("\t"));
            }
            searchO_n[3] = search(bt);
         

            while (readFile.hasNextLine()) {
                bt.insert(readFile.nextLine().split("\t"));
            }
             searchO_n[4] = search(bt);
         
            
        }
        readFile.close(); } catch (Exception e) {
        // TODO: handle exception
      }

System.out.println(Arrays.toString(searchO_n));

     











// File filepath = new File("GenericsKB.txt");
//         try (Scanner readFile = new Scanner(filepath)) {
//             while (readFile.hasNextLine()){

//                    a  = readFile.nextLine().split("\t");
//                    bt.insert(a);
//                 //    System.out.println("Insert Counter  : " + bt.getInsertCount());
//                 //    bt.setInsertCount(0);
//               }
//               readFile.close();
//       } catch (FileNotFoundException e) {
//             // TODO Auto-generated catch block
//             e.printStackTrace();
//       }

// bt.find("criminologist");
// System.out.println("The Search count : " + bt.getSearchCount());
// bt.setSearchCount(0);
// bt.find("riptide");
// System.out.println("The Search count : " + bt.getSearchCount());

 

// /**
//  *Seaching for the queries using GenericsKB-queries.txt
//  */
//     File file  = new File("GenericsKB-queries.txt");
//     try (Scanner input = new Scanner(file)){
//         while (input.hasNextLine()) {
//             String word  = input.nextLine();// Creates a string out of Generics Queries file 
//             BinaryTreeNode node = bt.find(word);
//             if( node ==null){//if find returns null meaning we are unable to find this word in the Data Structure 
//                 System.out.println(word + " : Not found!!");
//                 bt.setSearchCount(0);//reset the search counter to zero to enable each and every insert to have a new 
//                 System.out.println("**********************************************************");

//             }else {
//                 //if 
              
//                 System.out.println( word +" : " + node.data[1]  + " Score : " + node.data[2] );
//                 System.out.println("The Search count : " + bt.getSearchCount());
//                 bt.setSearchCount(0);
//             }
            
//         }
        
//     } catch (FileNotFoundException e) {
//         // TODO: handle exception
//     }


    
  




    
   }




}
