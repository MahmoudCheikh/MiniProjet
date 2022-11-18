package com.example.springproject.Controller;

import com.example.springproject.Entity.Etudiant;
import com.example.springproject.Service.IEtudiantService;
import com.example.springproject.Service.IEtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Etudiant")
public class EtudiantController {
    @Autowired
    private IEtudiantService EtudiantService;

    @GetMapping("/findall")
    @ResponseBody
    public List<Etudiant> getEtudiants() {
        List<Etudiant> listetudiant = EtudiantService.findAll();
        return listetudiant;
    }

    @PostMapping("/addEtudiant")
    @ResponseBody
    public Etudiant ajouterEtudiant(@RequestBody Etudiant c) {
        int Etudiant = EtudiantService.ajouterEtudiant(c);
        return c;
    }

    @DeleteMapping("/removeEtudiant/{Etudiant-id}")
    @ResponseBody
    public void removeEtudiant(@PathVariable("Etudiant-id") Etudiant c) {

        EtudiantService.deleteEtudiant(c);
    }

    @GetMapping("/retrieveEtudiant/{Etudiant-id}")
    @ResponseBody
    public Etudiant retrieveContart(@PathVariable("Etudiant-id") Integer c) {
        return EtudiantService.findById(c);
    }

    @PutMapping("/modifyEtudiant")
    @ResponseBody
    public Etudiant updateEtudiant(@RequestBody Etudiant c) {
        Boolean Etudiant = EtudiantService.updateEtudiant(c);
        return c;
    }
}
