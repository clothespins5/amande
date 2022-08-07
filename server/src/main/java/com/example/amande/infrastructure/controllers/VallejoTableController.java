package com.example.amande.infrastructure.controllers;

import com.example.amande.infrastructure.presenters.IVallejoTablePresenter;
import com.example.amande.usecase.IVallejoTableGetUseCase;
import com.example.amande.usecase.VallejoTableGetInput;
import com.example.amande.usecase.VallejoTableGetOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VallejoTableController {

  @Autowired
  private IVallejoTableGetUseCase vallejoTableGetUseCase;

  @Autowired
  private IVallejoTablePresenter vallejoTablePresenter;

  @CrossOrigin(origins = "http://localhost:4200")
  @GetMapping("/vallejoTable")
  public String getVallejoTable(@RequestParam String color, @RequestParam int limit) {

    VallejoTableGetInput input = new VallejoTableGetInput(color, limit);
    VallejoTableGetOutput output = vallejoTableGetUseCase.get(input);

    return vallejoTablePresenter.toJson(output);
  }
}
