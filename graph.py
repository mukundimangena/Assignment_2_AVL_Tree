#Mukundi Mangena 
#21

import ast
import matplotlib.pyplot as plt

arrays  = []
search = ""
insert = " "# strings will hold the java output strings of the arrays we will use for graphs 
bestInsert =""
size  =  [10, 100, 1000, 10000, 50000] #n value sizes 
ideal_On = [3.3,6.6,9.96,13.28,15.6]

with open("Assignment_2_AVL_Tree-searcharray\output.txt", "r") as file:#change the text file into python readable data
         
          #read the entire file 
       worstSearch = file.readline()#get the string equivalent of the array
       worstInsert= file.readline() #get the string equivalent of the array
       bestInsert = file.readline()
worstSearch_array = ast.literal_eval(worstSearch) # change string array into an actual array using ast 

worstInsert_array = ast.literal_eval(worstInsert)
bestInsert_array = ast.literal_eval(bestInsert)

#plot graph
plt.plot(size,worstSearch_array,color = 'r' , label = "worst Search_O(n)")
plt.plot(size,worstInsert_array, color ="g", label="worst Insert_O(n)")
plt.plot(size,ideal_On,color="b", label=" ideal O(n) for both insert and search")
plt.plot(size,bestInsert_array,color="y", label="best case insert O(n)")
plt.xlabel("N inputs")
plt.ylabel("Big O(n)")
plt.title("Graph showing the Time complexity of an AVL tree")
plt.legend()

plt.show()