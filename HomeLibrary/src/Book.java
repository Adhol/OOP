import java.io.Serializable;

public class Book implements Serializable {
    private String name;
    private String author;
    private int yearOfIssue;
    private int numberOfPages;

    public Book(String name, String author, int yearOfIssue, int numberOfPages) {
        this.name = name;
        this.author = author;
        this.yearOfIssue = yearOfIssue;
        this.numberOfPages = numberOfPages;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getYearOfIssue() {
        return yearOfIssue;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    @Override
    public String toString() {
        return "Book " +
                "name: '" + name.toUpperCase() + '\'' +
                ", author: '" + author.toUpperCase() + '\'' +
                ", year of issue: " + yearOfIssue +
                ", number of pages: " + numberOfPages;
    }
}


