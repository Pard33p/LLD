package flyweight_pattern;

import java.util.HashMap;
import java.util.Map;

public class FlyweightPattern {
    public static void main(String[] args) {
        String document = "HELLO WORLD";
        for (int i = 0; i < document.length(); i++) {
            char symbol = document.charAt(i);
            CharacterFlyweight character = CharacterFactory.getCharacter(symbol);
            character.display(i * 10, 50);
        }
    }
}

interface CharacterFlyweight {
    void display(int x, int y);
}

class ConcreteCharacter implements CharacterFlyweight {
    private final char symbol;

    public ConcreteCharacter(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public void display(int x, int y) {
        System.out.println("Display symbol : " + symbol + " at location (" + x + ", " + y + ").");
    }
}

class CharacterFactory {
    private static final Map<Character, CharacterFlyweight> characterPool = new HashMap<>();

    public static CharacterFlyweight getCharacter(char symbol) {
        if (!characterPool.containsKey(symbol)) {
            characterPool.put(symbol, new ConcreteCharacter(symbol));
            System.out.println("Created new character: " + symbol);
        }
        return characterPool.get(symbol);
    }
}