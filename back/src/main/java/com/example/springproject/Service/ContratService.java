package com.example.springproject.Service;

import com.example.springproject.Entity.Contrat;
import com.example.springproject.Entity.Etudiant;
import com.example.springproject.Entity.Specialite;
import com.example.springproject.Repository.ContratRepository;
import com.example.springproject.Repository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
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


        @Override
        public float getChiffreAffaireEntreDeuxDate(Date startDate, Date endDate) {
            List<Contrat> listContrat=myRepository.contratBetween2dates(startDate,endDate);
            System.out.println(listContrat);
            float chiffre=0;
            for( Contrat c:listContrat){
                if(c.getSpecialite().equals(Specialite.IA)){
                    chiffre=chiffre+300;
                }
                else if (c.getSpecialite().equals(Specialite.RESEAU)){
                    chiffre=chiffre+350;
                }
                else if(c.getSpecialite().equals(Specialite.CLOUD)){
                    chiffre=chiffre+400;
                }
                else if (c.getSpecialite().equals(Specialite.SECURITE)){
                    chiffre=chiffre+450;
                }
            }
            return chiffre;
        }

    @Override
    public List<Contrat> contratBetween2dates(Date startDate, Date endDate) {
        return  myRepository.contratBetween2dates(startDate,endDate);
    }
    @Override
    public Integer nbContratsValides(Date endDate, Date startDate) {
        return myRepository.countContratByDateDebutContratAfterAndDateFinContratBefore(endDate,startDate).intValue();
    }

    @Override
    public List<Contrat> contratExp() {

        return myRepository.dateExpi();

    }

    @Override
    public List<Contrat> contratDepasseAn()
    {
        return myRepository.contratDepasseAn();
    }

/*Nous souhaitons créer un service schedulé permettant d’avertir le responsable de la prévue pour les 15 prochains jours afin de contrat de l’étudiant concerné.
Créer un service nous permettant d’afficher 13h en respectant la signature suivante :
String retrieveStatusContrat();
NB: Pour des raisons de test, vous pouvez modifier l’horaire selon l’heure affiché sur
votre machine. Le message sera affiché simplement sur console.
.*/

    @Scheduled(cron = "*/60 * * * * * ")
    public String retrieveStatusContrat()
    {
        List<Contrat> contrats=myRepository.dateExpi();
        String string = "les contrats concernés tous les 15 jours :";
        for (Contrat c : contrats){
            string=string+"contrat id :"+c.getIdContrat()+"\n";
            string=string+"contrat date fin :"+c.getDateFinContrat()+"\n";
            string=string+"contrat debut date "+c.getDateDebutContrat()+"\n";
            string =string+"specialité"+c.getSpecialite()+"\n";

        }
        System.out.println(string);
        return string;
    }
    @Transactional
    public Contrat affectContratToEtudiant (int ce, String nomE,String prenomE){
        myRepository.X(ce,nomE,prenomE);
        return myRepository.findById(ce).get();
    }
}