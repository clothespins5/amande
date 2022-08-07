package com.example.amande.presentation.controller;

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


  @CrossOrigin(origins = "http://localhost:4200")
  @GetMapping("/vallejoTable")
  public VallejoTableGetOutput getVallejoTable(@RequestParam String color, @RequestParam int limit) {

    VallejoTableGetInput input = new VallejoTableGetInput(color, limit);
    return vallejoTableGetUseCase.get(input);
  }
}
