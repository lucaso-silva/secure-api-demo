package com.lucas.secure_api_demo.infrastructure.persistence.mapper;

import com.lucas.secure_api_demo.domain.model.User;
import com.lucas.secure_api_demo.infrastructure.persistence.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User toDomain(UserEntity userEntity) {
        return new User(userEntity.getId(),
                userEntity.getName(),
                userEntity.getEmail(),
                userEntity.getPassword(),
                userEntity.getRole());
    }
}
