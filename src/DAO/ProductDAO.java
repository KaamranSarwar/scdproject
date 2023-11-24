package DAO;

import Model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

}
