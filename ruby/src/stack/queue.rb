#!/usr/bin/env ruby

class Stack
    def initialize()
        @values = []
    end

    def push(val)
        @values << val
    end

    def pop()
        @values.shift
    end

    def size
        @values.length
    end
end
