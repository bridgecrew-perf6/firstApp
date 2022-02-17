package ru.anyforany.mypredictor.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/orders")
public class CalendarController {

    @RequestMapping
    public String showCalendar() {
        return "orders";
    }
}
