package solipsismal.olympiacosfcapp.service;

import solipsismal.olympiacosfcapp.dto.UserDTO;
import solipsismal.olympiacosfcapp.dto.UserUpdateDTO;
import solipsismal.olympiacosfcapp.model.User;

public interface IUserService {
    UserDTO getUserProfile(String username);
    UserDTO updateUserProfile(String username, UserUpdateDTO userUpdateDTO);
    UserDTO getUserById(Long id);
}
