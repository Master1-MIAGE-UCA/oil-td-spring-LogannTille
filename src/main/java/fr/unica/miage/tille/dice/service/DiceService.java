package fr.unica.miage.tille.dice.service;

import fr.unica.miage.tille.dice.entity.DiceRollLog;
import fr.unica.miage.tille.dice.entity.DiceRollLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


/**
 * Un service qui permet de lancer un dé.
 */
@Service
public class DiceService {

    /**
     * Un dé à 6 faces.
     */
    @Autowired
    private Dice dice;

    /**
     * Un repository pour les logs de lancers de dés.
     */
    @Autowired
    private DiceRollLogRepository diceRollLogRepository;

    /**
     * Lance un dé un nombre de fois donné.
     * @param diceCount
     * @return
     */
    public List<Integer> rollDices(int diceCount) {
        List<Integer> results = new ArrayList<>();
        /**
         * boucle pour lancer le dé un nombre de fois donné
         */
        for (int i = 0; i < diceCount; i++) {
            results.add(dice.roll());
        }
        saveDiceRollLog(diceCount, results);
        return results;
    }

    /**
     * Sauvegarde le log d'un lancer de dés.
     * @param diceCount
     * @param results
     */
    private void saveDiceRollLog(int diceCount, List<Integer> results) {
        DiceRollLog log = new DiceRollLog();
        log.setDiceCount(diceCount);
        log.setResults(results);
        log.setTimestamp(LocalDateTime.now());

        // Utilisation des getters
        Long id = log.getId();
        int count = log.getDiceCount();
        List<Integer> res = log.getResults();
        LocalDateTime time = log.getTimestamp();

        // Modification des valeurs pour utiliser les setters
        log.setId(id);
        log.setDiceCount(count);
        log.setResults(res);
        log.setTimestamp(time);

        diceRollLogRepository.save(log);
    }
}