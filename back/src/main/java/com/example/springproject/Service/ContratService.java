package com.example.springproject.Service;

import com.example.springproject.Entity.Contrat;
import com.example.springproject.Entity.Etudiant;
import com.example.springproject.Repository.ContratRepository;
import com.example.springproject.Repository.EtudiantRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;

@Service
@Slf4j
public class ContratService implements IContratService {
    @Autowired
    private ContratRepository myRepository;
    private EtudiantRepository etudiantRepository;

    @Override
    public int ajouterContrat(Contrat C) {
        myRepository.save(C);
        return 1;
    }

    @Override
    public Boolean deleteContrat(Contrat C) {
        myRepository.delete(C);
        return true;
    }


    @Override
    public Boolean updateContrat(Contrat C) {
        myRepository.save(C);
        return  myRepository.findById((Integer) C.getIdContrat()).equals(C);
    }

    @Override
    public List<Contrat> findAll() {
        return (List<Contrat>) myRepository.findAll();
    }

    @Override
    public Contrat findById(Integer C) {
        return myRepository.findById(C).get();
    }

    public Contrat affectContratToEtudiant(Contrat ce, String nomE, String prenomE) {
        Etudiant e=etudiantRepository.findOneByNomEAndPrenomE(nomE,prenomE);

        e.getContratList().add(ce);
        ce.setEtudiant(e);
        myRepository.save(ce);
        etudiantRepository.save(e);
        return ce;
    }

    public void setArchive(Contrat c){
        Contrat contrat = myRepository.findById(c.getIdContrat()).get();
        contrat.setArchive(true);
        myRepository.save(contrat);
    }

    @Scheduled(cron = "*/10 * * * * * ")
    public void retrieveStatusContrat()
    {
        List<Contrat> contratsPresqueExp=myRepository.datePresqueExp();
        List<Contrat> contratsExp=myRepository.dateExpi();

        for (Contrat c : contratsExp) {
            setArchive(c);
        }

        StringBuilder string = new StringBuilder("contrats expirants dans les 15 jours suivants :");
        for (Contrat c : contratsPresqueExp){
            string.append("contrat id : ").append(c.getIdContrat()).append("\n");
            string.append("contrat debut date : ").append(c.getDateDebutContrat()).append("\n");
            string.append("contrat date fin : ").append(c.getDateFinContrat()).append("\n");
            string.append("specialité : ").append(c.getSpecialite()).append("\n");
        }
        log.info(string.toString());
    }


}