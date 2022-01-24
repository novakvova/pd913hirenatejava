package program;

import models.Role;
import org.hibernate.Session;
import org.hibernate.query.Query;
import utils.HibernateSessionFactoryUtil;

import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        System.setOut(new PrintStream(System.out, true, "UTF-8"));
        Scanner in = new Scanner(System.in, "UTF-8");
//        Scanner in = new Scanner(System.in);

        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();

        System.out.println("Вкажіть назву ролі:");
        Role role = new Role();
        role.setName(in.nextLine());
        session.save(role);

        Query query = session.createQuery("FROM Role");
        List<Role> roles = query.list();
        System.out.println("Roles list: ");
        for (Object item : roles)
            System.out.println(item);
        session.close();


        session.close();
    }
}
