package project_team_melody_is_error.la.leojaitherleuakRlai.model;

import jakarta.persistence.Column;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class AccountModel {


    private Long id;
    private String email;
    private String firstname;
    private String lastname;
    private LocalDate birthday;
    private LocalDateTime datetime;
    private String accessToken;
    private String refreshToken;
    private LocalDateTime expiresAt;
}

