def gcd(a, b):
    if b > a:
        return gcd(b, a)
    elif a % b == 0:
        return b
    else:
        return gcd(a % b, b)
