// Subsystem 1
class Amplifier {
    public void on() {
        System.out.println("Amplifier on.");
    }

    public void off() {
        System.out.println("Amplifier off.");
    }
}

// Subsystem 2
class DVDPlayer {
    public void on() {
        System.out.println("DVD Player on.");
    }

    public void play(String movie) {
        System.out.println("Playing movie: " + movie);
    }

    public void off() {
        System.out.println("DVD Player off.");
    }
}

// Subsystem 3
class Projector {
    public void on() {
        System.out.println("Projector on.");
    }

    public void off() {
        System.out.println("Projector off.");
    }
}

// Façade
class HomeTheaterFacade {
    private Amplifier amp;
    private DVDPlayer dvd;
    private Projector projector;

    public HomeTheaterFacade(Amplifier amp, DVDPlayer dvd, Projector projector) {
        this.amp = amp;
        this.dvd = dvd;
        this.projector = projector;
    }

    public void watchMovie(String movie) {
        System.out.println("Get ready to watch a movie...");
        amp.on();
        dvd.on();
        projector.on();
        dvd.play(movie);
    }

    public void endMovie() {
        System.out.println("Shutting movie theater down...");
        projector.off();
        dvd.off();
        amp.off();
    }
}

// Main
public class FacadeExample {
    public static void main(String[] args) {
        Amplifier amp = new Amplifier();
        DVDPlayer dvd = new DVDPlayer();
        Projector projector = new Projector();

        HomeTheaterFacade homeTheater = new HomeTheaterFacade(amp, dvd, projector);
        homeTheater.watchMovie("Inception");
        homeTheater.endMovie();
    }
}
