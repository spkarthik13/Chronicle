package com.chronicle.chronicleai.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "memory")
@Getter
@Setter
@NoArgsConstructor
public class Memory {
  @Id()
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "memory_id")
  private int memoryId;

  @ManyToOne
  private Person person;

  private String memory;

  @Column(name = "memory_date")
  private LocalDateTime memoryDate;

  @LastModifiedDate
  @Column(name = "created_date")
  private LocalDateTime createdDate;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "memory")
  private List<MemoryAttributes> attributes;
}
