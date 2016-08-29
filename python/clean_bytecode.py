import os

if __name__ == "__main__":
    # delete bytecode files
    for root, dirs, files in os.walk('./', topdown=False):
        for name in files:
            if name.endswith('.pyc'):
                os.remove(os.path.join(root, name))
