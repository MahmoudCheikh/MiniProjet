package com.example.springproject.Controller;

import com.example.springproject.Entity.Universite;
import com.example.springproject.Entity.Universite;
import com.example.springproject.Service.IUniversiteService;
import com.example.springproject.Service.IUniversiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Universite")
public class UniversiteController {
    @Autowired
    private IUniversiteService universiteService;

    @GetMapping("/findall")
    @ResponseBody
    public List<Universite> getUniversites() {
        List<Universite> listUniv = universiteService.findAll();
        return listUniv;
    }

    @PostMapping("/addUniversite")
    @ResponseBody
    public Universite ajouterUniversite(@RequestBody Universite c) {
        int Universite = universiteService.ajouterUniversite(c);
        return c;
    }

    @DeleteMapping("/removeUniversite/{Universite-id}")
    @ResponseBody
    public void removeUniversite(@PathVariable("Universite-id") Universite c) {

        universiteService.deleteUniversite(c);
    }

    @GetMapping("/retrieveUniversite/{Universite-id}")
    @ResponseBody
    public Universite retrieveContart(@PathVariable("Universite-id") Integer c) {
        return universiteService.findById(c);
    }

    @PutMapping("/modifyUniversite")
    @ResponseBody
    public Universite updateUniversite(@RequestBody Universite c) {
        Boolean Universite = universiteService.updateUniversite(c);
        return c;
    }
}
