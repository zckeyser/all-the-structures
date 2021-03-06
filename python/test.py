#!/usr/bin/env python

import unittest
import os

if __name__ == "__main__":
    suite = unittest.TestLoader().discover('.', pattern = "*_test.py")
    unittest.TextTestRunner(verbosity=2).run(suite)

    # delete bytecode files
    for root, dirs, files in os.walk('./', topdown=False):
        for name in files:
            if name.endswith('.pyc'):
                os.remove(os.path.join(root, name))
