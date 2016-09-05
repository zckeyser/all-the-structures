#!/usr/bin/env ruby

class Stack
    def initialize()
        @values = []
    end

    def push(val)
        @values << val
    end

    def pop()
        @values.pop()
    end

    def size
        @values.length
    end
end
