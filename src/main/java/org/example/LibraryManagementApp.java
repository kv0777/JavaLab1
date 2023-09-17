package org.example;

import java.util.ArrayList;
import java.util.List;

record Book(String title, String author, String isbn, int year) {

    @Override
    public String toString() {
        return "Назва: " + title + ", Автор: " + author + ", ISBN: " + isbn + ", Рік видання: " + year;
    }
}

class Library {
    private final List<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void displayBooks() {
        System.out.println("Всього книг у бібліотеці: 3");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public Book findBookByTitle(String title) {
        for (Book book : books) {
            if (book.title().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public void removeBookByIsbn(String isbn) {
        boolean removed = books.removeIf(book -> book.isbn().equals(isbn));
        if (removed) {
            System.out.println("Книга з ISBN " + isbn + " була видалена.");
        } else {
            System.out.println("Книга з ISBN " + isbn + " не знайдена.");
        }
    }


    public static class LibraryManagementApp {
    public static void main(String[] args) {
        Library library = new Library();

        // Додавання книг в бібліотеку
        library.addBook(new Book("Книга 1", "Автор 1", "1234567890", 2020));
        library.addBook(new Book("Книга 2", "Автор 2", "9876543210", 2019));
        library.addBook(new Book("Книга 3", "Автор 3", "5555555555", 2021));

        // Виведення всіх книг в бібліотеці
        library.displayBooks();

        // Пошук книги за назвою
        String searchTitle = "Книга 2";
        Book foundBook = library.findBookByTitle(searchTitle);
        if (foundBook != null) {
            System.out.println("Знайдена книга: " + foundBook);
        } else {
            System.out.println("Книга з назвою '" + searchTitle + "' не знайдена.");
        }

        // Видалення книги за ISBN
        String isbnToRemove = "9876543210";
        library.removeBookByIsbn(isbnToRemove);

        // Повторний вивід всіх книг після видалення
        library.displayBooks();
    }
}

}


