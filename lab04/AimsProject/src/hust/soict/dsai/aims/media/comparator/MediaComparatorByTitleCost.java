package hust.soict.dsai.aims.media.comparator;

import hust.soict.dsai.aims.media.Media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {

    @Override
    public int compare(Media m1, Media m2) {
        int cmp = m1.getTitle().compareTo(m2.getTitle());
        if (cmp != 0) return cmp;
        // Same title -> higher cost first
        return Float.compare(m2.getCost(), m1.getCost());
    }
}
