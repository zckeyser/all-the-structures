package test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chris Keyser on 3/17/2016.
 * Suite to run a set of tests without manually calling each one
 */
public class Suite {
    List<Test> tests;

    public Suite() {
        this.tests = new ArrayList<>();
    }

    public Suite(List<Test> tests) {
        this.tests = tests;
    }

    public void addTest(Test test) {
        this.tests.add(test);
    }

    public void run() {
        for(Test t : tests) {
            System.out.println(t.getClass().getSimpleName());
            t.run();
            printSeparator();
        }
    }

    private void printSeparator() {
        System.out.println();
        System.out.println();
        System.out.println("===============================");
        System.out.println();
    }
}
