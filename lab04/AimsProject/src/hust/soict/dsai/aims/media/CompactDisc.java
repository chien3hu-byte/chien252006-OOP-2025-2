package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc implements Playable {

    private String artist;
    private List<Track> tracks = new ArrayList<Track>();

    public CompactDisc() {
        super();
    }

    public CompactDisc(int id, String title, String category, String director,
                       String artist, float cost) {
        super(id, title, category, cost, 0, director);
        this.artist = artist;
    }

    public String getArtist() { return artist; }

    @Override
    public int getLength() {
        int total = 0;
        for (Track t : tracks) {
            total += t.getLength();
        }
        return total;
    }

    public void addTrack(Track track) {
        if (tracks.contains(track)) {
            System.out.println("Track \"" + track.getTitle() + "\" is already in the CD!");
        } else {
            tracks.add(track);
            System.out.println("Track \"" + track.getTitle() + "\" added successfully.");
        }
    }

    public void removeTrack(Track track) {
        if (!tracks.contains(track)) {
            System.out.println("Track \"" + track.getTitle() + "\" is not in the CD!");
        } else {
            tracks.remove(track);
            System.out.println("Track \"" + track.getTitle() + "\" removed successfully.");
        }
    }

    @Override
    public void play() {
        if (getLength() <= 0) {
            System.out.println("ERROR: CD \"" + getTitle() + "\" cannot be played!");
        } else {
            System.out.println("Playing CD: " + getTitle());
            System.out.println("CD length: " + getLength());
            for (Track t : tracks) {
                t.play();
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CD - Title: ").append(getTitle())
          .append(" - Category: ").append(getCategory())
          .append(" - Artist: ").append(artist)
          .append(" - Director: ").append(getDirector())
          .append(" - Length: ").append(getLength()).append(" min")
          .append(" - Cost: ").append(getCost()).append("$\n");
        sb.append("Tracks:\n");
        for (Track t : tracks) {
            sb.append("  ").append(t.toString()).append("\n");
        }
        return sb.toString().trim();
    }
}
