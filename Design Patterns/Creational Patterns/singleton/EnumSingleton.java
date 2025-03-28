package singleton;

/*
 * Singleton is declared as enum rather than a class.
 * Java ensures that only one instance is created, even in multi-threaded environment.
 * More robust and concise way to implement singleton.
 */
public enum EnumSingleton {
    INSTANCE;
}

/*
 * Many Java experts recommend Enum Singleton as the best way to implement
 * singleton in Java.
 * But not always suitable, especially if you need to extend a class or if
 * "lazy initialization" is strict requirement.
 */
