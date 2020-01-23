package org.launchcode.codingevents.controllers;

import org.launchcode.codingevents.data.EventData;
import org.launchcode.codingevents.data.EventRepository;
import org.launchcode.codingevents.models.Event;
import org.launchcode.codingevents.models.EventType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("events")
public class EventController {

    @Autowired // specifies SpringBoot should auto-populate fields
    private EventRepository eventRepository; // created directly from interface

    // can use findAll, save, findById (part of CrudRepository interface)

    @GetMapping
    public String displayAllEvents(Model model) {
        model.addAttribute("title", "All Events");
        model.addAttribute("events", eventRepository.findAll());
        return "events/index";
    }

    @GetMapping("create") // located at /events/create
    public String displayCreateEventForm(Model model) {
        model.addAttribute("title","Create Event");
        model.addAttribute("event", new Event());
        model.addAttribute("types", EventType.values()); // enums
        return "events/create"; // do not put file extension
    }

    @PostMapping("create") // located at /events/create
    public String processCreateEventForm(@ModelAttribute @Valid Event newEvent, Errors errors, Model model) { // model binding - encapsulation of all attributes
        if(errors.hasErrors()) {
            model.addAttribute("title","Create Event");
//            model.addAttribute("errorMsg","Bad data!");
            return "events/create"; // do not put file extension
        }
        eventRepository.save(newEvent); // add to data layer (ArrayList)
        return "redirect:";
    }

    @GetMapping("delete")
    public String displayDeleteEventForm(Model model) {
        model.addAttribute("title", "Delete Event");
        model.addAttribute("events", eventRepository.findAll());
        return "events/delete";
    }

    @PostMapping("delete")
    public String processDeleteEventsForm(@RequestParam(required = false) int[] eventIds) {
        if (eventIds != null) {
            for (int id : eventIds) {
                eventRepository.deleteById(id);
            }
        }
        return "redirect:";
    }

    @GetMapping("edit/{eventId}")
    public String displayEditForm(Model model, @PathVariable int eventId) {
        Event eventToEdit = EventData.getById(eventId);
        model.addAttribute("title", "Edit Event: " + eventToEdit.getName() + " (ID: " + eventId + ")");
        model.addAttribute(eventToEdit);
        return "events/edit";
    }

    @PostMapping("edit")
    public String processEditForm(int eventId, String name, String description) {
        Event eventToEdit = EventData.getById(eventId);
        eventToEdit.setName(name);
        eventToEdit.setDescription(description);
        return "redirect:";
    }

}
