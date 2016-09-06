module Eratosthenes
    def Eratosthenes.sieve(up_to)
        if up_to < 2
            []
        end

        primes = (2..up_to).to_a

        i = 0

        # sieve out non-primes
        while i < primes.length - 1
            j = i + 1

            while j < primes.length
                if primes[j] % primes[i] == 0
                    primes.delete_at(j)
                else
                    j += 1
                end
            end

            i += 1
        end

        primes
    end
end
