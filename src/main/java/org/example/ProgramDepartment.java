package org.example;

import java.util.List;
import java.util.Scanner;

public class ProgramDepartment {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("==== TEST 1: department findById ====");
        Department department = departmentDao.findById(1);
        System.out.println(department);
        System.out.println();


        System.out.println();
        System.out.println("==== TEST 2: department findAll ====");
        List<Department> list = departmentDao.findAll();
        for (Department d : list) {
            System.out.println(d);
        }

        System.out.println();
        System.out.println("==== TEST 3: department insert ====");
        Department newDepartment = new Department(null, "Music");
        departmentDao.insert(newDepartment);
        System.out.println("Inserted! New id= " + newDepartment.getId());

        System.out.println();
        System.out.println("==== TEST 4: department update ====");
        Department dep1 = departmentDao.findById(1);
        dep1.setName("Food");
        departmentDao.update(dep1);
        System.out.println("Update completed");

        System.out.println();
        System.out.println("==== TEST 5: department delete ====");
        System.out.println("Enter id for delete test: ");
        int id = sc.nextInt();
        departmentDao.deleteById(id);
        System.out.println("Delete completed");

        sc.close();
    }
}
