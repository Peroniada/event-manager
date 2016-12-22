package edu.peronade;

import edu.peronade.persistance.entity.Event;
import edu.peronade.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Created by peronade on 22.12.16.
 */


@Controller
public class EventController {

    @GetMapping("/events")
    public String EventForm(Model model)
    {
        model.addAttribute("event", new Event());

        model.addAttribute("events", eventRepository.findAllByOrderByScoreDesc());
        return "eventview";
    }

    @PostMapping("/events")
    public String EventSubmit(@ModelAttribute Event event, Model model)
    {
        eventRepository.save(event);
        model.addAttribute("events", eventRepository.findAllByOrderByScoreDesc());
        return "eventview";
    }

    @Autowired
    public EventController(EventRepository eventRepository )
    {
        this.eventRepository = eventRepository;
    }
    private EventRepository eventRepository;
}
