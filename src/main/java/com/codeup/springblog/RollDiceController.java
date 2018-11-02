package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.Random;

@Controller
public class RollDiceController {

    @GetMapping("/roll-dice")
    public String rollDice() {
        return "roll-dice";
    }

    @GetMapping("/roll-dice/{userGuess}")
    public String userGuess(@PathVariable int userGuess, Model viewModel) {
        Random random = new Random();
        int diceNumber = random.nextInt((6 - 1) + 1) + 1; //((max - min) + 1)) + min
        viewModel.addAttribute("userGuess", userGuess);
        viewModel.addAttribute("diceNumber", diceNumber);

        return "dice-results";
    }

}