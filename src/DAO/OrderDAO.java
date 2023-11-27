package DAO;
import Model.Order;
import Model.Product;

import java.sql.*;

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


}
