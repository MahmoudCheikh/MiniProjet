package com.example.springproject.Controller;

import com.example.springproject.Service.IEquipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class EquipeController {
    @Autowired
    private IEquipeService myService;
}
