package me.hwangjoonsoung.wms.user.repositry;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import me.hwangjoonsoung.wms.entity.User;
import me.hwangjoonsoung.wms.user.dto.EditUserInfo;
import me.hwangjoonsoung.wms.user.dto.SignUpUser;
import me.hwangjoonsoung.wms.user.service.UserService;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
