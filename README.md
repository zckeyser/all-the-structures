# Data Structures

## Table of Contents
  - [Sorts]()
    - [Bubble Sort]()
    - [Insertion Sort]()
    - [Selection Sort]()
    - [Merge Sort]()
    - [Quick Sort]()
  - [Stacks and Queues]()
    - [Stack]()
    - [Queue]()
    - [Priority Queue]()
  - [Dictionary]()
  - [Trees]()
    - [Binary Tree]()
    - [Binary Search Tree]()
  - [Tree Traversal]()
    - [Preorder]()
    - [Inorder]()
    - [Postorder]()
  - [Directed Graph Traversals]()
    - [Breadth-First]()
    - [Depth-First]()
  - [List Searches]()
    - [Linear]()
    - [Binary]()
  - [Math Algorithms]()
    - [Greatest Common Denominator (Euclidean Algorithm)]()
    - [Sieve of Eratosthenes]()

## Sorts

### Bubble Sort

### Insertion Sort

### Selection Sort

### Merge Sort

### Quick Sort

---

## Stacks and Queues

### Stack

### Queue

### Priority Queue

---

## Dictionary


A [dictionary](https://en.wikibooks.org/wiki/Data_Structures/Hash_Tables) (also known as a map, hash map or hash table) is a structure which stores key-value pairs such that given a key, the map will return the corresponding value. This is done by *hashing* the key, which refers to using a function to reduce an object to a relatively small object of a consistent type. The hash functions used by a dictionary reduce objects to an integer so they can be used to access an index on the internal array, where each slot in the array is referred to as a *bucket*.

Sometimes, two different objects can produce the same key (since the hash value needs to have its range reduced to fit in the internal array). This is called a *collision*. There are two strategies commonly used to handle collisions:

### Chaining
![An example of chaining using a linked list implementation](https://upload.wikimedia.org/wikipedia/commons/3/34/HASHTB32.svg)

The Chaining strategy for collisions is to make every bucket a linked list. When you get a collision, you just look through the list to see if the key already exists. For a set, if the key exists you change that pair's value, otherwise you append the new value to end of that bucket's list. For a get, you return the value of the key-value pair in the list if you find it, otherwise you return null/throw for not found/etc.

### Open Addressing
![An example of open addressing using linear probing](https://upload.wikimedia.org/wikipedia/commons/9/90/HASHTB12.svg)

The Open Addressing strategy for collisions is to keep just a single key-value pair in each bucket, and on a collision search through other buckets until you find an open one. Once the internal array gets full, it gets re-instanced to a larger size then all the existing objects get re-inserted into the Dictionary.

---

## Trees

### Binary Tree

### Binary Search Tree

---

## Tree Traversal

### Preorder

### Inorder

### Postorder

---

## Directed Graph Traversals

### Breadth-First

### Depth-First

---

## List Searches

### Linear Search

### Binary Search

--

## Math Algorithms

### Greatest Common Denominator (Euclidean Algorithm)

### Sieve of Eratosthenes
