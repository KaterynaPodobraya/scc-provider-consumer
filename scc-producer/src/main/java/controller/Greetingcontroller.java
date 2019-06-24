package controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
public class Greetingcontroller {

    @GetMapping("say/hello/{name}")
    public String sayHelloTo(@PathVariable("name") String name, HttpServletResponse response) {
        response.addHeader("aaaa", "52");
        return "Hello " + name + "!!!";
    }
}
