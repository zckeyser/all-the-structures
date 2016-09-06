require_relative '../../src/math/eratosthenes'

require 'test_helper'
require 'minitest/autorun'
require 'minitest/spec'

describe Eratosthenes do
    describe 'when given a numbers' do
        it 'should return correct number of primes' do
            expected = [ 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97 ]

            result = Eratosthenes.sieve(100)

            result.length.must_equal expected.length
        end

        it 'should return correct primes' do
            expected = [ 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97 ]

            result = Eratosthenes.sieve(100)

            for i in (0...result.length)
                result[i].must_equal expected[i]
            end
        end
    end
end
