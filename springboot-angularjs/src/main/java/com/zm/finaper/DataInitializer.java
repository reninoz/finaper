package com.zm.finaper;

import com.zm.finaper.entity.*;
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

        Property dooringHouse = new Property();
        dooringHouse.setTitle("Dooring House");
        dooringHouse.setAddress("64 Dooring Street, Dickson, ACT, 2602");
        dooringHouse.setRoom(false);
        dooringHouse.setNumOfRooms(5);
        session.persist(dooringHouse);

        Property cowper1House = new Property();
        cowper1House.setTitle("Cowper1 House");
        cowper1House.setAddress("1/7 Cowper St, Ainslie, ACT, 2602");
        cowper1House.setRoom(false);
        cowper1House.setNumOfRooms(5);
        cowper1House.setNumOfBath(1);
        session.persist(cowper1House);

        Property cowper2House = new Property();
        cowper2House.setTitle("Cowper2 House");
        cowper2House.setAddress("2/7 Cowper St, Ainslie, ACT, 2602");
        cowper2House.setRoom(false);
        cowper2House.setNumOfRooms(5);
        cowper2House.setNumOfBath(2);
        session.persist(cowper2House);

        initLookups(session);

        for (int i=1; i<6; i++) {
            Property p = new Property();
            p.setTitle("Room" + i +" at Dooring St");
            p.setType("House");
            p.setAddress("64 Dooring Street, Dickson, ACT, 2602");
            p.setRoom(true);
            p.setNumOfBath(1);
            p.setHostProperty(dooringHouse);
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

            session.persist(p);

        }

        for (int i=1; i<6; i++) {
            Property p = new Property();
            p.setTitle("Room" + i +" at Unit 2 Cowper St");
            p.setType("House");
            p.setAddress("2/7 Cowper St, Ainslie, ACT, 2602");
            p.setNumOfBath(2);
            p.setRoom(true);
            p.setHostProperty(cowper2House);
            session.persist(p);

            Person tenant = new Person();
            tenant.setLastName("Cowper2");
            tenant.setFirstName("Room" + i);
            session.persist(tenant);

            Lease lease = new Lease();
            lease.setTitle("Cowper2 Room" + i);
            lease.setTenant(tenant);
            Date today = new Date();
            lease.setStartDate(DateUtil.addDays(today, -120));
            lease.setEndDate(DateUtil.addDays(today, 60));
            lease.setProperty(p);
            lease.setMonthlyRent(500);
            lease.setLeaseType("Share");
            session.persist(lease);

        }

        transaction.commit();
    }

    private void initLookups(Session session) {
        LookupType payType = new LookupType();
        payType.setCode("payment_type");
        payType.setDescription("Payment Type");
        session.persist(payType);

        Lookup cashPayLookup= new Lookup();
        cashPayLookup.setCode("cash");
        cashPayLookup.setDescription("Cash");
        cashPayLookup.setLookupType(payType);
        session.persist(cashPayLookup);

        Lookup bankTransferLookup= new Lookup();
        bankTransferLookup.setCode("bank_transfer");
        bankTransferLookup.setDescription("Bank Transfer");
        bankTransferLookup.setLookupType(payType);
        session.persist(bankTransferLookup);
    }

}
