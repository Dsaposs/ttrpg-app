package com.ttrpg.helper.services.auth.dto;

import com.ttrpg.helper.services.EntityDtoMapper;
import com.ttrpg.helper.services.auth.entites.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDetailsDTO {
    private static final EntityDtoMapper<User,UserDetailsDTO> entityDtoMapper = new EntityDtoMapper<>();
    private String username;
    private String email;
    private String password;
    private List<String> roles;

    public static UserDetailsDTO convertEntityToDto(User entity) {
        return (UserDetailsDTO) entityDtoMapper.convertToDto(entity, UserDetailsDTO.class);
    }

    public static User convertDtoToEntity(UserDetailsDTO dto) {
        return (User) entityDtoMapper.convertToEntity(dto, User.class);
    }
}