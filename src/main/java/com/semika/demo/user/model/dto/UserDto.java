package com.semika.demo.user.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String password;
    private Date createdDate;
    private Long organizationId;
    private String roadMark;
    private String requestFor;
    private Integer age;
}
