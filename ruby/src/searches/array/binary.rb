module Binary
    def Binary.search(arr, target)
        return false if arr.empty?
        return arr[0] == target if arr.length == 1

        mid = arr.length / 2

        if arr[mid] == target
            return true
        elsif arr[mid] > target
            return self.search(arr[0...mid], target)
        else
            return self.search(arr[mid + 1...arr.length], target)
        end
    end
end
