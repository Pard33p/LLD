package facade_pattern;

public class FacadePattern {

    public static void main(String[] args) {
        DVDPlayer dvdPlayer = new DVDPlayer();
        Projector projector = new Projector();
        SoundSystem soundSystem = new SoundSystem();
        Lights lights = new Lights();

        HomeTheaterFacade homeTheater = new HomeTheaterFacade(dvdPlayer, projector, soundSystem, lights);

        homeTheater.watchMovie("Interstellar");
        homeTheater.endMovie();
    }

}

class DVDPlayer {
    void turnOn() {
        System.out.println("DVD player is ON.");
    }

    void turnOff() {
        System.out.println("DVD player is OFF.");
    }

    void playMovie(String movie) {
        System.out.println("Playing " + movie);
    }
}

class Projector {
    void turnOn() {
        System.out.println("Projector is ON.");
    }

    void turnOff() {
        System.out.println("Projector is OFF.");
    }

    void setInput(String input) {
        System.out.println("Set input as " + input + " in projector.");
    }
}

class SoundSystem {
    void turnOn() {
        System.out.println("Sound system is ON.");
    }

    void turnOff() {
        System.out.println("Sound system is OFF.");
    }

    void setVolume(int volume) {
        System.out.println("Set volume to: " + volume);
    }
}

class Lights {
    void dim(int level) {
        System.out.println("Set lights to level: " + level);
    }
}

class HomeTheaterFacade {
    private DVDPlayer dvdPlayer;
    private Projector projector;
    private SoundSystem soundSystem;
    private Lights lights;

    public HomeTheaterFacade(DVDPlayer dvdPlayer, Projector projector, SoundSystem soundSystem, Lights lights) {
        this.dvdPlayer = dvdPlayer;
        this.projector = projector;
        this.soundSystem = soundSystem;
        this.lights = lights;
    }

    public void watchMovie(String movie) {
        System.out.println("Setting up home theater..");
        lights.dim(30);
        projector.turnOn();
        projector.setInput("DVD");
        soundSystem.turnOn();
        soundSystem.setVolume(50);
        dvdPlayer.turnOn();
        dvdPlayer.playMovie(movie);
        System.out.println("Enjoy your movie!");
    }

    public void endMovie() {
        System.out.println("Shutting down home theater..");
        dvdPlayer.turnOff();
        projector.turnOff();
        soundSystem.turnOff();
        lights.dim(100);
        System.out.println("Goodbye!");
    }
}
