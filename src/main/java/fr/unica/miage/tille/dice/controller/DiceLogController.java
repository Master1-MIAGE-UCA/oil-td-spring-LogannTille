package fr.unica.miage.tille.dice.controller;

import fr.unica.miage.tille.dice.entity.DiceRollLog;
import fr.unica.miage.tille.dice.entity.DiceRollLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

/**
 * Controller pour les logs de lancer de dés
 */
@RestController
public class DiceLogController {

    /**
     * Repository pour les logs de lancer de dés
     */
    @Autowired
    private DiceRollLogRepository diceRollLogRepository;

    /**
     * Récupère tous les logs de lancer de dés
     * @return Liste des logs de lancer de dés
     */
    @GetMapping("/diceLogs")
    public List<DiceRollLog> getDiceLogs() {
        return diceRollLogRepository.findAll();
    }
}
