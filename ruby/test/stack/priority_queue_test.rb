require_relative '../../src/stack/priority_queue'

require 'test_helper'
require 'minitest/autorun'
require 'minitest/spec'

describe PriorityQueue do
    before do
        @queue = PriorityQueue.new(5)
    end

    describe 'when initialized' do
        it 'is empty' do
            @queue.size.must_equal 0
        end

        it 'has the given number of levels' do
            @queue.levels.must_equal 5
        end
    end

    describe 'when initialized incorrectly' do
        it 'raises an ArgumentError' do
            assert_raises(ArgumentError) { PriorityQueue.new(-1) }
        end
    end

    describe 'after single default push' do
        before do
            @queue.push(2)
        end

        it 'has 1 element' do
            @queue.size.must_equal 1
        end

        it 'pops the correct value' do
            @queue.pop.must_equal 2
        end

        it 'removes a value on pop' do
            @queue.pop
            @queue.size.must_equal 0
        end
    end

    describe 'after single push with level' do
        before do
            @queue.push(2, 3)
        end

        it 'has 1 element' do
            @queue.size.must_equal 1
        end

        it 'pops the correct value' do
            @queue.pop.must_equal 2
        end

        it 'removes a value on pop' do
            @queue.pop
            @queue.size.must_equal 0
        end
    end

    describe 'after multiple default pushes' do
        before do
            @queue.push(2)
            @queue.push(4)
        end

        it 'has 2 elements' do
            @queue.size.must_equal 2
        end

        it 'pops the correct values' do
            @queue.pop.must_equal 2
            @queue.pop.must_equal 4
        end

        it 'removes a value on pop' do
            @queue.pop
            @queue.size.must_equal 1
            @queue.pop
            @queue.size.must_equal 0
        end
    end


    describe 'after a push to each level' do
        before do
            @queue.push(5, 0)
            @queue.push(4, 1)
            @queue.push(3, 2)
            @queue.push(2, 3)
            @queue.push(1, 4)
        end

        it 'has 5 elements' do
            @queue.size.must_equal 5
        end

        it 'pops higher priority items first' do
            @queue.pop.must_equal 1
            @queue.pop.must_equal 2
            @queue.pop.must_equal 3
            @queue.pop.must_equal 4
            @queue.pop.must_equal 5
        end

        it 'removes each item it pops' do
            for i in (4..0)
                @queue.pop
                @queue.size.must_equal i
            end
        end
    end

    describe 'after multiple pushes to different levels' do
        before do
            @queue.push(0, 0)
            @queue.push(2, 0)

            @queue.push(4, 1)

            @queue.push(6, 2)
            @queue.push(8, 2)
            @queue.push(10, 2)

            # skip around to make sure insert order for different prios doesn't matter
            @queue.push(12, 4)
            @queue.push(14, 4)
            @queue.push(16, 4)
            @queue.push(18, 4)

            # now fill out prio 3
            @queue.push(20, 3)
            @queue.push(22, 3)
        end

        it 'has correct size' do
            @queue.size.must_equal 12
        end

        it 'pops in the correct order' do
            # prio 4
            @queue.pop.must_equal 12
            @queue.pop.must_equal 14
            @queue.pop.must_equal 16
            @queue.pop.must_equal 18

            # prio 3
            @queue.pop.must_equal 20
            @queue.pop.must_equal 22
            # prio 2
            @queue.pop.must_equal 6
            @queue.pop.must_equal 8
            @queue.pop.must_equal 10
            # prio 1
            @queue.pop.must_equal 4
            @queue.pop.must_equal 0
            # prio 0
            @queue.pop.must_equal 2
        end

        it 'removes each item it pops' do
            for i in (11..0)
                @queue.pop
                @queue.size.must_equal i
            end
        end
    end
end
