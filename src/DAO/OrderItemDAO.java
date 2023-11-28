package DAO;

import Model.Item;
import Model.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrderItemDAO {
    public static void addOrderItems(Order o )
    {
        Connection connection = DBConnector.getConnection();
        String Query = "Insert Into orderitem(Name,price,totalQuantity,totalPrice,orderId) values(?,?,?,?,?);";
        for(Item item : o.getItems())
        {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(Query);
                preparedStatement.setString(1,item.getProduct().getName());
                preparedStatement.setDouble(2,item.getProduct().getPrice());
                preparedStatement.setInt(3,item.getQuantityOrdered());
                preparedStatement.setDouble(4,item.getTotal());
                preparedStatement.setInt(5,o.getId());
                preparedStatement.executeUpdate();

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

}
