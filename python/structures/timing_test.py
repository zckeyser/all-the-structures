import sys
import argparse

import structures.test.sorts.sort_timing as sort
import structures.test.search.list.search_timing as listSearch

import os


def parse_args():
    parser = argparse.ArgumentParser()

    parser.add_argument("tests-to-run", help="Types of algorithms to run performance tests for. Should be a comma-delimited list. Available options are sort and lsearch (list search)")

    return parser.parse_args()



if __name__ == "__main__":
    toRun = sys.argv[2].split(',')

    if 'sort' in toRun:
        sort.main()

    if 'lsearch' in toRun:
        listSearch.main()

    # delete bytecode files
    for root, dirs, files in os.walk('./', topdown=False):
        for name in files:
            if name.endswith('.pyc'):
                os.remove(os.path.join(root, name))
