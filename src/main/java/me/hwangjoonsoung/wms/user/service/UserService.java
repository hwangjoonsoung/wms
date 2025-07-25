package me.hwangjoonsoung.wms.user.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import me.hwangjoonsoung.wms.entity.User;
import me.hwangjoonsoung.wms.user.dto.EditUserInfo;
import me.hwangjoonsoung.wms.user.dto.SignUpUser;
import me.hwangjoonsoung.wms.user.repositry.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {

    private final UserRepository userRepository;

    public void signUpUser(SignUpUser signUpUser) {
        User user = User.builder().email(signUpUser.getEmail()).name(signUpUser.getName()).password(convertPassword(signUpUser.getPassword())).build();
        userRepository.signUpUser(user);
    }

    public void editUserInfo(Long id , EditUserInfo editUserInfo) {
        User user = userRepository.findUserById(id);
        userRepository.editUserInfo(user);
    }

    public void leaveMember(Long id) {
        User user = userRepository.findUserById(id);
        user.setEnable(false);
        userRepository.leaveMember(user);
    }

    private String convertPassword(String password){
        return userRepository.convertPassword(password);
    }

}
