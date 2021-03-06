package com.bsu.pt.exam.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

//Решение - порядок студентов
@Entity
@Table(name = "result")
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Result implements Serializable {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(insertable = false, updatable = false)
    private String id;
    // @NotEmpty
    @OneToMany(
            cascade = CascadeType.ALL,
            mappedBy = "result"
    )
    private List<Student> students = new ArrayList<>();
    @OneToOne(cascade = CascadeType.ALL,  fetch = FetchType.EAGER)
    private Event event;

    @Override
    public String toString() {
        return "Result{" +
                "id='" + id + '\'' +

                ", event=" + event.getEventName() +
                '}';
    }
}
