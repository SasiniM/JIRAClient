package jiratest.jira;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping(value = "gg")
    public String token() throws Exception{
        Token token = new Token();
        token.generateToken();
        return "RRRRRRR";
    }
}
