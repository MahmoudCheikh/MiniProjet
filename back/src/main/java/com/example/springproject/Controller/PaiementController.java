package com.example.springproject.Controller;


import com.example.springproject.Entity.Paiement;
import com.example.springproject.Entity.Universite;
import com.example.springproject.Service.IPaiementService;
import com.example.springproject.Service.PaiementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Paiement")
public class PaiementController {

    @Autowired
    private IPaiementService paiementService;

    @GetMapping("/findall")
    @ResponseBody
    public List<Paiement> getPaiements(){
        List<Paiement> listPai = paiementService.findAll();
        return listPai;
    }

    @PostMapping("/addPaiement")
    @ResponseBody
    public Paiement ajouterPaiement(@RequestBody Paiement p) {
        int Paiement = paiementService.ajouterPaiement(p);
        return p;
    }

    @DeleteMapping("/removePaiement/{Paiement-id}")
    @ResponseBody
    public void removePaiement(@PathVariable("Paiement-id") Paiement p) {

        paiementService.deletePaiement(p);
    }

    @GetMapping("/retrievePaiement/{Paiement-id}")
    @ResponseBody
    public Paiement retrievePaiement(@PathVariable("Paiement-id") Integer p) {
        return paiementService.findById(p);
    }

    @PutMapping("/modifyPaiement")
    @ResponseBody
    public Paiement updatePaiement(@RequestBody Paiement p) {
        Boolean Paiement = paiementService.updatePaiement(p);
        return p;
    }


}
