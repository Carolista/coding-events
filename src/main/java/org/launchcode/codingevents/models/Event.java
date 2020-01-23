package org.launchcode.codingevents.models;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Objects;

@Entity
public class Event {

    @Id // identifies primary key
    @GeneratedValue // let database generate primary key
    private int id;

    @NotBlank(message = "Name is required.")
    @Size(min = 3, max = 30, message = "Name must be between 3 and 30 characters long.")
    private String name;

    @Size(max = 500, message = "Description cannot exceed 500 characters.")
    private String description;

    @Size(min = 1, message = "Number of attendees must be greater than zero.")
    private String capacity;

    @NotBlank(message = "Location is required.")
    @NotNull
    private String location;

    @AssertTrue(message = "This box must be checked. Just because. Just do it!")
    private boolean regRequired;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid e-mail. Try again.")
    private String contactEmail;

    private EventType type;

    public Event() { // need no-arg constructor in persistent class
    }

    public Event(String name, String description, String capacity, String location, boolean regRequired, String contactEmail, EventType type) {
        this.name = name;
        this.description = description;
        this.capacity = capacity;
        this.location = location;
        this.regRequired = regRequired;
        this.contactEmail = contactEmail;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isRegRequired() {
        return regRequired;
    }

    public void setRegRequired(boolean regRequired) {
        this.regRequired = regRequired;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return id == event.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
