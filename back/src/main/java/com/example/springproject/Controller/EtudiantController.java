package com.example.springproject.Controller;

import com.example.springproject.Service.IEtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class EtudiantController {
    @Autowired
    private IEtudiantService myService;
}
