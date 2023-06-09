package org.example;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "timetable")
@NamedQueries({
        @NamedQuery(name = "Timetable.findBySubject",
                query = "select t from Timetable t where t.subject=?1"),
        @NamedQuery(name = "Timetable.findByLocation",
                query = "select t from Timetable t where t.location=?1"),
        @NamedQuery(name = "Timetable.findByDay",
                query = "select t from Timetable t where t.day=?1"),
        @NamedQuery(name = "Timetable.findAll",
                query = "select t from Timetable t order by t.subject")
})
public class Timetable implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "id")
    private Integer id;
    @Column(name = "username", nullable = false)
    private String username;
    @Column(name = "starts_at", nullable = false)
    private LocalDateTime day;
    @Column(name = "subject", unique = true, nullable = false)
    private String subject;

    @Column(name = "location")
    private String location;

    @Column(name = "details", columnDefinition = "TEXT")
    private String details;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "updated_by")
    private String updatedBy;

    public Timetable() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LocalDateTime getDay() {
        return day;
    }

    public void setDay(LocalDateTime day) {
        this.day = day;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }
}

