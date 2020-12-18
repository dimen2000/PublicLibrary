package ws.client;

import javax.xml.ws.WebServiceRef;
import ws.service.PublicLibraryService;
import ws.service.PublicLibrary;
import ws.service.Book;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.net.URL;

public class Reader {
    @WebServiceRef(wsdlLocation="http://localhost:8080/publiclibraryservice/hello?wsdl")
    static PublicLibraryService service;

    public static void main(String[] args) throws Exception{
        Reader client = new Reader();
        PublicLibrary port = service.getPublicLibraryPort();
        Book book = new Book();
        System.out.println(port.getBooks());
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            System.out.print("take ISBN\n");
            System.out.print("return ISBN\n");
            System.out.print("print\n");]
            System.out.print("exit\n");
            String buff = bufferedReader.readLine();
            String[] tokens = buff.split(" ");
            if(tokens[0].equals("take")) {
                if(tokens.length != 2) {
                    System.out.print("invalid arguments in function take");
                    continue;
                }
                if(!port.getExemplar(tokens[1]))
                    System.out.print("out of stock");
            } else if (tokens[0].equals("return")) {
                if(tokens.length != 2) {
                    System.out.print("invalid arguments in function return");
                    continue;
                }
                port.addExemplars(tokens[1], 1);
            } else if (tokens[0].equals("print")) {
                System.out.println(port.getBooks());
            } else if (tokens[0].equals("exit")) {
                break;
            }
        }
    }
}