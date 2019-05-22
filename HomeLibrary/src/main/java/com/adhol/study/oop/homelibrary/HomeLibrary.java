package com.adhol.study.oop.homelibrary;

import java.io.*;
import java.util.*;

import static java.lang.System.exit;

public class HomeLibrary {

    private static Scanner in = new Scanner(System.in);

    private List<Book> listOfBooks = new ArrayList<>();


    public void showHomeLibrary() {
        showMainMenu();
        System.out.println("Please select menu item:");
        while (true) {
            try {
                int item = in.nextInt();
                switch (item) {
                    case 1:
                        System.out.println("You selected: " + item);
                        showSortingMenu();
                        showMainMenu();
                        break;
                    case 2:
                        System.out.println("You selected: " + item);
                        showSearchingMenu();
                        showMainMenu();
                        break;
                    case 3:
                        System.out.println("You selected: " + item);
                        addBook();
                        showMainMenu();
                        break;
                    case 4:
                        System.out.println("You selected: " + item);
                        removeBook();
                        showMainMenu();
                        break;
                    case 5:
                        System.out.println("You selected: " + item);
                        saveBooksToFile();
                        exit(0);
                        break;
                    default:
                        System.out.println("You selected wrong item, try again");
                        showMainMenu();
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Not correct item, try again");
                showMainMenu();
            }
        }
    }

    private void showMainMenu() {
        System.out.println("\tMain Menu\n1 - Show all books\n2 - Search book\n3 - Add book\n4 - Remove book\n" +
                "5 - Exit program");
    }

    private void showSortingMenu() {
        String menu = "\tSortingMenu\n1 - Sort by name\n2 - Sort by author\n3 - Sort by year\n" +
                "4 - Sort by number of pages\n5 - back";
        System.out.println(menu);
        while (true) {
            try {
                int sortItem = in.nextInt();
                switch (sortItem) {
                    case 1:
                        sortBookByName();
                        System.out.println(menu);
                        break;
                    case 2:
                        sortBookByAuthor();
                        System.out.println(menu);
                        break;
                    case 3:
                        sortBookByYear();
                        System.out.println(menu);
                        break;
                    case 4:
                        sortBookByNumberOfPages();
                        System.out.println(menu);
                        break;
                    case 5:
                        return;
                    default:
                        System.out.println("You selected wrong item, try again");
                        System.out.println(menu);
                }

            } catch (java.util.InputMismatchException e) {
                System.out.println("Not correct item, try again");
                return;
            }
        }
    }

    private void showSearchingMenu() {
        String menu = "\tSearchingMenu\n1 - Search by name\n2 - Search by author\n3 - Search by year\n" +
                "4 - Search by number of pages\n5 - back";
        System.out.println(menu);
        while (true) {
            try {
                int searchItem = in.nextInt();
                switch (searchItem) {
                    case 1:
                        searchByName();
                        System.out.println(menu);
                        break;
                    case 2:
                        searchByAuthor();
                        System.out.println(menu);
                        break;
                    case 3:
                        searchByYear();
                        System.out.println(menu);
                        break;
                    case 4:
                        searchByNumberOfPages();
                        System.out.println(menu);
                        break;
                    case 5:
                        return;
                    default:
                        System.out.println("You selected wrong item, try again");
                        System.out.println(menu);
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Not correct item, try again");
                return;
            }
        }
    }

    private void showListOfBooks() {
        if (listOfBooks.isEmpty()) {
            loadBooksFromFile();
        }
        if (listOfBooks.size() == 0) {
            System.out.println("List of books is empty");
        } else {
            for (Book book : listOfBooks) {
                System.out.println(book);
            }
        }
    }

    private void addBook() {
        while (true) {
            try {
                in.nextLine();
                System.out.println("Enter name of book:");
                String bookName = in.nextLine();
                System.out.println("Enter author of book");
                String bookAuthor = in.nextLine();
                System.out.println("Enter year of issue of book");
                int bookYearOfIssue = in.nextInt();
                System.out.println("Enter number of pages");
                int bookNumOfPages = in.nextInt();
                System.out.println("You added Book");
                Book book = new Book(bookName, bookAuthor, bookYearOfIssue, bookNumOfPages);
                listOfBooks.add(book);
                return;
            } catch (java.util.InputMismatchException e) {
                System.out.println("Wrong data, try again");
            }
        }

    }

    private void removeBook() {
        if (listOfBooks.isEmpty()) {
            loadBooksFromFile();
        }
        if (listOfBooks.size() == 0) {
            System.out.println("List of books is empty");
        } else {
            System.out.println("number of books: " + listOfBooks.size());
            for (int i = 0; i < listOfBooks.size(); i++) {
                System.out.printf("%d - %s\n", i + 1, listOfBooks.get(i));
            }
            System.out.println("Which book do you want to remove from the list?:");
            int id = in.nextInt();
            if (id >= 1 && id <= listOfBooks.size()) {
                listOfBooks.remove(id - 1);
                saveBooksToFile();
            } else {
                System.out.println("book not found");
            }
        }
    }

    private void saveBooksToFile() {
        try (ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream("HomeLibrary.dat"))) {
            writer.writeObject(listOfBooks);
        } catch (IOException e) {
            System.out.println("file not found");
        }
    }

    private void loadBooksFromFile() {
        try (ObjectInputStream reader = new ObjectInputStream(new FileInputStream("HomeLibrary.dat"))) {
            listOfBooks = ((ArrayList<Book>) reader.readObject());
        } catch (IOException e) {
            System.out.println("file not found");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void sortBookByAuthor() {
        listOfBooks.sort(new Comparator<Book>() {
            @Override
            public int compare(Book book, Book otherBook) {
                if (book.getAuthor().equals(otherBook.getAuthor())) {
                    return book.getName().compareTo(otherBook.getName());
                } else {
                    return book.getAuthor().compareTo(otherBook.getAuthor());
                }
            }
        });
        showListOfBooks();
    }

    private void sortBookByName() {
        listOfBooks.sort(new Comparator<Book>() {
            @Override
            public int compare(Book book, Book otherBook) {
                if (book.getName().equals(otherBook.getName())) {
                    return book.getAuthor().compareTo(otherBook.getAuthor());
                } else {
                    return book.getName().compareTo(otherBook.getName());
                }
            }
        });
        showListOfBooks();
    }

    private void sortBookByYear() {
        listOfBooks.sort(new Comparator<Book>() {
            @Override
            public int compare(Book book, Book otherBook) {
                if (book.getYearOfIssue() == otherBook.getYearOfIssue()) {
                    return book.getName().compareTo(otherBook.getName());
                } else if (book.getYearOfIssue() > otherBook.getYearOfIssue()) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });
        showListOfBooks();
    }

    private void sortBookByNumberOfPages() {
        listOfBooks.sort(new Comparator<Book>() {
            @Override
            public int compare(Book book, Book otherBook) {
                if (book.getNumberOfPages() == otherBook.getNumberOfPages()) {
                    return book.getName().compareTo(otherBook.getName());
                } else if (book.getNumberOfPages() > otherBook.getNumberOfPages()) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });
        showListOfBooks();
    }

    private void searchByName() {
        if (listOfBooks.isEmpty()) {
            loadBooksFromFile();
        }
        if (listOfBooks.size() == 0) {
            System.out.println("List of books is empty");
        } else {
            while (true) {
                try {
                    int count = 0;
                    in.nextLine();
                    System.out.println("Enter name of book for search");
                    String name = in.nextLine();
                    for (Book book : listOfBooks) {
                        if (name.equals(book.getName())) {
                            System.out.println(book);
                            count++;
                        }
                    }
                    if (count == 0) {
                        System.out.println("Book not found");
                    }
                    return;
                } catch (java.util.InputMismatchException e) {
                    System.out.println("Not correct data, try again");
                }
            }
        }
    }

    private void searchByAuthor() {
        if (listOfBooks.isEmpty()) {
            loadBooksFromFile();
        }
        if (listOfBooks.size() == 0) {
            System.out.println("List of books is empty");
        } else {
            while (true) {
                try {
                    int count = 0;
                    in.nextLine();
                    System.out.println("Enter author for search");
                    String author = in.nextLine();
                    for (Book book : listOfBooks) {
                        if (author.equals(book.getAuthor())) {
                            System.out.println(book);
                            count++;
                        }
                    }
                    if (count == 0) {
                        System.out.println("Book not found");
                    }
                    return;
                } catch (java.util.InputMismatchException e) {
                    System.out.println("Not correct data, try again");
                }
            }
        }
    }

    private void searchByYear() {
        if (listOfBooks.isEmpty()) {
            loadBooksFromFile();
        }
        if (listOfBooks.size() == 0) {
            System.out.println("List of books is empty");
        } else {
            while (true) {
                try {
                    int count = 0;
                    in.nextLine();
                    System.out.println("Enter year of issue of book for search");
                    int year = in.nextInt();
                    for (Book book : listOfBooks) {
                        if (year == book.getYearOfIssue()) {
                            System.out.println(book);
                            count++;
                        }
                    }
                    if (count == 0) {
                        System.out.println("Book not found");
                    }
                    return;
                } catch (java.util.InputMismatchException e) {
                    System.out.println("Not correct data, try again");
                }
            }
        }
    }

    private void searchByNumberOfPages() {
        if (listOfBooks.isEmpty()) {
            loadBooksFromFile();
        }
        if (listOfBooks.size() == 0) {
            System.out.println("List of books is empty");
        } else {
            while (true) {
                try {
                    int count = 0;
                    in.nextLine();
                    System.out.println("Enter number of pages for search");
                    int numOfPages = in.nextInt();
                    for (Book book : listOfBooks) {
                        if (numOfPages == book.getNumberOfPages()) {
                            System.out.println(book);
                            count++;
                        }
                    }
                    if (count == 0) {
                        System.out.println("Book not found");
                    }
                    return;
                } catch (java.util.InputMismatchException e) {
                    System.out.println("Not correct data, try again");
                }
            }
        }
    }
}
