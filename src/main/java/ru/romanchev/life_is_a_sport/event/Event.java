package ru.romanchev.life_is_a_sport.event;

import jakarta.persistence.*;
import lombok.*;
import ru.romanchev.life_is_a_sport.category.Category;
import ru.romanchev.life_is_a_sport.user.User;

import java.time.LocalDateTime;

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

    @Column(name = "start_event")
    private LocalDateTime start;

    @Column(name = "end_event")
    private LocalDateTime end;
}
