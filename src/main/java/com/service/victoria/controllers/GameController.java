package com.service.victoria.controllers;

import com.service.victoria.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
public class GameController {

    @Autowired
    private GameService gameService;

    Logger logger = Logger.getLogger(GameController.class.getName());
    @RequestMapping("/game")
    public int game(@RequestParam(value="noOfChildren", defaultValue="5") Integer noOfChildren,
                                   @RequestParam(value="counter", defaultValue="6") Integer counter) {
        logger.info("noOfChildren is " + noOfChildren);
        logger.info("counter is " + counter);
        Integer winnerChild = gameService.playGame(noOfChildren, counter);
        return winnerChild;
    }
}
