//package com.ujwal;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
//import org.hibernate.cfg.Configuration;
//
//
//
//
//public class Main {
//    public static void main(String[] args) {
//        Student s1 = new Student();
//        s1.setRollNo(121);
//        s1.setSname("sakura");
//        s1.setsAge(20);
//        Configuration cfg = new Configuration();
//        cfg.addAnnotatedClass(com.ujwal.Student.class);
//        cfg.configure();
//        SessionFactory sf = cfg.buildSessionFactory();
//        Session session = sf.openSession();
////        Transaction tx = session.beginTransaction();
//        session.save(s1);
//
//        System.out.println(s1);
//    }
//}


package com.ujwal;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.setSid(634);
        s1.setSname("Sasuke");
        s1.setsAge(23);

        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml"); // Ensure this file is in resources
        cfg.addAnnotatedClass(Student.class);

        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();

        Transaction tx = session.beginTransaction(); // ✅ Start transaction
        session.persist(s1);                         // ✅ Use persist() instead of save()
        tx.commit();                                 // ✅ Commit
        session.close();                             // ✅ Close session

        System.out.println("Student saved: " + s1);
    }
}
