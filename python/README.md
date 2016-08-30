# Python
This is the directory containing python implementations of the different structures/algorithms, written using Python 2.7. PyUnit is used for unit testing.

To run the tests run the following:
```bash
python test.py
```

If you would like to run performance tests on the different sorts and searches, run the following:
```bash
# number passed in is the size of the array to test sorts on
# second arg is a comma-separated list of timings to run
# currently the potential options are 'sort' for sorts and 'lsearch' for list searches
python -m structures.timing_test 10000 sort,lsearch
```


## TODO

- [ ] Red-Black Tree
- [ ] AVL Tree
- [ ] 2-3 Tree
- [ ] Heap
- [ ] Heapsort
- [ ] Knuth-Morris-Pratt
- [ ] Boyer-Moore
- [ ] Levenshtein Distance
