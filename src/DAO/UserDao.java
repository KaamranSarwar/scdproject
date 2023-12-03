package DAO;

import Model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    /**
     * Adds a new user to the database.
     *
     * @param user The user object to be added
     * @throws RuntimeException if there's an issue executing the SQL query
     */
    public static void addUser(User user){
        Connection connection = DBConnector.getConnection();
        String Query = "Insert Into user(username,name,password,role) values(?,?,?,?);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(Query);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2,user.getName());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getRole());
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * Updates an existing user in the database based on their ID.
     *
     * @param user The user object containing updated information
     * @throws RuntimeException if there's an issue executing the SQL query
     */
    public static void updateUserById(User user) {
        Connection connection = DBConnector.getConnection();
        String query = "UPDATE user SET name = ?, username = ?, password = ?, role = ? WHERE id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getUsername());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getRole());
            preparedStatement.setString(5, user.getId());

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("User with ID " + user.getId() + " updated successfully.");
            } else {
                System.out.println("User with ID " + user.getId() + " not found or update failed.");
            }

            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Checks if a user exists based on the provided username.
     *
     * @param user The user object containing the username to check
     * @return true if the user exists, false otherwise
     * @throws RuntimeException if there's an issue executing the SQL query
     */
    public static boolean getUser(User user) {
        Connection connection = DBConnector.getConnection();
        String query = "SELECT * FROM user WHERE username = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, user.getUsername());
            //preparedStatement.setString(2, user.getPassword());
            ResultSet resultSet = preparedStatement.executeQuery();
            boolean userExists = resultSet.next(); // Check if a matching user was found

            resultSet.close();
            connection.close();
            return userExists;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * Validates a user's credentials by checking the username and password.
     *
     * @param user The user object containing the username and password to validate
     * @return true if the credentials are valid, false otherwise
     * @throws RuntimeException if there's an issue executing the SQL query
     */

    public static boolean validateUser(User user) {
        Connection connection = DBConnector.getConnection();
        String query = "SELECT * FROM user WHERE username = ? and password=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            ResultSet resultSet = preparedStatement.executeQuery();
            boolean userExists = resultSet.next(); // Check if a matching user was found

            resultSet.close();
            connection.close();
            return userExists;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * Deletes a user from the database based on the provided username.
     *
     * @param user The user object containing the username to be deleted
     * @throws RuntimeException if there's an issue executing the SQL query
     */
    public static void deleteUser(User user) {
        Connection connection = DBConnector.getConnection();
        String query = "DELETE FROM user WHERE username = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * Retrieves the role of a user based on the username and password.
     *
     * @param user The user object containing the username and password
     * @return The role of the user
     * @throws RuntimeException if the user is not found or incorrect credentials are provided
     */
    public static String getUserRole(User user) {
        Connection connection = DBConnector.getConnection();
        String query = "SELECT role FROM user WHERE username = ? AND password = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String role = resultSet.getString("role");
                connection.close();
                return role;
            } else {
                connection.close();
                throw new RuntimeException("User not found or incorrect credentials");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * Retrieves a list of all users from the database.
     *
     * @return A list containing all user objects
     * @throws RuntimeException if there's an issue executing the SQL query
     */
    public static List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        Connection connection = DBConnector.getConnection();
        String query = "SELECT * FROM user";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getString("id"));
                user.setUsername(resultSet.getString("username"));
                user.setName(resultSet.getString("name"));
                user.setPassword(resultSet.getString("password"));
                user.setRole(resultSet.getString("role"));
                userList.add(user);
            }

            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return userList;
    }


}
