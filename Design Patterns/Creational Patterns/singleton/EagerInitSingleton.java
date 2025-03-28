package singleton;

public class EagerInitSingleton {

    /*
     * We rely on JVM to create the singleton instance when class is loaded.
     * One of the simplest and inherently thread-safe.
     * static ensures only one instance is shared across all instances of class.
     * final prevents the instance from being reassigned after initialization.
     * 
     * Good to use if overhead of creating the Singleton object is minimal.
     * It can waste the resources if Singleton is never used.
     */
    private static final EagerInitSingleton instance = new EagerInitSingleton();

    private EagerInitSingleton() {

    }

    public static EagerInitSingleton getInstance() {
        return instance;
    }
}
