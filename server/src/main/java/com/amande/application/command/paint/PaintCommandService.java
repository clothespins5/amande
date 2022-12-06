package com.amande.application.command.paint;

import com.amande.domain.models.paint.PaintRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class PaintCommandService {

    private final PaintRepository paintRepository;

}
