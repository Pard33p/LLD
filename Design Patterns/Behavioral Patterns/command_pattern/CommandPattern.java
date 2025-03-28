package command_pattern;

public class CommandPattern {

    public static void main(String[] args) {
        TV tv = new TV();

        Command turnOnCommand = new TurnOnCommand(tv);
        Command turnOffCommand = new TurnOffCommand(tv);

        RemoteControl remoteControl = new RemoteControl();
        remoteControl.setCommand(turnOnCommand);
        remoteControl.pressButton();
        remoteControl.pressUndo();

        remoteControl.setCommand(turnOffCommand);
        remoteControl.pressButton();
        remoteControl.pressUndo();
    }
}

interface Command {
    void execute();

    void undo();
}

class TV {
    public void turnOn() {
        System.out.println("TV is turned ON.");
    }

    public void turnOff() {
        System.out.println("TV is turned OFF.");
    }
}

class TurnOnCommand implements Command {
    private TV tv;

    public TurnOnCommand(TV tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.turnOn();
    }

    @Override
    public void undo() {
        tv.turnOff();
    }
}

class TurnOffCommand implements Command {
    private TV tv;

    public TurnOffCommand(TV tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.turnOff();
    }

    @Override
    public void undo() {
        tv.turnOn();
    }
}

class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }

    public void pressUndo() {
        command.undo();
    }
}
