package com.service.victoria.controllers;

import com.service.victoria.beans.GameResponse;
import com.service.victoria.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class GameController {

    Logger logger = Logger.getLogger(GameController.class.getName());
    @Autowired
    private GameService gameService;

    @RequestMapping("/healthCheck")
    public ResponseEntity healthCheck() {
        return ResponseEntity.ok("Children Game Endpoint is up and running ! Enjoy the game");
    }

    @RequestMapping("/game")
    public int game(@RequestParam(value="noOfChildren", defaultValue="5") Integer noOfChildren,
                                   @RequestParam(value="counter", defaultValue="6") Integer counter) {
        GameResponse response = gameService.getLastChildPosition(noOfChildren, counter);
        logger.info("winning child id in Game Controller is " + response.getWinningChildId());
        return response.getWinningChildId();
    }
}
