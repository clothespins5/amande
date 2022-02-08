package com.example.amande.infrastructure.presenters;

import com.example.amande.usecase.VallejoTableGetOutput;

public interface IVallejoTablePresenter {

    String toJson(VallejoTableGetOutput output);
    
}
