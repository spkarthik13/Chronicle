package com.chronicle.chronicleai.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "person")
public class Person {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "person_id")
  private int personId;

  @Column(name = "person_first_name")
  private String personFirstName;

  @Column(name = "person_last_name")
  private String personLastName;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "person")
  @OrderBy(value = "memoryId")
  private List<Memory> memories;

  @Column(name = "created_date")
  @LastModifiedDate
  private LocalDateTime createdDate;

  @Column(name = "primary_user")
  private boolean primaryUser;
}
