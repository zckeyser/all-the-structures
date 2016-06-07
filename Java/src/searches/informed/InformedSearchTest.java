package searches.informed;

import searches.informed.blocks.Board;
import test.Test;

/**
 * Created by Chris Keyser on 3/27/2016.
 * OthelloTest for the informed searches
 */
public class InformedSearchTest extends Test {
    // name of file holding template for sliding blocks game set-up
    private String filename;

    public InformedSearchTest(String filename) {
        this.filename = filename;
    }

    @Override
    public void run() {
        AStar aStar = new AStar(filename);
        Greedy greedy = new Greedy(filename);

        System.out.print("A*: ");
        Board aStarSolution = aStar.search();
        expect("A* solution to be solved correctly", aStarSolution.goalState());
        System.out.println(" " + aStarSolution.numMoves() + "moves");

        System.out.print("Greedy: ");
        Board greedySolution = greedy.search();
        expect("Greedy solution to be solved correctly", greedySolution.goalState());
        System.out.println(" " + greedySolution.numMoves() + "moves");
    }
}
