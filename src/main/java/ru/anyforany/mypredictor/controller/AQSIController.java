package ru.anyforany.mypredictor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.anyforany.mypredictor.entity.RecieptDto;
import ru.anyforany.mypredictor.service.ReciepService;

import java.util.List;

@RestController
@RequestMapping("/aqsi/sales")
public class AQSIController {

    @Autowired
    private ReciepService reciepService;

    @RequestMapping
    public List<RecieptDto> giveMeSales() {
        return reciepService.getAqsiSales();
    }
}
