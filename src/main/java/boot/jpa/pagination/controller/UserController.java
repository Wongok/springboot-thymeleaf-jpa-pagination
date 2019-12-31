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
        Page<UserFindAllDto> pages = userService.userFindAllResponse(pageable);
        model.addAttribute("pages", pages);
        int start = Math.max(1, pages.getNumber() - 2);
        int last = Math.min(start + 6, pages.getTotalPages());

        model.addAttribute("start", start);
        model.addAttribute("last", last);

        return "list";
    }
}
