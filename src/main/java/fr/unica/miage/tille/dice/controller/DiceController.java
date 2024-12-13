package fr.unica.miage.tille.dice.controller;

import fr.unica.miage.tille.dice.entity.DiceRollLog;
import fr.unica.miage.tille.dice.entity.DiceRollLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import fr.unica.miage.tille.dice.service.Dice;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
public class DiceController {

    @Autowired
    private Dice dice;

    @Autowired
    private DiceRollLogRepository diceRollLogRepository;

    @GetMapping("/rollDice")
    public int rollDice() {
        int result = dice.roll();
        saveDiceRollLog(1, List.of(result));
        return result;
    }

    @GetMapping("/rollDices/{X}")
    public List<Integer> rollDices(@PathVariable int X) {
        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < X; i++) {
            results.add(dice.roll());
        }
        saveDiceRollLog(X, results);
        return results;
    }

    private void saveDiceRollLog(int diceCount, List<Integer> results) {
        DiceRollLog log = new DiceRollLog();
        log.setDiceCount(diceCount);
        log.setResults(results);
        log.setTimestamp(LocalDateTime.now());
        diceRollLogRepository.save(log);
    }
}
