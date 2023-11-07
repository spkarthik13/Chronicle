package com.chronicle.chronicleai.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "memory_attributes")
public class MemoryAttributes {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int attributeId;

  @ManyToOne
  private Memory memory;

  private String category;

  private String summary;

  private String memoryLocation;

  private String highlights;

  private String timeSpent;

  @OneToMany(cascade = CascadeType.ALL)
  @OrderBy(value = "personId")
  private List<Person> relatedPersons;
}
