package hust.soict.dsai.aims.disc;

/**
 * Represents a DVD in the AIMS system.
 *
 * Exercise 5 (Classifier Member):
 *   - nbDigitalVideoDiscs: class (static) variable - counts total DVDs created
 *   - id: instance variable - unique ID assigned to each DVD
 *
 * Exercise 6:
 *   - toString(): for formatted cart printing
 *   - isMatch(String title): for title-based search
 */
public class DigitalVideoDisc {

    // Exercise 5: Classifier (static) member - shared across all instances
    private static int nbDigitalVideoDiscs = 0;

    // Exercise 5: Instance member - unique per DVD
    private int id;

    // Instance fields
    private String title;
    private String category;
    private String director;
    private int    length;   // in minutes
    private float  cost;

    // ----------------------------------------------------------------
    // Constructors
    // ----------------------------------------------------------------

    public DigitalVideoDisc(String title) {
        this.title = title;
        nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs;
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        this.title    = title;
        this.category = category;
        this.cost     = cost;
        nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs;
    }

    public DigitalVideoDisc(String title, String category, String director,
                            int length, float cost) {
        this.title    = title;
        this.category = category;
        this.director = director;
        this.length   = length;
        this.cost     = cost;
        nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs;
    }

    // ----------------------------------------------------------------
    // Getters & Setters
    // ----------------------------------------------------------------

    public int getId()            { return id; }
    public String getTitle()      { return title; }
    public String getCategory()   { return category; }
    public String getDirector()   { return director; }
    public int getLength()        { return length; }
    public float getCost()        { return cost; }

    // Setter for title (needed by TestPassingParameter – Exercise 3)
    public void setTitle(String title) { this.title = title; }

    // Exercise 5: static getter for classifier member
    public static int getNbDigitalVideoDiscs() { return nbDigitalVideoDiscs; }

    // ----------------------------------------------------------------
    // Exercise 6: isMatch – matching rule from Lab02
    // A DVD matches if its title contains the search string (case-insensitive)
    // ----------------------------------------------------------------
    public boolean isMatch(String searchTitle) {
        if (searchTitle == null || this.title == null) return false;
        return this.title.toLowerCase().contains(searchTitle.toLowerCase());
    }

    // ----------------------------------------------------------------
    // Exercise 6: toString – used when printing the cart
    // ----------------------------------------------------------------
    @Override
    public String toString() {
        return "DVD - " + title
                + " - " + (category != null ? category : "N/A")
                + " - " + (director != null ? director : "N/A")
                + " - " + length + " min"
                + ": " + cost + " $";
    }
}
