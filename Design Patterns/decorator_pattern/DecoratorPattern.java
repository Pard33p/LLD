package decorator_pattern;

public class DecoratorPattern {

    public static void main(String[] args) {
        Coffee coffee = new PlainCoffee();
        System.out.println(coffee.getDescription() + ": Rs." + coffee.getPrice());

        coffee = new Milk(coffee);
        System.out.println(coffee.getDescription() + ": Rs." + coffee.getPrice());

        coffee = new Sugar(coffee);
        System.out.println(coffee.getDescription() + ": Rs." + coffee.getPrice());

        coffee = new Caramel(coffee);
        System.out.println(coffee.getDescription() + ": Rs." + coffee.getPrice());
    }

}

interface Coffee {
    String getDescription();

    double getPrice();
}

class PlainCoffee implements Coffee {

    @Override
    public String getDescription() {
        return "Plain Coffee";
    }

    @Override
    public double getPrice() {
        return 50.0;
    }

}

abstract class CoffeeDecorator implements Coffee {

    protected Coffee decoratedCoffee;

    public CoffeeDecorator(Coffee coffee) {
        this.decoratedCoffee = coffee;
    }
}

class Milk extends CoffeeDecorator {

    public Milk(Coffee coffee) {
        super(coffee);
    }

    public String getDescription() {
        return decoratedCoffee.getDescription() + ", Milk";
    }

    public double getPrice() {
        return decoratedCoffee.getPrice() + 10.0;
    }
}

class Sugar extends CoffeeDecorator {

    public Sugar(Coffee coffee) {
        super(coffee);
    }

    public String getDescription() {
        return decoratedCoffee.getDescription() + ", Sugar";
    }

    public double getPrice() {
        return decoratedCoffee.getPrice() + 15.0;
    }
}

class Caramel extends CoffeeDecorator {

    public Caramel(Coffee coffee) {
        super(coffee);
    }

    public String getDescription() {
        return decoratedCoffee.getDescription() + ", Caramel";
    }

    public double getPrice() {
        return decoratedCoffee.getPrice() + 20.0;
    }
}
