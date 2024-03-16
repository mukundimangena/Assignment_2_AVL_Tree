# Assignment_2_AVL_Tree
# Part 1: Program


Create an application as described below to store and retrieve data using the AVL binary search
tree data structure.

Write an application GenericsKbAVLApp to read in the attached text file (GenericsKB.txt)
and store the data items within an AVL Tree. Each data item consists of a term (which should
be used as the key – assume that there won’t be duplicate keys in the dataset), sentence and
confidence score.

After loading the dataset, a second file (GenericsKB queries.txt) should be read in. This file
consists of a list of items (one item per line) only. The application should perform a search for
each of the query items (one at a time). If the item (e.g. “tree”) is found in the AVL tree, the data
item should be printed out (e.g. “tree: Trees remove carbon dioxide from the atmosphere.
(1.0)"). If there is no match, an appropriate message should be printed out (e.g. “Term not
found: tree”).

Your AVL Tree implementation can be created from scratch or re used from anywhere. You
may use the sample code provided. You may NOT replace the AVL Tree with a different data
structure. Use output redirection in Unix to save the output of each run to a file.
Test that your application can load the dataset correctly, and manually construct a query file
with 10 queries to test that the application can handle queries with both terms in the dataset and
terms not in the dataset correctly.
