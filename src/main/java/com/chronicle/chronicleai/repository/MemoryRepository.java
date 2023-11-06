package com.chronicle.chronicleai.repository;

import com.chronicle.chronicleai.entity.Memory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemoryRepository extends JpaRepository<Memory, Integer> {

  Optional<Memory> findByMemoryId(int memoryId);

}
