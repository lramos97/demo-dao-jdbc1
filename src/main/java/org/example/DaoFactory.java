package org.example;

public class DaoFactory {

    public static SellerDao createSellerDao() {
        return new SellerDaoJDBC(Db.getConnection());
    }

    public static DepartmentDao createDepartmentDao() {
        return new DepartmentDaoJDBC(Db.getConnection());
    }
}
