package com.amande.infrastructure.repository.paint;

import com.amande.domain.models.paint.Paint;
import com.amande.domain.models.paint.PaintID;
import com.amande.domain.models.paint.PaintRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@AllArgsConstructor
@Repository
public class PaintRepositoryImpl implements PaintRepository {

  public Optional<Paint> findBy(PaintID id) {
    throw new AssertionError();
  }

  @Override
  public void save(Paint paint) {
    throw new AssertionError();
  }

  @Override
  public void delete(Paint paint) {
    throw new AssertionError();
  }
}
