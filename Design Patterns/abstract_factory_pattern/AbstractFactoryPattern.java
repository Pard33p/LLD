package abstract_factory_pattern;

public class AbstractFactoryPattern {
    public static void main(String[] args) {
        UIFactory lightFactory = new LightThemeFactory();
        Button lightButton = lightFactory.createButton();
        TextField lightTextField = lightFactory.createTextField();
        lightButton.render();
        lightTextField.render();
    }
}

interface Button {
    void render();
}

interface TextField {
    void render();
}

class LightButton implements Button {
    public void render() {
        System.out.println("Rendering light button");
    }
}

class DarkButton implements Button {
    public void render() {
        System.out.println("Rendering dark button");
    }
}

class LightTextField implements TextField {
    public void render() {
        System.out.println("Rendering light text field");
    }
}

class DarkTextField implements TextField {
    public void render() {
        System.out.println("Rendering dark text field");
    }
}

interface UIFactory {
    Button createButton();

    TextField createTextField();
}

class LightThemeFactory implements UIFactory {
    public Button createButton() {
        return new LightButton();
    }

    public TextField createTextField() {
        return new LightTextField();
    }
}

class DarkThemeFactory implements UIFactory {
    public Button createButton() {
        return new DarkButton();
    }

    public TextField createTextField() {
        return new DarkTextField();
    }
}
