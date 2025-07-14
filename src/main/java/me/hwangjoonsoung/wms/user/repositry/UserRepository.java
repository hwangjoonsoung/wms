package me.hwangjoonsoung.wms.user.repositry;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import me.hwangjoonsoung.wms.entity.User;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserRepository {

    private final EntityManager entityManager;

    public void signUpUser(User user) {
        entityManager.persist(user);
    }

    public User findUserById(Long id) {
        User user = entityManager.createQuery("select u from User u where id= :id", User.class).setParameter("id", id).getSingleResult();
        return user;
    }

    public void editUserInfo(User user) {
        entityManager.persist(user);
    }

    public void leaveMember(User user) {
        entityManager.persist(user);
    }

    public String convertPassword(String password) {
        Object convertPassword = entityManager.createQuery("select sha2(:password , '256')", Object.class).setParameter("password", password).getSingleResult();
        return convertPassword.toString();
    }

}
