def sieve(max_num):
    if max_num < 2:
        return []

    primes = [x for x in range(2, max_num)]

    i = 0

    while i < len(primes) - 1:
        j = i + 1

        while j < len(primes):
            if primes[j] % primes[i] == 0:
                del primes[j]
            else:
                j += 1

        i += 1

    return primes
