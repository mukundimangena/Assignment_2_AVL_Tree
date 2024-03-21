//Created By Mukundi Mangena  

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;



public class  GenericsKbAVLApp 
{

   /**
    * Searches through the tree using keys given in the GenericsKB-queries.txt file
 * @return i will be the maximum number O(n) we will get int the search algorithmn
 * @param list is an arrayList that we will add all the searchcounts from the insertion algo
 * @para
 */
static int search(AVLTree tree){
    ArrayList<Integer> list = new ArrayList<Integer>();
    // adding the GenericsKB-queries.txt to a jaava readable mode
   try (Scanner file = new Scanner(new File("GenericsKB-queries.txt"))) {

       //Looping through the file that we created 
       while (file.hasNextLine()) {
           String word  = file.nextLine();
           BinaryTreeNode node = tree.find(word);
           //every time we call the search method we will print whether or not that data is found in the data set 
           if (node==null) System.out.println("Data Not Found in data set");
           else  System.out.println( word +" : " + node.data[1]  + " Score : " + node.data[2] );
           
            list.add(tree.getSearchCount());
            // the searchCount is reset every time the find() si called 
            tree.setSearchCount(0);

    
           
       }


        file.close();

   } catch (FileNotFoundException e) {
       // TODO Auto-generated catch block
       e.printStackTrace();
   }


   // returns the largest value of the search algorithmn
   return Collections.max(list);
  }


   public static void main ( String [] args ) throws IOException
   {
      AVLTree bt = new AVLTree ();
      String[] a = new String[3];
      int[] size = {10,100,1000,10000,50000};
      int[] worst_searchO_n  = new int[5];
      int[] worst_insertO_n = new int[5];
      int[] search = new int[5];
      int[ ] best_insert = new int[5];
      ArrayList<Integer> insertlist= new ArrayList<Integer>();


      
      /**
       * adding GenericsKB.txt the data Structure
       */
      //add the data incrementally such that we add 10, 100 and so on till the data structure is
      //full. When we add the data  to bt we run a search query for the query file 
      //we will append the highest value of the search O(n) into array 
      File filepath = new File("GenericsKB.txt"); 
      try(Scanner readFile = new Scanner(filepath)) {
        
        //Adding 10 items to the tree
        while (readFile.hasNextLine()) {
            for (int i =0; i<=10 ; i++){
                //add data to tree
                bt.insert(readFile.nextLine().split("\t"));
                //adding the time complexity  value to an array
                insertlist.add(bt.getInsertCount());
                //count reset
                bt.setInsertCount(0);


            }
            //add to the search_value_array and insertarray the highest time complexity
            worst_searchO_n[0] = search(bt);
            worst_insertO_n[0] = Collections.max(insertlist);
            best_insert[0]  = Collections.min(insertlist);
            
         

            //add another to make the tree size n=100 and add the time compexity to insertionlist and we add the maximum value to the
            for (int i =11; i<=100 ; i++){
                bt.insert(readFile.nextLine().split("\t"));
                insertlist.add(bt.getInsertCount());
                bt.setInsertCount(0);

            }
           worst_searchO_n[1] = search(bt);
           worst_insertO_n[1] = Collections.max(insertlist);
           best_insert[1]  = Collections.min(insertlist);
         
            //add another to make the tree size n=1000 and add the time compexity to insertionlist and we add the maximum value to the
            for (int i =101; i<=1000 ; i++){
                bt.insert(readFile.nextLine().split("\t"));
                insertlist.add(bt.getInsertCount());
                bt.setInsertCount(0);

            }
           worst_searchO_n[2] = search(bt);
           worst_insertO_n[2] = Collections.max(insertlist);
           best_insert[2]  = Collections.min(insertlist);

            //add another to make the tree size n=10000 and add the time compexity to insertionlist and we add the maximum value to the
            for (int i =1001; i<=10000 ; i++){
                bt.insert(readFile.nextLine().split("\t"));
                insertlist.add(bt.getInsertCount());
                bt.setInsertCount(0);

            }
           worst_searchO_n[3] = search(bt);
           worst_insertO_n[3] = Collections.max(insertlist);
           best_insert[3]  = Collections.min(insertlist);
         
            //add another to make the tree size n=50000 and add the time compexity to insertionlist and we add the maximum value to the
            while (readFile.hasNextLine()) {//loop through the rest of the file
                bt.insert(readFile.nextLine().split("\t"));
                insertlist.add(bt.getInsertCount());
                bt.setInsertCount(0);

            }
            worst_searchO_n[4] = search(bt);
            worst_insertO_n[4] = Collections.max(insertlist);
            best_insert[4]  = Collections.min(insertlist);
         
            
        }
        readFile.close(); } catch (Exception e) {
        // TODO: handle exception
      }

System.out.println(Arrays.toString(worst_searchO_n));
System.out.println(Arrays.toString(worst_insertO_n));
//creates a new text file that will be used by the python graphing too.

FileWriter writer = new FileWriter("output.txt");
//add arrays to the text file
writer.write(Arrays.toString(worst_searchO_n)+ "\n");

writer.write(Arrays.toString(worst_insertO_n) + "\n");
writer.write(Arrays.toString(best_insert));


writer.close();
// at thispoint we have done the addition of the insertion and search big-On



     


//in order to get the array of the O(n) of insertion we will have to take the 
//maximum value of the insertionCount in the intervals that we have








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
