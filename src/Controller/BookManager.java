package Controller;

import java.util.*;

import Dao.TextConnection;
import Exception.AppException;
import model.Book;

/**
 * Book Manager Class
 */
public class BookManager {

    private static BookManager bookManager;

    /**
     * @return Book Manager Instance
     */
    public static BookManager getInstance() {
        if (bookManager == null) {
            bookManager = new BookManager();
        }
        return bookManager;
    }

    /**
     * connection to text file
     */
    TextConnection dbConnection = new TextConnection();
    /**
     * book List
     */
    List<Book> bookList = new ArrayList<>();
    /**
     * Scanner
     */
    Scanner scn = new Scanner(System.in);

    public String inputAuthorName() {
        System.out.print("Please input your book Name : ");
        return scn.nextLine();
    }

    public String inputTitle() {
        System.out.println("Please input your book title : ");
        return scn.nextLine();
    }

    public Integer inputStatus() throws AppException {
        System.out.print("Please input your book status(1-active,2-inactive) : ");
        try {
            return scn.nextInt();
        } catch (InputMismatchException e) {
            throw new AppException("Found InputMismatchException ");
        }
    }




    public void addToDb() throws AppException {
        Book book = new Book();
        UUID id = UUID.randomUUID();
        book.setUuid(id);
        book.setAuthorName(bookManager.inputAuthorName());
        book.setTitle(bookManager.inputTitle());
        book.setStatus(bookManager.inputStatus());
        System.out.println(book.toString());
        bookList.add(book);
        System.out.println(Arrays.toString(bookList.toArray()));
        dbConnection.writeToText(bookList);
        System.out.println("Add new Book successfully");
    }
}
