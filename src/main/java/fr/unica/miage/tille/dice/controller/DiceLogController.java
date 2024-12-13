package fr.unica.miage.tille.dice.controller;

import fr.unica.miage.tille.dice.entity.DiceRollLog;
import fr.unica.miage.tille.dice.entity.DiceRollLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
public class DiceLogController {

    @Autowired
    private DiceRollLogRepository diceRollLogRepository;

    @GetMapping("/diceLogs")
    public List<DiceRollLog> getDiceLogs() {
        return diceRollLogRepository.findAll();
    }
}
