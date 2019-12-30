package boot.jpa.pagination.controller;

import boot.jpa.pagination.dto.UserFindByIdResponseDto;
import boot.jpa.pagination.dto.UserSignUpDto;
import boot.jpa.pagination.dto.UserUpdateRequestDto;
import boot.jpa.pagination.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class UserRestController {

    private UserService userService;

    @PostMapping("/signup")
    public Long UserSignUpRequest(@RequestBody UserSignUpDto dto) {
        return userService.userSignUpRequest(dto);
    }

    @PostMapping("/find")
    public UserFindByIdResponseDto UserFindByIdResponse(@RequestBody Long id) {
        return userService.userFindByIdResponse(id);
    }

    @DeleteMapping("/delete")
    public Long UserDeleteByIdRequest(@RequestBody Long id) {
        userService.userDeleteRequest(id);
        return id;
    }

    @PutMapping("/update")
    public Long UserUpdateRequest(@RequestBody UserUpdateRequestDto dto) {
        return userService.userUpdateRequest(dto);
    }
}
