module MergeSort
    class Sorter
        def sort(arr)
            return arr if arr.length == 1

            mid = (arr.length / 2).floor
            left = self.sort(arr[0..mid - 1])
            right = self.sort(arr[mid..arr.length])
            return self.merge(left, right)
        end

        def merge(a, b)
            out = []
            i, j = 0, 0

            while i < a.length || j < b.length
                if i == a.length
                    # all items from a have been added
                    out.push(b[j])
                    j += 1
                elsif j == b.length
                    # all items from b have been added
                    out.push(a[i])
                    i += 1
                elsif a[i] < b[j]
                    # the next smallest item is from a
                    out.push(a[i])
                    i += 1
                else
                    # the next smallest item is from b
                    out.push(b[j])
                    j += 1
                end
            end

            return out
        end
    end

    def self.sort(arr)
        sorter = Sorter.new

        return sorter.sort(arr)
    end
end
