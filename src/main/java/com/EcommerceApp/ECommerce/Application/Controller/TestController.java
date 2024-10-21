package com.EcommerceApp.ECommerce.Application.Controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/test/app")
    public String testController() {
        return "Test Successful";
    }

    @GetMapping("/signal")
    public String giveSignal() {
        return "Green. It is a go";
    }
}
