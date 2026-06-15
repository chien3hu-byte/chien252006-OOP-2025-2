package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {

    private List<String> authors = new ArrayList<String>();

    public Book() {
        super();
    }

    public Book(int id, String title, String category, float cost) {
        super(id, title, category, cost);
    }

    public void addAuthor(String authorName) {
        if (authors.contains(authorName)) {
            System.out.println("Author \"" + authorName + "\" is already in the list!");
        } else {
            authors.add(authorName);
            System.out.println("Author \"" + authorName + "\" added successfully.");
        }
    }

    public void removeAuthor(String authorName) {
        if (!authors.contains(authorName)) {
            System.out.println("Author \"" + authorName + "\" is not in the list!");
        } else {
            authors.remove(authorName);
            System.out.println("Author \"" + authorName + "\" removed successfully.");
        }
    }

    @Override
    public String toString() {
        return "Book - Title: " + getTitle()
                + " - Category: " + getCategory()
                + " - Authors: " + authors.toString()
                + " - Cost: " + getCost() + "$";
    }
}
