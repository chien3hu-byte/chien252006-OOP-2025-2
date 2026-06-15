package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {

    public DigitalVideoDisc() {
        super();
    }

    public DigitalVideoDisc(String title) {
        super(0, title, "", 0.0f, 0, "");
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        super(0, title, category, cost, 0, "");
    }

    public DigitalVideoDisc(String title, String category, String director, float cost) {
        super(0, title, category, cost, 0, director);
    }

    public DigitalVideoDisc(int id, String title, String category, String director,
                            int length, float cost) {
        super(id, title, category, cost, length, director);
    }

    @Override
    public void play() {
        if (getLength() <= 0) {
            System.out.println("ERROR: DVD \"" + getTitle() + "\" cannot be played!");
        } else {
            System.out.println("Playing DVD: " + getTitle());
            System.out.println("DVD length: " + getLength());
        }
    }

    @Override
    public String toString() {
        return "DVD - Title: " + getTitle()
                + " - Category: " + getCategory()
                + " - Director: " + getDirector()
                + " - Length: " + getLength() + " min"
                + " - Cost: " + getCost() + "$";
    }
}
