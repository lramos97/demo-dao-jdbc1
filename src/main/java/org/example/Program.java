package org.example;

import java.sql.*;

public class Program {
    public static void main(String[] args) {

        Connection connection = null;
        Statement st = null;

        try{
            connection = Db.getConnection();

            connection.setAutoCommit(false); //não ser comitada automaticamente. Será controlado manualmente com commit e rollback

            st = connection.createStatement();

            int rows1 = st.executeUpdate("UPDATE seller SET BaseSalary = 2090 WHERE DepartmentId = 1");

            int x = 1; //forçando um erro
            if( x < 2) {
                throw new SQLException("Fake error");
           }

            int rows2 = st.executeUpdate("UPDATE seller SET BaseSalary = 3090 WHERE DepartmentId = 2");

            connection.commit(); //salvar todas as alterações

            System.out.println("Rows1 " + rows1);
            System.out.println("Rows2 " + rows2);

        }
        catch (SQLException e) {
            try {
                connection.rollback(); //desfaz as alterações
                throw new DbException("Transaction rolled back! Caused by: " + e.getMessage());
            } catch (SQLException e1) {
                throw new DbException("Error trying to rollback! Caused by; " + e1.getMessage());
            }
        }
        finally {
            Db.closeStatement(st);
            Db.closeConnection();
        }
    }
}