module Util
    def Util.is_sorted(arr)
        for i in (1...arr.length)
            if arr[i] < arr[i - 1]
                return false
            end
        end

        true
    end
end
