package com.ttrpg.helper.services.auth.dto;

import com.ttrpg.helper.services.EntityDtoMapper;
import com.ttrpg.helper.services.auth.entites.User;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@Getter
@Setter
public class UserDTO {
    private static final EntityDtoMapper<User,UserDTO> entityDtoMapper = new EntityDtoMapper<>();
    private Integer id;
    private String username;
    private String email;

    public static UserDTO convertEntityToDto(User entity) {
        return (UserDTO) entityDtoMapper.convertToDto(entity, UserDTO.class);
    }

    public static User convertDtoToEntity(UserDTO dto) {
        return (User) entityDtoMapper.convertToEntity(dto, User.class);
    }
}