package web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/main")
public class HomeController {
    @GetMapping("/test")
    public ResponseEntity<List<String>> home() {
        List<String> lst = Arrays.asList("abcd");
        return new ResponseEntity<List<String>>(lst, HttpStatus.OK);
    }
}
