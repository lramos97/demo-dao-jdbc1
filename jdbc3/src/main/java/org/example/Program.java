package org.example;

import java.sql.*;

public class Program {
    public static void main(String[] args) {

        Connection connection = null;
        PreparedStatement st = null;

        try{
            connection = Db.getConnection();
            st = connection.prepareStatement(
                    "UPDATE seller"
                    + "SET BaseSalary = BaseSalary + ? "
                    + "WHERE "
                    + "DepartmentId = ?");
            st.setDouble(1, 200.0);
            st.setInt(2, 1);

            int rowsAffected = st.executeUpdate();
            System.out.println("Done! Rows affected: " + rowsAffected);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            Db.closeStatement(st);
            Db.closeConnection();
        }
    }
}