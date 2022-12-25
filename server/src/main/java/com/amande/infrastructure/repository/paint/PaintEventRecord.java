package com.amande.infrastructure.repository.paint;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(fluent = true)
@AllArgsConstructor
@NoArgsConstructor
public class PaintEventRecord {
  String aggregateID;
  Integer version;
  String eventType;
  String jsonData;
}
