package com.chronicle.chronicleai.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity
@Table(name = "person_mood")
public class Mood {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int moodId;

  @OneToOne()
  private Person person;

  @LastModifiedDate
  private LocalDateTime currentDate;

  private String mood;
}
