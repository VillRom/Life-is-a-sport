package ru.romanchev.life_is_a_sport.event;

import jakarta.persistence.*;
import lombok.*;
import ru.romanchev.life_is_a_sport.category.Category;
import ru.romanchev.life_is_a_sport.user.User;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PUBLIC, force = true)
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String description;
    @ManyToOne
    private Category category;
    @ManyToOne
    private User userCreated;
    private Boolean paidEvent;
    private Integer participantLimit;
    @Enumerated
    private EnumState state;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public User getUserCreated() {
        return userCreated;
    }

    public void setUserCreated(User userCreated) {
        this.userCreated = userCreated;
    }

    public Boolean getPaidEvent() {
        return paidEvent;
    }

    public void setPaidEvent(Boolean paidEvent) {
        this.paidEvent = paidEvent;
    }

    public Integer getParticipantLimit() {
        return participantLimit;
    }

    public void setParticipantLimit(Integer participantLimit) {
        this.participantLimit = participantLimit;
    }

    public EnumState getState() {
        return state;
    }

    public void setState(EnumState state) {
        this.state = state;
    }
}
