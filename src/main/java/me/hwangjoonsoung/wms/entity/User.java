package me.hwangjoonsoung.wms.entity;

import jakarta.persistence.*;
import lombok.*;
import me.hwangjoonsoung.wms.enums.Authorizations;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@Getter
@Setter
@Builder
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false , unique = true)
    private String email;

    @Column(length = 64 , nullable = false)
    private String password;

    @Column(length = 50 , nullable = false)
    private String name;

    @Column(length = 20 , nullable = false)
    private String authorization = Authorizations.USER.toString();
    private LocalDateTime datetime_create = LocalDateTime.now();
    private boolean enable = true;
}
