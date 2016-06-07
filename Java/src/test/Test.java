package test;

/**
 * Created by Chris Keyser on 3/17/2016.
 * simplistic as possible test wrapper that'll print . or F if the call to expect() passes or fails respectively
 * this is to avoid needing to figure out build tooling for a project like this
 * maybe eventually i'll either expand this or figure out tooling so i can use JUnit
 */
public abstract class Test {
    static int timesCalled = 0;

    protected void expect(String description, boolean valid) {
        timesCalled++;

        if(valid) {
            System.out.print(". ");
        } else {
            System.out.println("F");
            System.out.println("\t" + description);
        }
    }
    
    protected void expectEquals(String description, Object a, Object b) {
        timesCalled++;

        if(a.equals(b)) {
            System.out.print(". ");
        } else {
            System.out.println("F");
            System.out.println("\t" + description);
            System.out.println("\t\texpected " + a.toString() + " to equal " + b.toString());
        }
    }

    abstract public void run();
}
