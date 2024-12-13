package fr.unica.miage.tille.dice.service;

import fr.unica.miage.tille.dice.entity.DiceRollLog;
import fr.unica.miage.tille.dice.entity.DiceRollLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class DiceService {

    @Autowired
    private Dice dice;

    @Autowired
    private DiceRollLogRepository diceRollLogRepository;

    public List<Integer> rollDices(int diceCount) {
        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < diceCount; i++) {
            results.add(dice.roll());
        }
        saveDiceRollLog(diceCount, results);
        return results;
    }

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