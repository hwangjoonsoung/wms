package me.hwangjoonsoung.wms.entity;

import jakarta.persistence.*;
import lombok.*;

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
    private String email;

    @Column(length = 64)
    private String password;

    @Column(length = 50)
    private String name;

    @Column(length = 20)
    private String authorization;
    private LocalDateTime date_create = LocalDateTime.now();
    private boolean enable = true;
}
