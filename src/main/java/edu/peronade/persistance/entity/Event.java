package edu.peronade.persistance.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Created by peronade on 22.12.16.
 */

@Entity
public class Event {

    private static final double URGENT_IMPORTANT_VALUE = 8.0;
    private static final double NOT_URGENT_IMPORTANT_VALUE = 6.0;
    private static final double URGENT_NOT_IMPORTANT_VALUE = 3.0;
    private static final double NOT_URGENT_NOT_IMPORTANT_VALUE = 1.0;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String eventName;
    private String description;
    private LocalDate dateOfEventCreation;
    private LocalDate deadlineDateOfEvent;
    @Enumerated(EnumType.STRING)
    private Importance importance;
    private Double score;

    public Event(Long id, String eventName, String description,  LocalDate deadlineDateOfEvent, Importance importance) {
        this.id = id;
        this.eventName = eventName;
        this.description = description;
        this.dateOfEventCreation = dateOfEventCreation;
        this.deadlineDateOfEvent = deadlineDateOfEvent;
        this.dateOfEventCreation = LocalDate.now();
        this.importance = importance;
        this.score = countScore();
    }


    public Event() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDateOfEventCreation() {
        return dateOfEventCreation;
    }

    public void setDateOfEventCreation(LocalDate dateOfEventCreation) {
        this.dateOfEventCreation = dateOfEventCreation;
    }

    public LocalDate getDeadlineDateOfEvent() {
        return deadlineDateOfEvent;
    }

    public void setDeadlineDateOfEvent(LocalDate deadlineDateOfEvent) {
        this.deadlineDateOfEvent = deadlineDateOfEvent;
    }

    public Importance getImportance() {
        return importance;
    }

    public void setImportance(Importance importance) {
        this.importance = importance;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", eventName='" + eventName + '\'' +
                ", description='" + description + '\'' +
                ", dateOfEventCreation=" + dateOfEventCreation +
                ", deadlineDateOfEvent=" + deadlineDateOfEvent +
                ", importance=" + importance +
                ", score=" + score +
                '}';
    }



    private Double countScore() throws ArithmeticException {
        long timeToHaveEventFinished = (ChronoUnit.DAYS.between(dateOfEventCreation, deadlineDateOfEvent));
        switch (this.importance)
        {
            case URGENT_IMPORTANT:
                return (URGENT_IMPORTANT_VALUE / timeToHaveEventFinished);
            case NOT_URGENT_IMPORTANT:
                return (NOT_URGENT_IMPORTANT_VALUE / timeToHaveEventFinished);
            case URGENT_NOT_IMPORTANT:
                return (URGENT_NOT_IMPORTANT_VALUE / timeToHaveEventFinished);
            case NOT_URGENT_NOT_IMPORTANT:
                return (NOT_URGENT_NOT_IMPORTANT_VALUE / timeToHaveEventFinished);
            default:
                return 0.0;
        }
    }




}
