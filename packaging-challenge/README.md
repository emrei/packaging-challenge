PACKAGE CHALLENGE

This project is developed for knapsack package challenge
Challenge is actually a classical knapsack problem. There are some solutions for knapsack problem such as Dynamic Programming or recursive algorithms. But In this project Brute-Force is used to solve this problem. Complexity is 2^n ,but since number of weight and values is max 15 it seems reasonabe to use this algorithm. Brute-Force algorithm finds all possible solutions and select the best.

Service and DAO classes are not depend other classes (Dependecy Injection). If they use different class, then these classes should be passed by using constructors.

Application doesn't have any main method, it has Packer class with a static method named pack. This method
accepts the absolute path to a test file as a String. It does return the solution as a String.
This code is meant to be used as a library (i.e. maven dependency), NOT as a standalone application.

All classes have unit tests. For unit tests junit5 features has been used. Test coverage is %97.
Some test cases use test files in /test/resources folder

BUILD AND RUN

Maven can be used to build and run application. It is a simple java application.
 

