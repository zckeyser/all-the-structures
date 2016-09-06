require_relative '../../graph/directed'

module DepthFirst
    def DepthFirst.traverse(root)
        out = ''
        stack = [root]
        visited = []

        while !stack.empty?
            curr = stack.pop

            out += curr.value.to_s + ' '

            for neighbor in curr.neighbors
                if !stack.include?(neighbor) && !visited.include?(neighbor)
                    stack << neighbor
                end
            end

            visited << curr
        end

        return out.strip
    end
end
