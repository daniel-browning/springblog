package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MathController {

    @RequestMapping(value = "/add/{firstNumber}/and/{secondNumber}", method = RequestMethod.GET)
    @ResponseBody
    public Integer add(@PathVariable (value = "firstNumber") int firstNumber, @PathVariable (value = "secondNumber") int secondNumber) {
        return (firstNumber + secondNumber);
    }

    @RequestMapping(value = "/subtract/{firstNumber}/from/{secondNumber}", method = RequestMethod.GET)
    @ResponseBody
    public Integer subtract(@PathVariable (value = "firstNumber") int firstNumber, @PathVariable (value = "secondNumber") int secondNumber) {
        return (secondNumber - firstNumber);
    }

    @RequestMapping(value = "/multiply/{firstNumber}/and/{secondNumber}", method = RequestMethod.GET)
    @ResponseBody
    public Integer multiply(@PathVariable (value = "firstNumber") int firstNumber, @PathVariable (value = "secondNumber") int secondNumber) {
        return (firstNumber * secondNumber);
    }

    @RequestMapping(value = "/divide/{firstNumber}/by/{secondNumber}", method = RequestMethod.GET)
    @ResponseBody
    public Integer divide(@PathVariable (value = "firstNumber") int firstNumber, @PathVariable (value = "secondNumber") int secondNumber) {
        return (firstNumber / secondNumber);
    }


}
