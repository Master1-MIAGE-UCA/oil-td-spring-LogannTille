package fr.unica.miage.tille.dice.controller;

import fr.unica.miage.tille.dice.service.DiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DiceController {

    @Autowired
    private DiceService diceService;

    @GetMapping("/rollDices/{X}")
    public List<Integer> rollDices(@PathVariable int X) {
        return diceService.rollDices(X);
    }
}