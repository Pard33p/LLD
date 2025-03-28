package chain_of_responsibility_pattern;

public class ChainOfResponsibilityPattern {
    public static void main(String[] args) {
        SupportHandler level1 = new LevelOneSupport();
        SupportHandler level2 = new LevelTwoSupport();
        SupportHandler manager = new Manager();

        level1.setNextHandler(level2);
        level2.setNextHandler(manager);

        System.out.println("Request: Password reset");
        level1.handleRequest("password reset");

        System.out.println("Request: Software bug");
        level1.handleRequest("software bug");

        System.out.println("Request: Data Breach");
        level1.handleRequest("data breach");
    }
}

abstract class SupportHandler {
    protected SupportHandler nextHandler;

    public void setNextHandler(SupportHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public abstract void handleRequest(String issue);
}

class LevelOneSupport extends SupportHandler {
    @Override
    public void handleRequest(String issue) {
        if (issue.equalsIgnoreCase("password reset")) {
            System.out.println("Level 1 Support: Resolved password reset issue.");
        } else if (nextHandler != null) {
            System.out.println("Level 1 Support: Escalating issue to Level 2..");
            nextHandler.handleRequest(issue);
        } else {
            System.out.println("Level 1 Support: Not possible to handle request.");
        }
    }
}

class LevelTwoSupport extends SupportHandler {
    @Override
    public void handleRequest(String issue) {
        if (issue.equalsIgnoreCase("software bug")) {
            System.out.println("Level 2 Support: Resolved software bug.");
        } else if (nextHandler != null) {
            System.out.println("Level 2 Support: Escalating issue to Manager..");
            nextHandler.handleRequest(issue);
        } else {
            System.out.println("Level 2 Support: Not possible to handle request.");
        }
    }
}

class Manager extends SupportHandler {
    @Override
    public void handleRequest(String issue) {
        System.out.println("Manager: Handling complex issue - " + issue);
    }
}
