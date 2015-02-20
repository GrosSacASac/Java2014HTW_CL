# What is a Queue ?

A queue is a logical programming interface that allows us to simulate a real world Queue. There are two main methods for Queues: 

1- Add last: Adds an item at the end of the queue.
2- Remove first: Remove the first item of the queue

# How to save a queue in file ?

Here we have a lot of freedom, but we will use this format:

Filename: name. + ´type´ + queue
Content: LastItem, Item_n-1, Item_n-2, ... , FirstItem

Where ´type´ is the type of object stored in this queue

# How to load a queue from a file ?

Using the format defined above, 
1- split the text at every __,__
2- Construct FirstItem object with the class
3- Use addLast with FirstItem as a parameter
4- Repeat until the LastItem
