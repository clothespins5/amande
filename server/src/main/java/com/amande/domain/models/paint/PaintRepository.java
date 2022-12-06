package com.amande.domain.models.paint;

import java.util.Optional;

public interface PaintRepository {
    
    Optional<Paint> findBy(PaintID id);

    void save(Paint paint);

    void delete(Paint paint);
    
}
