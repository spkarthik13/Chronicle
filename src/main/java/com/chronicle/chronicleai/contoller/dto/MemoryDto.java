package com.chronicle.chronicleai.contoller.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MemoryDto {

  private Integer personId;
  private String memory;
  private LocalDateTime memoryDate;
  private String memoryBy;

}
