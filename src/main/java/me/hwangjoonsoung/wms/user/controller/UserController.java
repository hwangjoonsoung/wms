package me.hwangjoonsoung.wms.user.controller;

import lombok.RequiredArgsConstructor;
import me.hwangjoonsoung.wms.user.dto.EditUserInfo;
import me.hwangjoonsoung.wms.user.dto.EditUserPassword;
import me.hwangjoonsoung.wms.user.dto.SignUpUser;
import me.hwangjoonsoung.wms.user.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @GetMapping("/signup")
    public String signUpUser() {
        return "/user/regist";
    }

    @PostMapping("/signup")
    public String signUpUser(SignUpUser signUpUser) {
        userService.signUpUser(signUpUser);
        return "/";
    }

    @GetMapping("/edit")
    public String editUserInfo() {
        return "/user/edit";
    }

    @PostMapping("/edit")
    public String editUserInfo(Long id ,EditUserInfo editUserInfo) {
        userService.editUserInfo(id, editUserInfo);
        return "/";
    }

    @GetMapping("/leaveMember")
    public String leaveMember() {
        return "/";
    }

    @PostMapping
    public String leaveMember(Long id) {
        userService.leaveMember(id);
        return "/";
    }

}
