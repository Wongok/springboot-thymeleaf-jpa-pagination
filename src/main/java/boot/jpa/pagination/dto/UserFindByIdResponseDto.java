package boot.jpa.pagination.dto;

import boot.jpa.pagination.domain.user.User;
import lombok.Getter;

@Getter
public class UserFindByIdResponseDto {

    private Long id;
    private String userName;
    private String userId;
    private String password;

    public UserFindByIdResponseDto(User entity) {
        id = entity.getId();
        userName = entity.getUserName();
        userId = entity.getUserId();
        password = entity.getPassword();
    }
}
