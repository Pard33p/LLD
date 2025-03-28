package singleton;

public class BillPughSingleton {
    private BillPughSingleton() {

    }

    /*
     * Uses inner static class.
     * The inner class is not loaded into memory until it is referenced (Lazy by
     * default).
     * It is thread-safe without requiring explicit synchronization.
     * Perfect balance of lazy initialization, thread-safety and performance.
     */

    private static class SingletonHelper {
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }

    public static BillPughSingleton getInstance() {
        return SingletonHelper.INSTANCE;
    }

}
