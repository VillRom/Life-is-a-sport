package ru.romanchev.life_is_a_sport.event;

import jakarta.persistence.*;
import lombok.*;
import ru.romanchev.life_is_a_sport.category.Category;
import ru.romanchev.life_is_a_sport.user.User;

@Data
@Entity
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private final String description;
    @ManyToOne
    private final Category category;
    @ManyToOne
    private final User userCreated;
    private final Boolean paidEvent;
    private final Integer participantLimit;
    @Enumerated
    private final EnumState state;

    public Event(String description, Category category, User userCreated, Boolean paidEvent, Integer participantLimit,
                 EnumState state) {
        this.description = description;
        this.category = category;
        this.userCreated = userCreated;
        this.paidEvent = paidEvent;
        this.participantLimit = participantLimit;
        this.state = state;
    }
}
