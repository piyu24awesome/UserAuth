package org.example.userauthenticationservice.DTO;

import lombok.Getter;
import lombok.Setter;
import org.example.userauthenticationservice.model.BaseModel;

@Getter
@Setter
public class UserDTO extends BaseModel {
    private String emailId;
    private String encPassword;

}
