package com.example.amande.domain.models.paint;

import java.util.Optional;

public interface PaintRepository {
    
    Optional<Paint> findByID(PaintID id);
    
}
