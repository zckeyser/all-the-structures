require_relative '../../src/stack/stack'

require 'minitest/autorun'
require 'minitest/spec'

describe Stack do
    before do
        @stack = Stack.new
    end

    describe 'when initialized' do
        it 'is empty' do
            @stack.size.must_equal 0
        end
    end

    describe 'when a single push is received' do
        before do
            @stack.push(2)
        end

        it 'has 1 element' do
            @stack.size.must_equal 1
        end

        it 'must return that element on pop' do
            result = @stack.pop

            result.must_equal 2
        end

        it 'must remove the popped element' do
            @stack.pop

            @stack.size.must_equal 0
        end
    end

    describe 'when multiple pushes are received' do
        before do
            @stack.push(2)
            @stack.push(4)
        end

        it 'has 2 elements' do
            @stack.size.must_equal 2
        end

        it 'must pop in the right order' do
            result1, result2 = @stack.pop, @stack.pop

            result1.must_equal 4
            result2.must_equal 2
        end

        it 'must remove popped elements' do
            @stack.pop

            @stack.size.must_equal 1

            @stack.pop

            @stack.size.must_equal 0
        end
    end
end
