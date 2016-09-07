require_relative '../../src/trees/bst'
require_relative '../../src/trees/traversal'

require 'test_helper'
require 'minitest/autorun'
require 'minitest/spec'

describe BinarySearchTree do
    before do
        @root = BinarySearchTree.new(50, nil)

        @root.insert(10)
        @root.insert(30)
        @root.insert(42)
        @root.insert(15)
        @root.insert(3)
        @root.insert(60)
        @root.insert(80)
        @root.insert(83)
        @root.insert(24)
        @root.insert(73)
        @root.insert(87)
        @root.insert(100)
    end

    describe 'insert' do
        it 'inserts values correctly' do
            expected = '3 10 15 24 30 42 50 60 73 80 83 87 100'
            TreeTraversal.inorder(@root).must_equal expected
        end
    end

    describe 'remove' do
        it 'removes a leaf correctly' do
            @root.remove(3)

            expected = '10 15 24 30 42 50 60 73 80 83 87 100'
            TreeTraversal.inorder(@root).must_equal expected
        end

        it 'removes a node with a single child correctly' do
            @root.remove(42)

            expected = '3 10 15 24 30 50 60 73 80 83 87 100'
            TreeTraversal.inorder(@root).must_equal expected
        end

        it 'removes a node with two children correctly' do
            @root.remove(30)

            expected = '3 10 15 24 42 50 60 73 80 83 87 100'
            TreeTraversal.inorder(@root).must_equal expected
        end

        it 'removes the root correctly' do
            @root.remove(50)

            expected = '3 10 15 24 30 42 60 73 80 83 87 100'
            TreeTraversal.inorder(@root).must_equal expected
        end
    end

    describe 'contains' do
        it 'finds a contained element' do
            @root.contains?(80).must_equal true
        end

        it 'does not find an uncontained element' do
            @root.contains?(150).must_equal false
        end
    end
end
