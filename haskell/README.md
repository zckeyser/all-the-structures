# Haskell

This directory contains haskell implementations of various data structures. The structure code is in the `src` directory, and the tests are in the `test` directory. The tests can be run using the `make test` command. In order to run the tests, you'll need to have GHC and cabal installed on your machine. A full installer which can install GHC, cabal and stack (compiler, package manager, more advanced package manager) can be found [here](https://www.haskell.org/downloads) under the Haskell Platform header.

Of the languages used in this repository, haskell is the most unlike the others. This is particularly notable in structures which are, by nature, a lot easier to write when mutability is an option (dictionary, quicksort, bubble sort). This is because haskell is pure, meaning there is no mutability because when a function is called with an input, its output should always be the same.
