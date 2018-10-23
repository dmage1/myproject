package com.example.myapplication.hello;

import com.example.myapplication.domain.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfoController {

    @Autowired
    Info info;

    @RequestMapping("/appinfo")
    String info() {
        return info.toString();
    }
}
