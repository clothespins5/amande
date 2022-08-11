package com.example.amande.infrastructure.pg_repository;

import com.example.amande.domain.models.paint.*;
import com.example.amande.infrastructure.PostgreSql;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@AllArgsConstructor
@Repository
public class PaintPostgresRepository implements PaintRepository {

  PostgreSql postgreSql;

  public Optional<Paint> findByID(PaintID id) {
    throw new AssertionError();
  }
}
