package com;

import com.springConfig.ConfigurationClass;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ConfigurationClass.class})
@WebAppConfiguration
@Transactional
public class TestDataSource {


    @Autowired
    DataSource dataSource;

    @Autowired
    SessionFactory sf;

    @Test
    public void test() {
//        user user = new user("person");
//        Session session = sf.openSession();
//        session.beginTransaction();
//        session.save(user);
//        session.getTransaction().commit();
//        user user1 = session.get(user.class,1L);
//        assertNotNull(user1);
//        assertEquals(user.getName(), user1.getName());

    }

}
