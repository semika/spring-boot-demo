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
public class UserAddressDto {
    private Long id;
    private String street;
    private String city;
    private String state;
    private String zipCode;
    private Long userId;
    private Date createdDate;
    private Long organizationId;
    private String roadMark;
    private String requestFor;
}
