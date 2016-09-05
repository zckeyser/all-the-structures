class PriorityQueue
    def initialize(num_levels)
        if num_levels <= 0
            raise ArgumentError, 'number of levels in PriorityQueue must be >= 0'
        end

        @queues = []

        for i in (0...num_levels)
            @queues.push([])
        end
    end

    # default to minimum priority
    def push(val, level = 0)
        @queues[level].push(val)
    end

    def pop
        max_level = @queues.length - 1

        retval = nil

        # pop an item from the highest priority queue with items
        for level in (max_level).downto(0)
            if @queues[level].length > 0
                retval = @queues[level].shift
                break
            end
        end

        retval
    end

    def size
        # sum internal queue lengths
        @queues.map{ |x| x.length }.reduce(:+)
    end

    def levels
        @queues.length
    end
end
