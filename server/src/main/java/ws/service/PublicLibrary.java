package ws.service;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.*;

@WebService
public class PublicLibrary {
  private Hashtable hash;

    public PublicLibrary() {
      hash = new Hashtable();
      Book book1 = new Book("111221", "Mark A.M.", "Melnicha", "Story, Mark", 3);
      Book book2 = new Book("122221", "Tilkin J.R.R", "Byaka", "The Lord of the thing", 5);
      addBook(book1);
      addBook(book2);
    }

    @WebMethod
      public void addBook(Book book) {
        hash.put(book.ISBN, book);
    }

    @WebMethod()
      public void addExemplars(String ISBN, int count) {
        Book book = (Book)hash.get(ISBN);
        if (book == null) {
          System.out.println("Bad ISBN\n");
          return;
        }
        book.count+=count;
        hash.put(ISBN, book);
      }

    @WebMethod()
      public boolean getExemplar(String ISBN) {
        Book book = (Book)hash.get(ISBN);
        if (book == null) {
          System.out.println("Bad ISBN\n");
          return false;
        }
        if(book.count == 0)
          return false;
        book.count--;
        hash.put(ISBN, book);
        return true;
      }

    @WebMethod()
    public String getBooks() {
      Set<String> keys = hash.keySet();
      Iterator<String> iterator = keys.iterator();
      String res = "";
      String str;
      while (iterator.hasNext()) {
        str = iterator.next();
        res += (hash.get(str)).toString() + "\n";
      }
      return res;
    }
}
