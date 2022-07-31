package com.example.amande.usecase;

import java.util.List;

import com.example.amande.domain.models.PaintNear;
import com.example.amande.domain.models.Paints;
import com.example.amande.infrastructure.repositories.IVallejoTableRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VallejoTableGetUseCase implements IVallejoTableGetUseCase {
    
    @Autowired
    private IVallejoTableRepository vallejoTableRepository;

    public VallejoTableGetOutput get(VallejoTableGetInput input) {

        Paints vallejoTable = vallejoTableRepository.findAll();
        List<PaintNear> nearPaints = vallejoTable.nearPaints(input.color);
        nearPaints = nearPaints.subList(0, input.limit);

        return VallejoTableGetOutput.create(vallejoTable.getPaints(), nearPaints);
        
    }
}
