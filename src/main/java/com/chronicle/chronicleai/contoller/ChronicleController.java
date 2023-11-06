package com.chronicle.chronicleai.contoller;

import com.chronicle.chronicleai.contoller.dto.MemoryDto;
import com.chronicle.chronicleai.contoller.dto.PersonDto;
import com.chronicle.chronicleai.service.ChronicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class ChronicleController {

  @Autowired
  private ChronicleService chronicleService;

  @RequestMapping("/hello")
  public String sayHi() {
    return "Yo waszzup";
  }

  @PostMapping("/api/chronicle/register-user")
  public PersonDto register(@RequestBody PersonDto personDto) {
    return chronicleService.registerUser(personDto);
  }

  @PostMapping("/api/chronicle/save-memory")
  public MemoryDto saveMemory(@RequestBody MemoryDto memoryDto) {
    return chronicleService.saveMemory(memoryDto);
  }

  @PostMapping("/api/chronicle/get-memory")
  public MemoryDto getMemory(@RequestParam int memoryId) {
    return chronicleService.getMemory(memoryId);
  }

}
