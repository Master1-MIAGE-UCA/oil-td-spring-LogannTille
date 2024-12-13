package fr.unica.miage.tille.dice.entity;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repertoire de donnees pour les logs de lancer de des.
 */
public interface DiceRollLogRepository extends JpaRepository<DiceRollLog, Long> {
}