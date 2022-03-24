package projektvers2.triskelion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
public class Website {
    @Autowired
    BookRepository bookRepository;

    // Mapping to usersite
    @GetMapping("usersite")
    public String getUsersite() {
        bookRepository.save(new Book());
        bookRepository.findById(123L);
        return "usersite";
    }

    // Mapping to login
    @RequestMapping("/login.html")
    public String login() {
        return "login.html";
    }

    // Mapping to wrong login error
    @RequestMapping("/login-error.html")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login.html";
    }

   
}
