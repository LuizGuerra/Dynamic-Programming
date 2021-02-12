# Dynamic Programming

## Introduction

In this repo, there are 3 different kinds of implementations of common software-intensive problems (Fibonacci, Grid Traveler, Sum Problems and Construct Problems):
1. Naive implementation;
2. Dynamic implementation with [memoization](https://en.wikipedia.org/wiki/Memoization);
3. Dynamic implementation with tabulation.

I couldn't find any sources only explaining tabulation, but [here](https://programming.guide/dynamic-programming-vs-memoization-vs-tabulation.html) is a good source explaining both approaches. 

More info about dynamic programming can be found [here](https://en.wikipedia.org/wiki/Dynamic_programming).

The study was guided by [this class](https://youtu.be/oBt53YbR9Kk) using JavaScript. This made me want to try to implement the same problems with different languages: Java, Swift, and Haskell. Currently, this is an ongoing project.

## Problems

### Fibonacci

Consists of the implementation of the [Fibonacci Sequence](https://en.wikipedia.org/wiki/Fibonacci_number), where, given a number, the function calculates the value of passed index into the sequence.

### Grid Traveller

Given a matrix with size M and N, how many paths can you find from point (x: 0, y: 0) to (x: M, y: N), with the only possible moves being going right and down.

### Sum Problems

Similar problems, but with different focuses. All 3 problems have the same 2 inputs: target number and a list of numbers. Here, we try to find if we can achieve the target number by adding numbers from the list.

1. Can Sum: can sum numbers from the list to achieve the target number
2. How Sum: a sequence of numbers to be added to achieve a target number
3. All Sum: all possible sequence of numbers that when added, gives the target number

### Construct Problems

Similar to the Sum problems, here we have a target word to achieve and a list of substrings that we can use as we please.

1. Can Construct: if a word can be created given a list of strings
2. Count Construct: how many different ways a word can be created given a list of strings
3. All Constructs: which different ways a word can be created givena list of strings

## Implementation

Problem | Java | Swift | Haskell
--- | --- | --- | ---
Fibonacci | [Link](https://github.com/LuizGuerra/Dynamic-Programming/blob/main/Java/src/Fibonacci.java) | [Link](https://github.com/LuizGuerra/Dynamic-Programming/blob/main/Swift/Fibonacci.java) | -
Grid  | [Link](https://github.com/LuizGuerra/Dynamic-Programming/blob/main/Java/src/GridTraveler.java) | - | -
Sum problems | [Link](https://github.com/LuizGuerra/Dynamic-Programming/blob/main/Java/src/Sum.java) | - | -
Construct problems | [Link](https://github.com/LuizGuerra/Dynamic-Programming/blob/main/Java/src/Construct.java) | - | -
