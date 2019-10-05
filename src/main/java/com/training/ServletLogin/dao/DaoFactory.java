package com.training.ServletLogin.dao;

import com.training.ServletLogin.dao.impl.JDBCDaoFactory;

public abstract class DaoFactory {
    private static DaoFactory daoFactory;

    public abstract UserDao createUserDao();

    public abstract OrderDao createOrderDao();

    public abstract RouteDao createRouteDao();

    public static DaoFactory getInstance() {
        System.out.println("I`m here");
        if (daoFactory == null) {
            System.out.println("Im here 2");
            synchronized (DaoFactory.class) {
                System.out.println("Im here 3");
                if (daoFactory == null) {
                    System.out.println("Im here 4");
                    DaoFactory temp = new JDBCDaoFactory();
                    daoFactory = temp;
                }
            }
        }
        return daoFactory;
    }
}