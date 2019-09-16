package com.training.ServletLogin;

import com.training.ServletLogin.dao.DaoFactory;
import com.training.ServletLogin.dao.OrderDao;
import com.training.ServletLogin.dao.UserDao;
import com.training.ServletLogin.dao.impl.JDBCOrderDao;
import com.training.ServletLogin.entity.Order;
import com.training.ServletLogin.entity.Route;
import com.training.ServletLogin.entity.User;
import com.training.ServletLogin.entity.enumerated.CargoType;
import com.training.ServletLogin.entity.enumerated.OrderStatus;

import java.time.LocalDate;
import java.util.List;

public class App {
    public static void main(String[] args) {
        DaoFactory daoFactory = DaoFactory.getInstance();
        try (OrderDao dao = daoFactory.createOrderDao()) {
            List<Order> orders = dao.findAll();
            System.out.println(orders);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
