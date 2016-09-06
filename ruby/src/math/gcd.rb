module Euclidean
    def Euclidean.gcd(a, b)
        return self.gcd(b, a) if b > a
        
        return b if a % b == 0

        return self.gcd(a % b, b)
    end
end
