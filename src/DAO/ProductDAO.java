package DAO;

import Model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductDAO {
    public static void addProduct(Product p )
    {
        Connection connection = DBConnector.getConnection();
            String Query = "Insert Into product(id,pname,des,sQuantity,price,cId) values(?,?,?,?,?,?);";
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(Query);
                preparedStatement.setInt(1,p.getId());
                preparedStatement.setString(2, p.getName());
                preparedStatement.setString(3,p.getDescription());
                preparedStatement.setInt(4,p.getStockQuantity());
                preparedStatement.setDouble(5,p.getPrice());
                preparedStatement.setInt(6,p.getCategoryID());
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

}
