module MergeSort
    class Sorter
        def sort(arr)
            return arr if arr.length == 1

            mid = (arr.length / 2).floor
            left = self.sort(arr[0...mid])
            right = self.sort(arr[mid...arr.length])
            return self.merge(left, right)
        end

        def merge(a, b)
            out = []
            i, j = 0, 0

            while a.any? || b.any?
                if a.empty?
                    # all items from a have been added
                    out << b.shift
                elsif b.empty?
                    # all items from b have been added
                    out << a.shift
                elsif a.first < b.first
                    # the next smallest item is from a
                    out << a.shift
                else
                    # the next smallest item is from b
                    out << b.shift
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
