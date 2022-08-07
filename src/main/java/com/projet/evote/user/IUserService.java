package com.projet.evote.user;

import com.projet.evote.dtos.UserDto;

public interface IUserService {
    User registerNewUserAccount(UserDto userDto);
}
