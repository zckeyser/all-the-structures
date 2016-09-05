module InsertionSort
    def InsertionSort.sort(arr)
        # copy input array
        out = arr.map { |x| x }

        for i in (1...out.length)
            j = i

            # as long as our current value is less than the value before it
            while j > 0 && out[j] < out[j - 1]
                # swap the values
                out[j], out[j - 1] = out[j - 1], out[j]
                j = j - 1
            end
        end

        out
    end
end
