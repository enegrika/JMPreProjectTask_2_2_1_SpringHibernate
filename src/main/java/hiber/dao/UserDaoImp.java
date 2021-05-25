package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }


    @Override
    public List<User> listUsers() {
        TypedQuery<User> query =
                sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }

    @Override
    public void getUserByCarModelAndSeries(String model, int series) {

        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery(
                "SELECT user FROM User user JOIN user.carObj carObj WHERE carObj.model = ?1 AND carObj.series = ?2");
        query.setParameter(1, model);
        query.setParameter(2, series);

        List<User> userList = query.getResultList();
        System.out.println("SELECTED USERS :");
        if (userList.size() == 0) {
            System.out.println(" NON-Exist");
        }
        for (User u : userList) {
            System.out.println(u.toString());
        }
    }


}
