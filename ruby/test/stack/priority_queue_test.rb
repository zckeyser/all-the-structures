require_relative '../../src/stack/priority_queue'

require 'test_helper'
require 'minitest/autorun'
require 'minitest/spec'

describe PriorityQueue do
    before do
        @queue = PriorityQueue.new()
    end

    describe 'when initialized' do
        it 'is empty' do
            @queue.size.must_equal 0
        end
    end

    describe 'after single enqueue with level' do
        before do
            @queue.enqueue(2, 3)
        end

        it 'has 1 element' do
            @queue.size.must_equal 1
        end

        it 'extract_max returns the correct value' do
            @queue.extract_max.must_equal 2
        end

        it 'removes a value on extract_max' do
            @queue.extract_max
            @queue.size.must_equal 0
        end
    end

    describe 'after an enqueue to multiple levels' do
        before do
            @queue.enqueue(5, 0)
            @queue.enqueue(4, 1)
            @queue.enqueue(3, 2)
            @queue.enqueue(2, 3)
            @queue.enqueue(1, 4)
        end

        it 'has 5 elements' do
            @queue.size.must_equal 5
        end

        it 'extract_max returns higher priority items first' do
            @queue.extract_max.must_equal 1
            @queue.extract_max.must_equal 2
            @queue.extract_max.must_equal 3
            @queue.extract_max.must_equal 4
            @queue.extract_max.must_equal 5
        end

        it 'removes each item it extract_maxs' do
            for i in (4..0)
                @queue.extract_max
                @queue.size.must_equal i
            end
        end
    end

    describe 'after multiple enqueues to different levels' do
        before do
            @queue.enqueue(0, 0)
            @queue.enqueue(2, 0)

            @queue.enqueue(4, 1)

            @queue.enqueue(6, 2)
            @queue.enqueue(8, 2)
            @queue.enqueue(10, 2)

            # skip around to make sure insert order for different prios doesn't matter
            @queue.enqueue(12, 4)
            @queue.enqueue(14, 4)
            @queue.enqueue(16, 4)
            @queue.enqueue(18, 4)

            # now fill out prio 3
            @queue.enqueue(20, 3)
            @queue.enqueue(22, 3)
        end

        it 'has correct size' do
            @queue.size.must_equal 12
        end

        it 'extract_max returns in the correct order' do
            # prio 4
            @queue.extract_max.must_equal 12
            @queue.extract_max.must_equal 14
            @queue.extract_max.must_equal 16
            @queue.extract_max.must_equal 18

            # prio 3
            @queue.extract_max.must_equal 20
            @queue.extract_max.must_equal 22
            # prio 2
            @queue.extract_max.must_equal 6
            @queue.extract_max.must_equal 8
            @queue.extract_max.must_equal 10
            # prio 1
            @queue.extract_max.must_equal 4
            @queue.extract_max.must_equal 0
            # prio 0
            @queue.extract_max.must_equal 2
        end

        it 'removes each item it extracts' do
            for i in (11..0)
                @queue.extract_max
                @queue.size.must_equal i
            end
        end
    end
end
