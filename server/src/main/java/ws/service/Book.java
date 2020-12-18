package ws.service;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.*;

public class Book {
        public Book() {}
        public Book(String ISBN,  String author, String editor, String name, int count) {
                this.ISBN = ISBN;
                this.author = author;
                this.editor = editor;
                this.name =  name;
                this.count = count;
        }
        public String ISBN;
        public String author;
        public String editor;
        public String name;
        public int count;
        public String toString() {
                return "Book: ISBN="+ ISBN + "\tname=" + name + "\tauthor=" + author + 
                "\teditor=" + editor + "\tcount=" + count + "";
        }
    }