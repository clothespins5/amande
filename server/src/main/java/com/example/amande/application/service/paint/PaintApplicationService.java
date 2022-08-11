package com.example.amande.application.service.paint;

import com.example.amande.domain.models.paint.PaintRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class PaintApplicationService {

    private final PaintRepository paintRepository;

}
