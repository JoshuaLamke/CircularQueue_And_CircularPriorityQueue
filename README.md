# Intelligent_Binary_Tree
## What it does
This data structure is a binary tree that is used to ask someone about their symptoms for covid and will determine whether or not you should go to campus or whether you should see a doctor.
## How it works
It reads in data from a CSV text file in the format where each line is another level in the tree and the data in the line is given how a typical array would store a tree that has its root at index 0.
The data is read into an ArrayList and the ArrayList is used to initialize the tree. Then you can use the decide method which asks you yes or no questions as it traverses through the tree to see whether it is okay for you to go on campus or not.
If you feel the answer the decide method gives you is incorrect, then you can tell it to learn and it will ask you to add a question to the tree that will give you the right answer.
