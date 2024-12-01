package com.semika.demo.user.model.converter;

import com.semika.demo.user.model.dto.UserDto;
import com.semika.demo.user.model.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserConverter {

    public User dtoToDomain(UserDto to) {
        return User.builder()
            .firstName(to.getFirstName())
            .lastName(to.getLastName())
                .password(to.getPassword()).age(to.getAge())

            .build();
    }

    public UserDto domainToDto(User from) {
        UserDto userResource = UserDto.builder()
            .id(from.getId())
            .firstName(from.getFirstName())
            .lastName(from.getLastName())
                .password(from.getPassword())
                .age(from.getAge())
            .build();
        userResource.setOrganizationId(from.getOrganizationId());
        return userResource;
    }
}
