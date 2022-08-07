package com.projet.evote.user;

import com.projet.evote.dtos.UserDto;
import com.projet.evote.repository.PrivilegeRepository;
import com.projet.evote.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

@Service
@Transactional
public class UserService implements IUserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired

    private RoleRepository roleRepository;

    @Override
    public User registerNewUserAccount(UserDto userDto) throws UserAlreadyExistException {
        if (emailExists(userDto.getEmail())) {
            throw new UserAlreadyExistException("Un compte est déjà associé à l' adresse"
                    + userDto.getEmail());
        }

        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setPassword(userDto.getPassword());
        user.setEmail(userDto.getEmail());
        user.setRoles(Arrays.asList(roleRepository.findByName(userDto.getStr_role())));

        return userRepository.save(user);
    }
    private boolean emailExists(String email) {
        return userRepository.findByEmail(email) != null;
    }
}
