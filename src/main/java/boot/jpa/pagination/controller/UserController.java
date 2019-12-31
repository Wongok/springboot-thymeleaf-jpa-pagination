package boot.jpa.pagination.controller;

import boot.jpa.pagination.dto.UserFindAllDto;
import boot.jpa.pagination.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @GetMapping({"/signup", "/"})
    public String join() {
        return "signup";
    }

    @GetMapping("/list")
    public String list(Model model, @PageableDefault Pageable pageable) {
        Page<UserFindAllDto> page = userService.userFindAllResponse(pageable);
        model.addAttribute("page", page);
        int start = Math.max(1, page.getNumber() - 2);
        int end = Math.min(start + 4, page.getTotalPages());

        model.addAttribute("start", start);
        model.addAttribute("end", end);

        return "list";
    }
}
