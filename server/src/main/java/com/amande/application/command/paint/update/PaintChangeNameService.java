package com.amande.application.command.paint.update;

import com.amande.domain.models.paint.PaintID;
import com.amande.domain.models.paint.PaintName;
import com.amande.domain.models.paint.PaintRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class PaintChangeNameService {

  PaintRepository repository;

  @Transactional
  public void changeName(Input input) {
    repository.findBy(new PaintID(input.id))
      .orElseThrow()
      .changeNameAndSave(new PaintName(input.paintName), repository);
  }

  public record Input(
    String id,
    String paintName
  ) {}
}
