package state_pattern;

public class StatePattern {
    public static void main(String[] args) {
        ATMMachine atm = new ATMMachine(1000);

        atm.insertCard();
        atm.enterPin("1234");
        atm.withdrawCash(500);
        atm.ejectCard();

        atm.insertCard();
        atm.enterPin("1111");
        atm.withdrawCash(500);
        atm.ejectCard();

        atm.insertCard();
    }
}

interface ATMState {
    void insertCard();

    void ejectCard();

    void enterPin(String pin);

    void withdrawCash(int amount);
}

class NoCard implements ATMState {
    private ATMMachine atmMachine;

    public NoCard(ATMMachine atmMachine) {
        this.atmMachine = atmMachine;
    }

    @Override
    public void insertCard() {
        System.out.println("Card inserted. Please enter your PIN.");
        atmMachine.setState(atmMachine.getHasCardState());
    }

    @Override
    public void ejectCard() {
        System.out.println("No card in the machine");
    }

    @Override
    public void enterPin(String pin) {
        System.out.println("Insert a card first.");
    }

    @Override
    public void withdrawCash(int amount) {
        System.out.println("Insert a card first.");
    }
}

class HasCard implements ATMState {
    private ATMMachine atmMachine;

    public HasCard(ATMMachine atmMachine) {
        this.atmMachine = atmMachine;
    }

    @Override
    public void insertCard() {
        System.out.println("Card already inserted.");
    }

    @Override
    public void ejectCard() {
        System.out.println("Card ejected");
        atmMachine.setState(atmMachine.getNoCardState());
    }

    @Override
    public void enterPin(String pin) {
        if (pin.equals("1234")) {
            System.out.println("Correct PIN entered.");
            atmMachine.setState(atmMachine.getHasCorrectPinState());
        } else {
            System.out.println("Incorrect PIN. Try again.");
        }
    }

    @Override
    public void withdrawCash(int amount) {
        System.out.println("Enter PIN first.");
    }
}

class HasCorrectPin implements ATMState {
    private ATMMachine atmMachine;

    public HasCorrectPin(ATMMachine atmMachine) {
        this.atmMachine = atmMachine;
    }

    @Override
    public void insertCard() {
        System.out.println("Card already inserted.");
    }

    @Override
    public void ejectCard() {
        System.out.println("Card ejected.");
        atmMachine.setState(atmMachine.getNoCardState());
    }

    @Override
    public void enterPin(String pin) {
        System.out.println("PIN already entered.");
    }

    @Override
    public void withdrawCash(int amount) {
        if (atmMachine.getCashInMachine() >= amount) {
            System.out.println("Amount withdrawn: " + amount);
            atmMachine.setCashInMachine(atmMachine.getCashInMachine() - amount);
            if (atmMachine.getCashInMachine() == 0) {
                atmMachine.setState(atmMachine.getNoCashState());
            } else {
                atmMachine.setState(atmMachine.getNoCardState());
            }
        } else {
            System.out.println("Not enough cash available.");
            atmMachine.setState(atmMachine.getNoCardState());
        }
    }
}

class NoCash implements ATMState {
    @SuppressWarnings("unused")
    private ATMMachine atmMachine;

    public NoCash(ATMMachine atmMachine) {
        this.atmMachine = atmMachine;
    }

    @Override
    public void insertCard() {
        System.out.println("ATM is out of cash.");
    }

    @Override
    public void ejectCard() {
        System.out.println("No card in the machine.");
    }

    @Override
    public void enterPin(String pin) {
        System.out.println("ATM is out of cash.");
    }

    @Override
    public void withdrawCash(int amount) {
        System.out.println("ATM is out of cash.");
    }
}

class ATMMachine {
    private ATMState noCardState;
    private ATMState hasCardState;
    private ATMState hasCorrectPinState;
    private ATMState noCashState;

    private ATMState currentState;
    private int cashInMachine;

    public ATMMachine(int cash) {
        this.noCardState = new NoCard(this);
        this.hasCardState = new HasCard(this);
        this.hasCorrectPinState = new HasCorrectPin(this);
        this.noCashState = new NoCash(this);

        this.cashInMachine = cash;
        this.currentState = (cash > 0) ? noCardState : noCashState;
    }

    public void setState(ATMState state) {
        this.currentState = state;
    }

    public void insertCard() {
        this.currentState.insertCard();
    }

    public void ejectCard() {
        currentState.ejectCard();
    }

    public void enterPin(String pin) {
        currentState.enterPin(pin);
    }

    public void withdrawCash(int amount) {
        currentState.withdrawCash(amount);
    }

    public int getCashInMachine() {
        return cashInMachine;
    }

    public void setCashInMachine(int cash) {
        this.cashInMachine = cash;
    }

    public ATMState getNoCardState() {
        return noCardState;
    }

    public ATMState getHasCardState() {
        return hasCardState;
    }

    public ATMState getHasCorrectPinState() {
        return hasCorrectPinState;
    }

    public ATMState getNoCashState() {
        return noCashState;
    }
}
