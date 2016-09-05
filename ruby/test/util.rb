module TestUtil
    def TestUtil.random_array(length)
        arr = []

        for _ in (0...length)
            arr << rand((-1000000...1000000))
        end

        arr
    end
end
