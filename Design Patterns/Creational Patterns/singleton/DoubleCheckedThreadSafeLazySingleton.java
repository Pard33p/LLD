package singleton;

public class DoubleCheckedThreadSafeLazySingleton {
    /*
     * Using volatile to ensure changes to instance variable are immediately visible
     * to other threads.
     */
    private static volatile DoubleCheckedThreadSafeLazySingleton instance;

    private DoubleCheckedThreadSafeLazySingleton() {

    }

    /*
     * synchronized is moved inside the first if statement so the lock happens only
     * first time when getInstance is called. This improves the performance
     * significantly.
     */
    public static DoubleCheckedThreadSafeLazySingleton getInstance() {
        if (instance == null) {
            synchronized (DoubleCheckedThreadSafeLazySingleton.class) {
                /*
                 * Need to check this condition again as multiple threads could reach here.
                 */
                if (instance == null) {
                    instance = new DoubleCheckedThreadSafeLazySingleton();
                }
            }
        }
        return instance;
    }

}
