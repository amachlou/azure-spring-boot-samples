package amachlou.spring_azure_security_keyvault_secrets.sec;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecretsController {
    @GetMapping
    public String hello() {
        return "Hello from the other side!";
    }

}
