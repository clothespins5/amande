package com.example.amande.infrastructure.repositories;

import com.example.amande.domain.models.Paints;

public interface IVallejoTableRepository {
    
    Paints findAll();
    
}
