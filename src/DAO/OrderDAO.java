package DAO;
import Model.Item;
import Model.Order;
import Model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO {
    public static int getLatestID()
    {
        int ID = 0;
        Connection connection = DBConnector.getConnection();
        String Query = "Select * from orders;";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(Query);
            while (resultSet.next())
            {
                ID = resultSet.getInt(1);
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ID+1;
    }
    public static void addOrder(Order o )
    {
        Connection connection = DBConnector.getConnection();
        String Query = "Insert Into orders(orderPrice,customer,orderDate) values(?,?,?);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(Query);
            preparedStatement.setInt(1,(int)o.getTotal());
            preparedStatement.setString(2, o.getCustomerName());
            preparedStatement.setTimestamp(3,o.getTimestamp());
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static List<Order> getOrdersWithItems() {
        List<Order> orders = new ArrayList<>();
        try (Connection connection = DBConnector.getConnection()) {
            String orderQuery = "SELECT Id, orderPrice, customer, orderDate FROM orders";
            String itemQuery = "SELECT id, Name, price, totalQuantity, totalPrice FROM orderitem WHERE orderId = ?";

            try (PreparedStatement orderStatement = connection.prepareStatement(orderQuery);
                 ResultSet orderResultSet = orderStatement.executeQuery()) {

                while (orderResultSet.next()) {
                    int orderId = orderResultSet.getInt("Id");
                    int orderPrice = orderResultSet.getInt("orderPrice");
                    String customerName = orderResultSet.getString("customer");
                    Timestamp orderDate = orderResultSet.getTimestamp("orderDate");

                    try (PreparedStatement itemStatement = connection.prepareStatement(itemQuery)) {
                        itemStatement.setInt(1, orderId);
                        try (ResultSet itemResultSet = itemStatement.executeQuery()) {
                            List<Item> items = new ArrayList<>();
                            while (itemResultSet.next()) {
                                int itemId = itemResultSet.getInt("id");
                                String itemName = itemResultSet.getString("Name");
                                double itemPrice = itemResultSet.getDouble("price");
                                int totalQuantity = itemResultSet.getInt("totalQuantity");
                                double totalPrice = itemResultSet.getDouble("totalPrice");

                                Product product = new Product(itemId, itemName, itemPrice);
                                Item item = new Item(product, totalQuantity);
                                items.add(item);
                            }

                            Order order = new Order(items, customerName, orderId);
                            order.setTotal(orderPrice);
                            order.setCustomerName(customerName);
                            order.setTimestamp(orderDate);
                            orders.add(order);
                        }
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return orders;
    }

    public static List<Order> getOrdersWithItemsOnDate(Date specificDate) {
        List<Order> orders = new ArrayList<>();
        try (Connection connection = DBConnector.getConnection()) {
            String orderQuery = "SELECT Id, orderPrice, customer, orderDate FROM orders WHERE DATE(orderDate) = ?";
            String itemQuery = "SELECT id, Name, price, totalQuantity, totalPrice FROM orderitem WHERE orderId = ?";

            try (PreparedStatement orderStatement = connection.prepareStatement(orderQuery)) {
                java.sql.Date sqlDate = new java.sql.Date(specificDate.getTime());
                orderStatement.setDate(1, sqlDate);
                try (ResultSet orderResultSet = orderStatement.executeQuery()) {
                    while (orderResultSet.next()) {
                        int orderId = orderResultSet.getInt("Id");
                        int orderPrice = orderResultSet.getInt("orderPrice");
                        String customerName = orderResultSet.getString("customer");
                        Timestamp orderDate = orderResultSet.getTimestamp("orderDate");

                        try (PreparedStatement itemStatement = connection.prepareStatement(itemQuery)) {
                            itemStatement.setInt(1, orderId);
                            try (ResultSet itemResultSet = itemStatement.executeQuery()) {
                                List<Item> items = new ArrayList<>();
                                while (itemResultSet.next()) {
                                    int itemId = itemResultSet.getInt("id");
                                    String itemName = itemResultSet.getString("Name");
                                    double itemPrice = itemResultSet.getDouble("price");
                                    int totalQuantity = itemResultSet.getInt("totalQuantity");
                                    double totalPrice = itemResultSet.getDouble("totalPrice");

                                    Product product = new Product(itemId, itemName, itemPrice);
                                    Item item = new Item(product, totalQuantity);
                                    items.add(item);
                                }

                                Order order = new Order(items, customerName, orderId);
                                order.setTotal(orderPrice);
                                order.setCustomerName(customerName);
                                order.setTimestamp(orderDate);
                                orders.add(order);
                            }
                        }
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return orders;
    }
    public static List<Order> getOrdersBetweenDates(Date date1, Date date2) {
        List<Order> orders = new ArrayList<>();
        try (Connection connection = DBConnector.getConnection()) {
            String orderQuery = "SELECT Id, orderPrice, customer, orderDate FROM orders WHERE DATE(orderDate) BETWEEN ? AND ?";
            String itemQuery = "SELECT id, Name, price, totalQuantity, totalPrice FROM orderitem WHERE orderId = ?";

            // Determine start and end dates
            java.sql.Date startDate = new java.sql.Date(Math.min(date1.getTime(), date2.getTime()));
            java.sql.Date endDate = new java.sql.Date(Math.max(date1.getTime(), date2.getTime()));

            try (PreparedStatement orderStatement = connection.prepareStatement(orderQuery)) {
                orderStatement.setDate(1, startDate);
                orderStatement.setDate(2, endDate);

                try (ResultSet orderResultSet = orderStatement.executeQuery()) {
                    while (orderResultSet.next()) {
                        int orderId = orderResultSet.getInt("Id");
                        int orderPrice = orderResultSet.getInt("orderPrice");
                        String customerName = orderResultSet.getString("customer");
                        Timestamp orderDate = orderResultSet.getTimestamp("orderDate");

                        try (PreparedStatement itemStatement = connection.prepareStatement(itemQuery)) {
                            itemStatement.setInt(1, orderId);
                            try (ResultSet itemResultSet = itemStatement.executeQuery()) {
                                List<Item> items = new ArrayList<>();
                                while (itemResultSet.next()) {
                                    int itemId = itemResultSet.getInt("id");
                                    String itemName = itemResultSet.getString("Name");
                                    double itemPrice = itemResultSet.getDouble("price");
                                    int totalQuantity = itemResultSet.getInt("totalQuantity");
                                    double totalPrice = itemResultSet.getDouble("totalPrice");

                                    Product product = new Product(itemId, itemName, itemPrice);
                                    Item item = new Item(product, totalQuantity);
                                    items.add(item);
                                }

                                Order order = new Order(items, customerName, orderId);
                                order.setTotal(orderPrice);
                                order.setCustomerName(customerName);
                                order.setTimestamp(orderDate);
                                orders.add(order);
                            }
                        }
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return orders;
    }
    public static void deleteOrder(int id) throws SQLException {
        try {
            Connection connection=DBConnector.getConnection();
            String Query = "delete from pos.orders where Id=?";
            PreparedStatement preparedStatement=connection.prepareStatement(Query);
            preparedStatement.setInt(1,id);
            preparedStatement.execute();
            connection.close();
        } catch(SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

}
