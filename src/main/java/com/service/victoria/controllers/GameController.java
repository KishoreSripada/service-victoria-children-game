package com.service.victoria.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameController {

    @RequestMapping("/game")
    public int game(@RequestParam(value="noOfChildren", defaultValue="5") Integer noOfChildren,
                                   @RequestParam(value="counter", defaultValue="6") String counter) {
        System.out.println("noOfChildren is " + noOfChildren);
        System.out.println("counter is " + counter);
        Integer winnerChild = 2;
        return winnerChild;
    }
}
