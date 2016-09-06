require_relative '../../../src/searches/array/binary'

require 'test_helper'
require 'minitest/autorun'
require 'minitest/spec'

describe Binary do
    describe 'when searching for an item' do
        before do
            @input = [ 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97 ]
        end

        it 'should find a contained item at the beginning of the array' do
            Binary.search(@input, 2).must_equal true
        end

        it 'should find a contained item in the middle of the array' do
            Binary.search(@input, 23).must_equal true
        end

        it 'should find a contained item at the end of the array' do
            Binary.search(@input, 97).must_equal true
        end

        it 'should not find an uncontained item' do
            Binary.search(@input, 70).must_equal false
        end
    end
end
