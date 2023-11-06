package com.chronicle.chronicleai.service;

import com.chronicle.chronicleai.contoller.dto.MemoryDto;
import com.chronicle.chronicleai.contoller.dto.PersonDto;
import com.chronicle.chronicleai.entity.Memory;
import com.chronicle.chronicleai.entity.Person;
import com.chronicle.chronicleai.repository.MemoryRepository;
import com.chronicle.chronicleai.repository.PersonRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@RequiredArgsConstructor
public class ChronicleServiceImpl implements ChronicleService {

  @Autowired
  private PersonRepository personRepository;

  @Autowired
  private MemoryRepository memoryRepository;

  @Override
  public PersonDto registerUser(PersonDto personDto) {
    Person person = new Person();
    person.setPersonFirstName(personDto.getFirstName());
    person.setPersonLastName(personDto.getLastName());
    Memory memory = new Memory();
    memory.setPerson(person);
    memory.setMemory("First memory of Chronicle :)");
    memory.setMemoryDate(LocalDateTime.now().minusDays(10));
    memory.setCreatedDate(LocalDateTime.now());
    person.setMemories(List.of(memory));
    personRepository.save(person);
    return personDto;
    }

  @Override
  public MemoryDto saveMemory(MemoryDto memoryDto) {
    Memory memory = new Memory();
    memory.setMemory(memoryDto.getMemory());
    memory.setMemoryDate(memoryDto.getMemoryDate());
    Optional<Person> personOpt = personRepository.findByPersonId(memoryDto.getPersonId());
    personOpt.ifPresent(memory::setPerson);
    memoryRepository.save(memory);
    return memoryDto;
  }

  @Override
  public MemoryDto getMemory(int memoryId) {
    Optional<Memory> memoryOpt = memoryRepository.findByMemoryId(memoryId);
    if(memoryOpt.isPresent()) {
      MemoryDto memoryDto = new MemoryDto();
      memoryDto.setMemory(memoryOpt.get().getMemory());
      memoryDto.setMemoryDate(memoryOpt.get().getMemoryDate());
      Person person = memoryOpt.get().getPerson();
      String memoryBy = person.getPersonFirstName() + " " + person.getPersonLastName();
      memoryDto.setMemoryBy(memoryBy);
      return memoryDto;
    }
    return null;
  }
}
