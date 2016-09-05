module SelectionSort
    def SelectionSort.sort(arr)
        # copy the input array
        out = arr.map { |x| x }

        for i in (0...out.length)
            min = i
            for j in (i...out.length)
                if out[j] < out[min]
                    min = j
                end
            end
            out[i], out[min] = out[min], out[i]
        end

        out
    end
end
