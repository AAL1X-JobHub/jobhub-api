package com.al1x.jobhub.dto;

import com.al1x.jobhub.model.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDetailsDTO {
    private String roleName;
    private String email;
    private LocalDate dateCreate;
    private Boolean activeAccount;
}