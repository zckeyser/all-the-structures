require_relative '../../../src/searches/graph/dfs'
require_relative 'graph_gen'

require 'test_helper'

require 'minitest/autorun'
require 'minitest/spec'

describe BreadthFirst do
    describe 'when traversing a graph' do
        it 'should produce correct output' do
            root = GraphGeneration.generate()

            expected = '21 39 27 30 33 36 16 11 84 18 63 14 51'

            DepthFirst.traverse(root).must_equal expected
        end
    end
end
