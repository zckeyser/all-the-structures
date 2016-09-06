require_relative '../../src/math/gcd'

require 'test_helper'
require 'minitest/autorun'
require 'minitest/spec'

describe Euclidean do
    describe 'when given two numbers' do
        it 'should find their greatest common denominator' do
            Euclidean.gcd(3, 12).must_equal 3

            Euclidean.gcd(13, 134).must_equal 1

            Euclidean.gcd(140, 20).must_equal 20

            Euclidean.gcd(198, 14).must_equal 2
        end
    end
end
