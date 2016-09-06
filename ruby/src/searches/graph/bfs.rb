require_relative '../../graph/directed'

module BreadthFirst
    def BreadthFirst.traverse(root)
        out = ''
        queue = [root]
        visited = []

        while !queue.empty?
            curr = queue.shift

            out += curr.value.to_s + ' '

            for neighbor in curr.neighbors
                if !queue.include?(neighbor) && !visited.include?(neighbor)
                    queue << neighbor
                end
            end

            visited << curr
        end

        return out.strip
    end
end
