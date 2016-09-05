require_relative '../../src/sorts/quick_sort'
require_relative '../../src/util/util'
require_relative '../../src/util/constants'
require_relative '../util'

require 'test_helper'
require 'minitest/autorun'
require 'minitest/spec'

describe QuickSort do
    describe 'when passed an array' do
        it 'should correctly sort it' do
            arr = TestUtil.random_array(Constants.ARRAY_SIZE)

            Util.is_sorted(arr).must_equal false

            result = QuickSort.sort(arr)

            Util.is_sorted(result).must_equal true
        end
    end
end
