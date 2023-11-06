package com.chronicle.chronicleai.repository;

import com.chronicle.chronicleai.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
  Optional<Person> findByPersonId(int personId);
}
