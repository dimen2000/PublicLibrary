package ws.client;

import javax.xml.ws.WebServiceRef;
import ws.service.PublicLibraryService;
import ws.service.PublicLibrary;
import ws.service.Book;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.net.URL;

public class Employee {
    @WebServiceRef(wsdlLocation="http://localhost:8080/publiclibraryservice/hello?wsdl")
    static PublicLibraryService service;

    public static void main(String[] args) throws Exception{
        Employee client = new Employee();
        PublicLibrary port = service.getPublicLibraryPort();
        Book book = new Book();
        System.out.println(port.getBooks());
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            System.out.print("add ISBN NAME AUTHOR EDITOR COUNT\n");
            System.out.print("exemplar ISBN COUNT\n");
            System.out.print("print\n");
            System.out.print("exit\n");
            String buff = bufferedReader.readLine();
            String[] tokens = buff.split(" ");
            if(tokens[0].equals("add")) {
                if(tokens.length != 6) {
                    System.out.print("invalid arguments in function add\n");
                    continue;
                }
                book.setISBN(tokens[1]); book.setName(tokens[2]);
                book.setAuthor(tokens[3]); book.setEditor(tokens[4]); book.setCount(Integer.parseInt(tokens[5]));
                port.addBook(book);
            } else if (tokens[0].equals("exemplar")) {
                if(tokens.length != 3) {
                    System.out.print("invalid arguments in function exemplar\n");
                    continue;
                }
                port.addExemplars(tokens[1], Integer.parseInt(tokens[2]));
            } else if (tokens[0].equals("print")) {
                System.out.println(port.getBooks());
            } else if (tokens[0].equals("exit")) {
                break;
            }
            
        }
    }
}