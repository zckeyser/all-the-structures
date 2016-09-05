require_relative '../../src/stack/queue'

require 'test_helper'
require 'minitest/autorun'
require 'minitest/spec'

describe Queue do
    before do
        @queue = Queue.new
    end

    describe 'when initialized' do
        it 'is empty' do
            @queue.size.must_equal 0
        end
    end

    describe 'when a single push is received' do
        before do
            @queue.push(2)
        end

        it 'has 1 element' do
            @queue.size.must_equal 1
        end

        it 'must return that element on pop' do
            result = @queue.pop

            result.must_equal 2
        end

        it 'must remove the popped element' do
            @queue.pop

            @queue.size.must_equal 0
        end
    end

    describe 'when multiple pushes are received' do
        before do
            @queue.push(2)
            @queue.push(4)
        end

        it 'has 2 elements' do
            @queue.size.must_equal 2
        end

        it 'must pop in the right order' do
            result1, result2 = @queue.pop, @queue.pop

            result1.must_equal 2
            result2.must_equal 4
        end

        it 'must remove popped elements' do
            @queue.pop

            @queue.size.must_equal 1

            @queue.pop

            @queue.size.must_equal 0
        end
    end
end
