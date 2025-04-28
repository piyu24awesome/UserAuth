package org.example.userauthenticationservice.mapper;

import org.example.userauthenticationservice.DTO.UserDTO;
import org.example.userauthenticationservice.model.User;
import org.springframework.stereotype.Component;

@Component
public class MapperUtil {

    public User mapperFromUserDToToUser(UserDTO userDTO) {
        User user = new User();
        user.setUserId(userDTO.getId());
        user.setEmailId(userDTO.getEmailId());
        user.setEncPassword(userDTO.getEncPassword());
        return user;
    }


    public UserDTO mapperFromUserToUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getUserId());
        userDTO.setEmailId(user.getEmailId());
        userDTO.setEncPassword(user.getEncPassword());
        return userDTO;

    }
}
