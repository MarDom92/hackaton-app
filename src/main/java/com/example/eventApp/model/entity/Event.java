package com.example.eventApp.model.entity;

import com.example.eventApp.model.enums.EventStatus;
import com.example.eventApp.model.enums.EventType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "event")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User author;

    @Column(length = 256)
    private String description;
//    todo: check for null (can't be empty) (annotation @NotBlank in request)

    @Column
    private LocalDateTime created;

    @Column
    private LocalDateTime updated;

    @Column
    private LocalDateTime dateOfEventStart;

    @Column
    private LocalDateTime dateOfEventStop;

    @Column
    private String location;

    @Column
    private String name;

    @Column
    @Enumerated(EnumType.STRING)
    private EventStatus eventStatus;

    @Column
    @Enumerated(EnumType.STRING)
    private EventType eventType;

    @Column
    @ManyToMany
    @JoinTable(name = "event_registrants",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> registrants;

    @Column
    @OneToMany(targetEntity = Comment.class, mappedBy = "event", fetch = FetchType.LAZY)
    private List<Comment> comments;
}