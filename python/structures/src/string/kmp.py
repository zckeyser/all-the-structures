# knuth-morris-pratt string searching algorithm
def kmp(s, m):
    m = list(m)

    # build table of shift amounts
    shifts = [1] * (len(m) + 1)
    shift = 1
    for pos in range(len(m)):
        while shift <= pos and m[pos] != m[pos-shift]:
            shift += shifts[pos-shift]
        shifts[pos+1] = shift

    # do the actual search
    startPos = 0
    matchLen = 0
    for c in s:
        while matchLen == len(m) or \
              matchLen >= 0 and m[matchLen] != c:
            startPos += shifts[matchLen]
            matchLen -= shifts[matchLen]
        matchLen += 1
        if matchLen == len(m):
            return startPos

    return -1
