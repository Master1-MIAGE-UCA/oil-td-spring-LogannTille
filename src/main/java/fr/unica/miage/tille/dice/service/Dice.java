package fr.unica.miage.tille.dice.service;

import org.springframework.stereotype.Component;
import java.util.Random;


/**
 * Une classe qui simule un dé à 6 faces.
 */
@Component
public class Dice {
    private final Random random;

    public Dice() {
        this.random = new Random();
    }

    public int roll() {
        return random.nextInt(6) + 1; // Simulates a roll of a 6-sided die
    }
}
