package org.example;

import java.sql.*;

public class Db {

    private static Connection connection = null;

    public static Connection getConnection() {

        try {
            connection = DriverManager.getConnection(System.getenv("dburl"), System.getenv("user"), System.getenv("password"));
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }
     public static void closeStatement(Statement st){
        if (st != null){
            try {
                st.close();
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
     }

    public static void closeResultSet(ResultSet rs){
        if (rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }
}

