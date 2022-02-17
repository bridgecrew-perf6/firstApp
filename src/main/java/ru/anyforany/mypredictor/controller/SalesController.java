package ru.anyforany.mypredictor.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.anyforany.mypredictor.service.AqsiClient;
import ru.anyforany.mypredictor.service.ReciepService;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class SalesController {

    @Autowired
    ReciepService reciepService;

    @Autowired
    AqsiClient aqsiClient;

    @GetMapping("/presales")
    public String preSalesMapping() {
        return "presales";
    }

    @PostMapping("/sales")
    public String salesMapping(@RequestParam("beginDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date begin,
                               @RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date end ) {

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
        String beginDate = df.format(begin);
        String endDate = df.format(end);

        long sinceTime = begin.getTime();
        long tillTime = end.getTime();

        aqsiClient.setBeginDate(beginDate);
        aqsiClient.setEndDate(endDate);

        reciepService.setBeginDate(sinceTime);
        reciepService.setEndDate(tillTime);

        return "sales";
    }

}
