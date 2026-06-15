package hust.soict.dsai.aims.media;

public class Track implements Playable {

    private String title;
    private int length;

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public String getTitle() { return title; }
    public int getLength() { return length; }

    @Override
    public void play() {
        if (length <= 0) {
            System.out.println("ERROR: This track cannot be played!");
        } else {
            System.out.println("Playing track: " + title);
            System.out.println("Track length: " + length);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Track)) return false;
        Track track = (Track) o;
        return this.length == track.length
                && this.title != null && this.title.equals(track.title);
    }

    @Override
    public String toString() {
        return "Track: " + title + " - " + length + " min";
    }
}
