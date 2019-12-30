package boot.jpa.pagination.dto;

import boot.jpa.pagination.domain.user.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserSignUpDto {
    private String userName;
    private String userId;
    private String password;

    public User toEntity() {
        return User.builder()
                .userName(userName)
                .userId(userId)
                .password(password)
                .build();
    }
}
