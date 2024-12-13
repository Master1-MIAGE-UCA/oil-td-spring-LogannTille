package fr.unica.miage.tille.dice.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class DiceRollLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int diceCount;
    @ElementCollection
    private List<Integer> results;
    private LocalDateTime timestamp;
}