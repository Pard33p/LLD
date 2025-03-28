package singleton;

public class StaticBlockSingleton {
    private static StaticBlockSingleton instance;

    private StaticBlockSingleton() {

    }

    /**
     * Similar to eager initialization but instance is created in static block.
     * Exceptions can be handled, if any, during instance creation.
     */

    static {
        try {
            instance = new StaticBlockSingleton();
        } catch (Exception e) {
            System.err.println("Error occured");
        }
    }

    public static StaticBlockSingleton getInstance() {
        return instance;
    }
}
