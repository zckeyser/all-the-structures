class PriorityQueue
    def initialize()
        @data = nil
    end

    def enqueue(val, key)
        to_insert = PriorityQueueNode.new(val, key)

        if @data == nil
            @data = to_insert
        elsif key > @data.key
            to_insert.next = @data
            @data = to_insert
        else
            curr = @data

            while curr.next != nil && curr.next.key >= key
                curr = curr.next
            end

            if @curr.next != nil
                to_insert.next = @curr.next.next
            end

            curr.next = to_insert
        end
    end

    def extract_max
        if @data == nil
            raise RangeError, 'attempted to extract from empty queue'
        end

        retval = @data.value
        @data = @data.next
        retval
    end

    def size
        if @data
            @data.length()
        else
            0
        end
    end
end

class PriorityQueueNode
    attr_reader :value, :key, :next
    attr_writer :value, :key, :next

    def initialize(val, key)
        @value = val
        @key = key
        @next = nil
    end

    def length
        if @next != nil
            @next.length() + 1
        else
            1
        end
    end
end
