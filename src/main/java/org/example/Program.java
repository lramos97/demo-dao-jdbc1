package org.example;

import java.sql.*;

public class Program {
    public static void main(String[] args) {

    Department obj = new Department(1, "Books");
    Seller seller = new Seller(21, "Bob", "bob@gmail.com", 3000.0, obj);
        System.out.println(seller);
    }
}