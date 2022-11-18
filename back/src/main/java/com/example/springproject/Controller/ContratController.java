package com.example.springproject.Controller;

import com.example.springproject.Entity.Contrat;
import com.example.springproject.Service.IContratService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Contrat")
public class ContratController {
    @Autowired
    private IContratService ContratService;


    @GetMapping("/findall")
    @ResponseBody
    public List<Contrat> getContrats() {
        List<Contrat> listContrat = ContratService.findAll();
        return listContrat;
    }

    @PostMapping("/addContrat")
    @ResponseBody
    public Contrat ajouterContrat(@RequestBody Contrat c) {
        int contrat = ContratService.ajouterContrat(c);
        return c;
    }

    @DeleteMapping("/removeContrat/{contrat-id}")
    @ResponseBody
    public void removeContrat(@PathVariable("contrat-id") Contrat c) {

        ContratService.deleteContrat(c);
    }

    @GetMapping("/retrieveContrat/{contrat-id}")
    @ResponseBody
    public Contrat retrieveContart(@PathVariable("contrat-id") Integer c) {
        return ContratService.findById(c);
    }

    @PutMapping("/modifyContrat")
    @ResponseBody
    public Contrat updateContrat(@RequestBody Contrat c) {
        Boolean contrat = ContratService.updateContrat(c);
        return c;
    }
}
