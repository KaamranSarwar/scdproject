package DAO;

import Model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    public static void addProduct(Product p )
    {
        Connection connection = DBConnector.getConnection();
        String Query = "Insert Into product(id,pname,price,QinP,tP,totalQuantity,expDate,des,cId) values(?,?,?,?,?,?,?,?,?);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(Query);
            preparedStatement.setInt(1,p.getId());
            preparedStatement.setString(2, p.getName());
            preparedStatement.setDouble(3,p.getPrice());
            preparedStatement.setInt(4,p.getQuantityInPack());
            preparedStatement.setInt(5,p.getTotalPacks());
            preparedStatement.setInt(6,p.getTotalQuantity());
            preparedStatement.setDate(7,new  java.sql.Date(p.getExpDate().getTime()));
            preparedStatement.setString(8,p.getDescription());
            preparedStatement.setInt(9,p.getCategoryID());
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public static void deleteProduct(int id)
    {
        Connection connection = DBConnector.getConnection();
        String Query = "DELETE from product where id = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(Query);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void updateProduct(Product p)
    {
        Connection connection = DBConnector.getConnection();
        String query = "UPDATE product set pname = ?,price = ?,QinP = ?,tP=?,totalQuantity=?,des = ?,cId = ? where id = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, p.getName());
            preparedStatement.setDouble(2,p.getPrice());
            preparedStatement.setInt(3,p.getQuantityInPack());
            preparedStatement.setInt(4,p.getTotalPacks());
            preparedStatement.setInt(5,p.getTotalQuantity());
            preparedStatement.setString(6,p.getDescription());
            preparedStatement.setInt(7,p.getCategoryID());
            preparedStatement.setInt(8,p.getId());
            int count = preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public static boolean checkID(int cid)
    {
        Connection connection = DBConnector.getConnection();
        String Query = "select id from product where id = ?;";
        try {
            PreparedStatement ps = connection.prepareStatement(Query);
            ps.setInt(1,cid);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next())
            {
                return true;
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
    public static List<Product> getAllProducts()
    {
        List<Product> products = new ArrayList<>();
        Connection connection = DBConnector.getConnection();
        String Query = "Select * from product;";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(Query);
            while (resultSet.next())
            {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                double price = resultSet.getDouble(3);
                int QperP = resultSet.getInt(4);
                int TotalPacket = resultSet.getInt(5);
                int total = resultSet.getInt(6);
                java.util.Date date = resultSet.getDate(7);
                String des = resultSet.getString(8);
                int Category = resultSet.getInt(9);
                Product p = new Product(id,name,price,QperP,TotalPacket,total,date,des,Category);
                products.add(p);
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }
    public static List<Product> getProductsByName(String productName) {
        List<Product> products = new ArrayList<>();
        Connection connection = DBConnector.getConnection();
        String query = "SELECT * FROM product WHERE pname LIKE ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "%" + productName + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                double price = resultSet.getDouble(3);
                int QperP = resultSet.getInt(4);
                int TotalPacket = resultSet.getInt(5);
                int total = resultSet.getInt(6);
                java.util.Date date = resultSet.getDate(7);
                String des = resultSet.getString(8);
                int Category = resultSet.getInt(9);
                Product p = new Product(id, name, price, QperP, TotalPacket, total, date, des, Category);
                products.add(p);
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }

}
