require_relative '../../../src/searches/graph/bfs'
require_relative 'graph_gen'

require 'test_helper'

require 'minitest/autorun'
require 'minitest/spec'

describe BreadthFirst do
    describe 'when traversing a graph' do
        it 'should produce correct output' do
            root = GraphGeneration.generate()

            expected = '21 14 18 39 51 63 16 27 84 11 30 33 36'

            BreadthFirst.traverse(root).must_equal expected
        end
    end
end
