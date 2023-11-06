package com.chronicle.chronicleai.service;

import com.chronicle.chronicleai.contoller.dto.MemoryDto;
import com.chronicle.chronicleai.contoller.dto.PersonDto;

public interface ChronicleService {
  PersonDto registerUser(PersonDto personDto);

  MemoryDto saveMemory(MemoryDto memoryDto);

  MemoryDto getMemory(int memoryId);
}
