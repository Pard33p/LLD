package singleton;

public class LazySingleton {

    private static LazySingleton instance;

    private LazySingleton() {
    }

    /*
     * Not Thread-safe
     */
    public static LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }

}
