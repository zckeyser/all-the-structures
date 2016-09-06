module Linear
    def Linear.search(arr, target)
        for item in arr
            return true if item == target
        end

        false
    end
end
