use rust::algorithms::prime::eratosthenes_sieve;


#[cfg(test)]
pub mod tests {
    use super::*;

    #[test]
    fn test_get_primes_low_prime_limit() {
        let result = eratosthenes_sieve::get_primes(5);

        let expected = vec![2, 3, 5];
        assert_eq!(expected, result);
    }

    #[test]
    fn test_get_primes_nonprime_limit() {
        let result = eratosthenes_sieve::get_primes(21);

        let expected = vec![2, 3, 5, 7, 11, 13, 17, 19];
        assert_eq!(expected, result);
    }

    #[test]
    fn test_get_primes_large_limit() {
        let result = eratosthenes_sieve::get_primes(250);

        let expected = vec![2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199, 211, 223, 227, 229, 233, 239, 241];
        assert_eq!(expected, result);
    }
}