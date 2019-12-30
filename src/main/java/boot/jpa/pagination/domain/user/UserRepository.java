package boot.jpa.pagination.domain.user;

import boot.jpa.pagination.dto.UserFindAllDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u " +
            "from User u " +
            "order by u.id desc")
    Page<UserFindAllDto> UserFindAllResponse(Pageable pageable);
}

