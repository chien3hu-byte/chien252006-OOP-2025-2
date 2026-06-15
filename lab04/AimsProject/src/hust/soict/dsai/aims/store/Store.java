package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.media.Media;

import java.util.ArrayList;
import java.util.List;

public class Store {

    private List<Media> itemsInStore = new ArrayList<Media>();

    public void addMedia(Media media) {
        if (itemsInStore.contains(media)) {
            System.out.println("Media \"" + media.getTitle() + "\" is already in the store!");
        } else {
            itemsInStore.add(media);
            System.out.println("Media \"" + media.getTitle() + "\" added to store.");
        }
    }

    public void removeMedia(Media media) {
        if (itemsInStore.contains(media)) {
            itemsInStore.remove(media);
            System.out.println("Media \"" + media.getTitle() + "\" removed from store.");
        } else {
            System.out.println("Media \"" + media.getTitle() + "\" is not in the store!");
        }
    }

    public Media searchByTitle(String title) {
        for (Media m : itemsInStore) {
            if (m.getTitle().equalsIgnoreCase(title)) return m;
        }
        return null;
    }

    public void print() {
        System.out.println("***********************STORE***********************");
        for (int i = 0; i < itemsInStore.size(); i++) {
            System.out.println((i + 1) + ". " + itemsInStore.get(i).toString());
        }
        System.out.println("***************************************************");
    }

    public List<Media> getItemsInStore() {
        return itemsInStore;
    }
}
