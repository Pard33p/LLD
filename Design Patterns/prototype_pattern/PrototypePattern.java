package prototype_pattern;

public class PrototypePattern {
    public static void main(String[] args) {
        DatabaseConnection db1 = new DatabaseConnection();
        DatabaseConnection db2 = (DatabaseConnection) db1.clone();
        db1.show();
        db2.show();
    }
}

interface Prototype {
    Prototype clone();
}

class DatabaseConnection implements Prototype {
    private String config;

    public DatabaseConnection() {
        System.out.println("Loading config from database..");
        this.config = "config_from_database";
    }

    private DatabaseConnection(DatabaseConnection original) {
        this.config = original.config;
    }

    public Prototype clone() {
        return new DatabaseConnection(this);
    }

    public void show() {
        System.out.println("Config: " + config);
    }
}
