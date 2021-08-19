package ua.com.dbncalc.steel.dto;

import lombok.Data;

@Data
public class UserEditDTO {
    private Long id;
    private String username;
    private String email;
    private boolean active;
    private boolean admin;
}
