package test;

/**
 * Created by Chris Keyser on 3/17/2016.
 * simplistic as possible test wrapper that'll print . or F if the call to expect() passes or fails respectively
 * this is to avoid needing to figure out build tooling for a project like this
 * maybe eventually i'll either expand this or figure out tooling so i can use JUnit
 */
public abstract class Test {
    static int timesCalled = 0;

    protected void expect(boolean valid) {
        timesCalled++;

        if(valid) {
            System.out.print(". ");
        } else {
            System.out.print(timesCalled + " ");
        }
    }
    
    protected void expectEquals(Object a, Object b) {
        timesCalled++;

        if(a.equals(b)) {
            System.out.print(". ");
        } else {
            System.out.println(timesCalled);
            System.out.print("    ");
            System.out.println("expected " + a.toString() + " to equal " + b.toString());
        }
    }
    
    protected void expectEquals(int a, int b) {
        timesCalled++;

        if(a == b) {
            System.out.print(". ");
        } else {
            System.out.println(timesCalled);
            System.out.print("    ");
            System.out.println("expected " + a + " to equal " + b);
        }
    }

    abstract public void run();
}
