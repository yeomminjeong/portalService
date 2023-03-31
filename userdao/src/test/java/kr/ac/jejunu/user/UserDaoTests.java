package kr.ac.jejunu.user;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.core.Is.is;


public class UserDaoTests {
    private static UserDao userDao;
    @BeforeAll
    public static void setup(){
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(DaoFactory.class);
        userDao = applicationContext.getBean("userDao", UserDao.class);
    }
    @Test
    public void get() throws SQLException, ClassNotFoundException {
        Long id = 1l;
        String name = "zeta";
        String password = "1234";
//        ConnectionMaker connectionMaker = new JejuConnectionMaker();
//        UserDao userDao = new UserDao(connectionMaker);
//        DaoFactory daoFactory = new DaoFactory();
//        UserDao userDao = daoFactory.getUserDao();
        User user = userDao.findById(id);
        assertThat(user.getId(), is(id));
        assertThat(user.getName(), is(name));
        assertThat(user.getPassword(), is(password));
    }

    @Test
    public void insert() throws SQLException, ClassNotFoundException {
        User user = new User();
        String name = "염민정";
        String password = "1111";
        user.setName(name);
        user.setPassword(password);
//        ConnectionMaker connectionMaker = new JejuConnectionMaker();
//        UserDao userDao = new UserDao(connectionMaker);
//        DaoFactory daoFactory = new DaoFactory();
//        UserDao userDao = daoFactory.getUserDao();
        userDao.insert(user);
        assertThat(user.getId(), greaterThan(1L));
        User insertedUser = userDao.findById(user.getId());
        assertThat(insertedUser.getId(), is(user.getId()));
        assertThat(insertedUser.getName(),is(name));
        assertThat(insertedUser.getPassword(), is(password));
    }

//    @Test
//    public void getForHalla() throws SQLException, ClassNotFoundException {
//        Long id = 1l;
//        String name = "zeta";
//        String password = "1234";
//
//        ConnectionMaker connectionMaker = new HallaConnetctionMaker();
//        UserDao userDao = new UserDao(connectionMaker);
//        User user = userDao.findById(id);
//        assertThat(user.getId(), is(id));
//        assertThat(user.getName(), is(name));
//        assertThat(user.getPassword(), is(password));
//    }
//
//    @Test
//    public void insertForHalla() throws SQLException, ClassNotFoundException {
//        User user = new User();
//        String name = "염민정";
//        String password = "1111";
//        user.setName(name);
//        user.setPassword(password);
//        ConnectionMaker connectionMaker = new HallaConnetctionMaker();
//        UserDao userDao = new UserDao(connectionMaker);
//        userDao.insert(user);
//
//        assertThat(user.getId(), greaterThan(1L));
//
//        User insertedUser = userDao.findById(user.getId());
//        assertThat(insertedUser.getId(), is(user.getId()));
//        assertThat(insertedUser.getName(),is(name));
//        assertThat(insertedUser.getPassword(), is(password));
//    }
}
