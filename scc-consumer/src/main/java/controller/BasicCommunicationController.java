package controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletResponse;


@RestController
public class BasicCommunicationController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/reply")
    public String checkOddAndEven(@RequestParam("name") String name, HttpServletResponse response) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Type", "application/json");

        ResponseEntity<String> responseEntity = restTemplate.exchange(
          "http://localhost:8090/say/hello/" + name,
          HttpMethod.GET,
          new HttpEntity<>(httpHeaders),
          String.class);
        System.out.println(responseEntity.getHeaders());

            response.addHeader("Test-Header", "Test value");
        return responseEntity.getBody() + " It is a reply.";
        }
}