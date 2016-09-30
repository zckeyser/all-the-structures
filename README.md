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

A dictionary (also known as a map, hash map or hash table) is a structure which stores key-value pairs such that given a key, the map will return the corresponding value. This is done by *hashing* the key, which refers to using a function to reduce an object to a relatively small object of a consistent type. The hash functions used by a dictionary reduce objects to an integer so they can be used to access an index on the internal array, where each slot in the array is referred to as a *bucket*.

Sometimes, two different objects can produce the same key (since the hash value needs to have its range reduced to fit in the internal array). This is called a *collision*. There are two strategies commonly used to handle collisions:

### Linked List
The Linked List solution for a collision is to make every bucket a linked list. When you get a collision, you just look through the list to see if the key already exists. For a set, if the key exists you change that pair's value, otherwise you append the new value to end of that bucket's list. For a get, you return the value of the key-value pair in the list if you find it, otherwise you return null/throw for not found/etc.

### Rollover
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
