package com.example.amande.usecase;

import java.util.List;

import com.example.amande.domain.models.PaintNear;
import com.example.amande.domain.models.VallejoTable;
import com.example.amande.infrastructure.repositories.IVallejoTableRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VallejoTableGetUseCase implements IVallejoTableGetUseCase {
    
    @Autowired
    private IVallejoTableRepository vallejoTableRepository;

    public VallejoTableGetOutput get(VallejoTableGetInput input) {

        VallejoTable vallejoTable = vallejoTableRepository.findAll();
        List<PaintNear> nearPaints = vallejoTable.nearPaints(input.color);
        nearPaints = nearPaints.subList(0, input.limit);

        return VallejoTableGetOutput.create(vallejoTable.paints, nearPaints);
        
    }
}
