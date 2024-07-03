package javaHashMap;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Data
@AllArgsConstructor
public class Book {
    private String title;
    private String author;
    private int year;
}

class Main {
    private static Map<Book, String> books = new HashMap<>();

    public static void main(String[] args) {
        Book book1 = new Book("Название книги 1", "Автор книги 1", 2000);
        Book book2 = new Book("Название книги 2", "Автор книги 2", 1990);
        Book book3 = new Book("Название книги 3", "Автор книги 3", 2010);
        Book book4 = new Book("Название книги 4", "Автор книги 4", 2000);

        books.put(book1, "Полка 1");
        books.put(book2, "Полка 2");
        books.put(book3, "Полка 3");

        addBook(book4, "Полка 1");
        System.out.println(books);
        System.out.println(deleteBook("Название книги 8", "Автор книги 1", 2000));
        searchBook("Название книги 2", "Автор книги 2", 1990);
        infoBooks();
    }

    public static Map<Book, String> addBook(Book book, String place) {
        if (book != null && place != null) {
            books.put(book, place);
        }
        return books;
    }

    public static String deleteBook(String title, String author, int year) {
        if (books.containsKey(newBook(title, author, year))) {
            books.remove(newBook(title, author, year));
            return "Книга удалена";
        } else {
            return "Ошибка удаления";
        }
    }

    public static void searchBook(String title, String author, int year) {
        System.out.println("Местонахождение книги: " + books.get(newBook(title, author, year)));
    }

    public static void infoBooks() {
        for (Map.Entry<Book, String> entry : books.entrySet()) {
            System.out.println(entry.getKey().getTitle() + " - Местонахождение: " + entry.getValue());
        }
    }

    public static Book newBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        return book;
    }

}
