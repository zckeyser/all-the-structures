require_relative '../../src/trees/binary_tree'
require_relative '../../src/trees/traversal'

require 'test_helper'
require 'minitest/autorun'
require 'minitest/spec'

describe TreeTraversal do
    before do
        #        1
        #    2       3
        #  4   5   6   7
        @root = BinaryTree.new(1)
        @root.left = BinaryTree.new(2)
        @root.right = BinaryTree.new(3)
        @root.left.left = BinaryTree.new(4)
        @root.left.right = BinaryTree.new(5)
        @root.right.left = BinaryTree.new(6)
        @root.right.right = BinaryTree.new(7)
    end

    describe 'when traversing' do
        it 'correctly performs a preorder traversal' do
            expected = '1 2 4 5 3 6 7'

            result = TreeTraversal.preorder(@root).must_equal expected
        end

        it 'correctly performs an inorder traversal' do
            expected = '4 2 5 1 6 3 7'

            result = TreeTraversal.inorder(@root).must_equal expected
        end

        it 'correctly performs a postorder traversal' do
            expected = '4 5 2 6 7 3 1'

            TreeTraversal.postorder(@root).must_equal expected
        end
    end
end
