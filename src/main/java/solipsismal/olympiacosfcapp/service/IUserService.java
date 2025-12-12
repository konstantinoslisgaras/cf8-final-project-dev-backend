package solipsismal.olympiacosfcapp.service;

import solipsismal.olympiacosfcapp.core.exceptions.PlayerNotFoundException;
import solipsismal.olympiacosfcapp.core.exceptions.UserNotFoundException;
import solipsismal.olympiacosfcapp.dto.UserDTO;
import solipsismal.olympiacosfcapp.dto.UserUpdateDTO;
import solipsismal.olympiacosfcapp.filters.Paginated;
import solipsismal.olympiacosfcapp.model.User;

public interface IUserService {
    UserDTO getUserProfile(String username) throws UserNotFoundException;
    UserDTO updateUserProfile(String username, UserUpdateDTO userUpdateDTO) throws UserNotFoundException, PlayerNotFoundException;
    Paginated<UserDTO> getPaginatedUsers(int page, int size);
}
