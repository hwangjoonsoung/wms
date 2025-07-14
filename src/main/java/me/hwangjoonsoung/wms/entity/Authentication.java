package me.hwangjoonsoung.wms.entity;

import jakarta.persistence.*;
import jdk.jfr.ContentType;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.query.sql.internal.ParameterRecognizerImpl;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Authentication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String authentication_code;
    private boolean is_success ;
    private LocalDateTime datetime_expired;
    private LocalDateTime dateTime_request = LocalDateTime.now();
    private LocalDateTime dateTime_success;
}
