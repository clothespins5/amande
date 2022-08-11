package com.example.amande.infrastructure.pg_repository.paint;

import com.example.amande.domain.models.paint.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@AllArgsConstructor
@Repository
public class PaintPostgresRepository implements PaintRepository {

  public Optional<Paint> findByID(PaintID id) {
    throw new AssertionError();
  }
}
