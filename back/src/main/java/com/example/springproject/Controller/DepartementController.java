package com.example.springproject.Controller;

import com.example.springproject.Service.IDepartementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class DepartementController {
    @Autowired
    private IDepartementService DepartementService;

}
