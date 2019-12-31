package boot.jpa.pagination.service;

import boot.jpa.pagination.domain.user.User;
import boot.jpa.pagination.domain.user.UserRepository;
import boot.jpa.pagination.dto.UserFindAllDto;
import boot.jpa.pagination.dto.UserFindByIdResponseDto;
import boot.jpa.pagination.dto.UserSignUpDto;
import boot.jpa.pagination.dto.UserUpdateRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;

    @Transactional
    public Long userSignUpRequest(UserSignUpDto dto) {
        return userRepository.save(dto.toEntity()).getId();
    }

    @Transactional
    public UserFindByIdResponseDto userFindByIdResponse(Long id) {
        User user = userRepository.findById(id).orElse(null);
        return new UserFindByIdResponseDto(user);
    }

    @Transactional
    @ReadOnlyProperty
    public Page<UserFindAllDto> userFindAllResponse(Pageable pageable) {
        int page = pageable.getPageNumber() == 0 ? 0 : pageable.getPageNumber() - 1;
        pageable = PageRequest.of(page, 3);
        return userRepository.UserFindAllResponse(pageable);
    }

    @Transactional
    public Long userUpdateRequest(UserUpdateRequestDto dto){
        return userRepository.save(dto.toEntity()).getId();
    }

    @Transactional
    public void userDeleteRequest(Long id) {
        userRepository.deleteById(id);
    }
}
