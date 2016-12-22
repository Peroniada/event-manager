package edu.peronade.repositories;

import edu.peronade.persistance.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by peronade on 22.12.16.
 */
public interface EventRepository extends JpaRepository<Event, Long> {
    public List<Event> findAllByOrderByScoreDesc();
}
