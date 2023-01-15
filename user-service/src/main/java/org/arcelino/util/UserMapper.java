package org.arcelino.util;

import org.arcelino.dto.UserForm;
import org.arcelino.dto.UserResponse;
import org.arcelino.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface UserMapper {

    User toUser(UserForm userForm);

    UserResponse toUserResponse(User user);

}
