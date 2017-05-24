package com.zm.finaper;

import com.zm.finaper.entity.Lease;
import com.zm.finaper.entity.Person;
import com.zm.finaper.entity.Property;
import com.zm.finaper.utils.DateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManagerFactory;
import java.util.Date;

/**
 * Created by wzhang on 24/05/2017.
 */
@Component
public class DataInitializer {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    public void init() throws Exception {

        SessionFactory sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        for (int i=1; i<6; i++) {
            Property p = new Property();
            p.setTitle("Room" + i +" at Dooring St");
            p.setType("House");
            p.setAddress("64 Dooring Street, Dickson, ACT, 2602");
            p.setNumOfBath(1);
            p.setNumOfRooms(5);
            session.persist(p);

            Person tenant = new Person();
            tenant.setLastName("Dooring");
            tenant.setFirstName("Room" + i);
            session.persist(tenant);

            Lease lease = new Lease();
            lease.setTitle("Dooring " + i);
            lease.setTenant(tenant);
            Date today = new Date();
            lease.setStartDate(DateUtil.addDays(today, -120));
            lease.setEndDate(DateUtil.addDays(today, 60));
            lease.setProperty(p);
            lease.setMonthlyRent(500);
            lease.setLeaseType("Share");
            session.persist(lease);

        }

        for (int i=1; i<6; i++) {
            Property p = new Property();
            p.setTitle("Room" + i +" at Unit 1 Cowper St");
            p.setType("House");
            p.setAddress("1/7 Cowper St, Ainslie, ACT, 2602");
            p.setNumOfBath(1);
            p.setNumOfRooms(5);
            session.persist(p);

        }

        for (int i=1; i<6; i++) {
            Property p = new Property();
            p.setTitle("Room" + i +" at Unit 2 Cowper St");
            p.setType("House");
            p.setAddress("2/7 Cowper St, Ainslie, ACT, 2602");
            p.setNumOfBath(2);
            p.setNumOfRooms(5);
            session.persist(p);

        }

        transaction.commit();
    }

}
