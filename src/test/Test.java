package test;

/**
 * Created by Chris Keyser on 3/17/2016.
 * simplistic as possible test wrapper that'll print . or F if the call to expect() passes or fails respectively
 * this is to avoid needing to figure out build tooling for a project like this
 * maybe eventually i'll either expand this or figure out tooling so i can use JUnit
 */
public abstract class Test {
    protected void expect(boolean valid) {
        if(valid) {
            System.out.print(". ");
        } else {
            System.out.print("F ");
        }
    }
}
