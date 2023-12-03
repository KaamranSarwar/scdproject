package Test;

import DAO.UserDao;
import Model.User;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {

    /**
     *this function is adding user in the db
     */
    @Test
    void addUser() {
        User testuser=new User("testuser","1234","manager","123","testuser1");
        UserDao.addUser(testuser);
        assertTrue(UserDao.getUser(testuser));
        UserDao.deleteUser(testuser);
    }

    @Test
    void updateUserById() {
        User testuser=new User("testuser","1234","manager","123","testuser1");
        UserDao.addUser(testuser);
        testuser.setName("updatetestuser");
        UserDao.updateUserById(testuser);
        assertTrue(UserDao.getUser(testuser));
        UserDao.deleteUser(testuser);
    }


    @Test
    void getUser() {
        User testuser=new User("testuser","1234","manager","123","testuser1");
        UserDao.addUser(testuser);
        assertTrue(UserDao.getUser(testuser));
        UserDao.deleteUser(testuser);
    }

    @Test
    void validateUser() {
        User testuser=new User("testuser","1234","manager","123","testuser1");
        UserDao.addUser(testuser);
        assertTrue(UserDao.validateUser(testuser));
        UserDao.deleteUser(testuser);
    }

    @Test
    void deleteUser() {
        User testuser=new User("testuser","1234","manager","123","testuser1");
        UserDao.addUser(testuser);
        UserDao.deleteUser(testuser);
        assertFalse(UserDao.getUser(testuser));
    }

    @Test
    void getUserRole() {
        User testuser=new User("testuser","1234","manager","123","testuser1");
        UserDao.addUser(testuser);
        String role=UserDao.getUserRole(testuser);
        assertEquals(role,testuser.getRole());
        UserDao.deleteUser(testuser);
    }

    @Test
    void getAllUsers() {
        User testuser=new User("testuser","1234","manager","123","testuser1");
        UserDao.addUser(testuser);
        List<User> userList=UserDao.getAllUsers();
        for(User u:userList){
            if(u.getId().equals(testuser.getId())){
                assertEquals(u,testuser);
            }
        }
        UserDao.deleteUser(testuser);
    }
}