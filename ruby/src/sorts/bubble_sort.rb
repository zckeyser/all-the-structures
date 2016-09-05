require_relative "../util/util"

module BubbleSort
    def BubbleSort.sort(arr)
        # copy input array
        out = arr.map { |x| x }

        while !Util.is_sorted(out)
            # go through the array until it's sorted
            for i in (1...out.length)
                # if these values are out of order
                if out[i] < out[i - 1]
                    # swap the values
                    out[i], out[i - 1] = out[i - 1], out[i]
                end
            end
        end

        out
    end
end
