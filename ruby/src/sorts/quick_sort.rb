module QuickSort
    class Sorter
        def qsort(arr)
            return arr if arr.length <= 1

            # take random pivot value
            pivot = arr[rand(0...arr.length)]

            i, j = 0, arr.length - 1

            while i < j
                # find a left side element to swap
                while i < arr.count && arr[i] < pivot
                    i += 1
                end

                # find a right side element to swap
                while j >= 0 && arr[j] > pivot
                    j -= 1
                end

                # swap the values if they should be swapped
                if i < j
                    arr[i], arr[j] = arr[j], arr[i]
                end
            end

            left = arr[0, j]
            right = arr[i, arr.length]

            self.qsort(left) + [pivot] + self.qsort(right)
        end
    end

    def QuickSort.sort(arr)
        # copy the array so this is pure
        out = arr.map { |x| x }

        Sorter.new.qsort(out)
    end
end
