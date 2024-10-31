package org.example;

public class DaoFactory {

    public static SellerDao createSellerDao() {
        return new SellerDaoJDBC(Db.getConnection());
    }
}
