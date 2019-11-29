package pro.antonshu.hb;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import pro.antonshu.hb.entyties.Product;
import pro.antonshu.hb.entyties.User;
import pro.antonshu.hb.entyties.UserOrder;

import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        PrepareDataApp.forcePrepareData();

        SessionFactory factory = new Configuration()
                .configure("resources/configs/crud/hibernate.cfg.xml")
                .buildSessionFactory();

        Session session = null;

        try {
            session = factory.getCurrentSession();
            session.beginTransaction();
            System.out.println("Users: ");
            List<User> userList= session.createNamedQuery("User.findAll").getResultList();
            for (User user : userList) {
                System.out.println(user.getName());
            }

            User user1 = session.get(User.class, 3L);
            System.out.printf("Products for user %s: ", user1.getName());
            for (Product product : user1.getProductList()) {
                System.out.print(product.getTitle() + " ");
            }
            System.out.println();

            session.delete(session.get(User.class, 2L));
            System.out.println("После удаления юзера c id=2: ");
            List<User> userList2 = session.createNamedQuery("User.findAll").getResultList();
            for (User user : userList2) {
                System.out.println(user.getName());
            }
            System.out.println("Добавляем пользователя");
            session.save(new User(1L, "AAAAAAAAAAA"));
            List<User> userList3 = session.createNamedQuery("User.findAll").getResultList();
            for (User user : userList3) {
                System.out.println(user.toString());
            }

            Product product = session.get(Product.class, 3L);
            System.out.printf("Покупатели продукта %s: ", product.getTitle() );
            for (User user : product.getUsers()) {
                System.out.print(user.getName() + " ");
            }
            System.out.println();

            UserOrder userOrder = (UserOrder) session.createQuery("SELECT o FROM UserOrder o WHERE o.user_id = 3").getSingleResult();
            Product product1 = session.get(Product.class, userOrder.getProduct_id());
            User user = session.get(User.class, userOrder.getUser_id());
            System.out.printf("Стоимость товара %s при покупке пользователем %s - %d", product1.getTitle(), user.getName(), userOrder.getProduct_cost());
            System.out.println();
            session.getTransaction().commit();
        } finally {
            factory.close();
            if (session != null) {
                session.close();
            }
        }
    }
}
