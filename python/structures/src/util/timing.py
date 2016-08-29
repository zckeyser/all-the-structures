import time as timer

def time(function, *args):
    before = timer.time()

    function(*args)

    after = timer.time()

    return after - before
