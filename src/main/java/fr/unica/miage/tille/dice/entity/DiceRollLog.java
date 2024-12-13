package fr.unica.miage.tille.dice.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data

/**
 * Cette classe représente un log de lancer de dés.
 */
public class DiceRollLog {

    /**
     * L'identifiant du log.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int diceCount;
    @ElementCollection
    private List<Integer> results;
    private LocalDateTime timestamp;
}