package com.zm.finaper.controller;

import com.zm.finaper.dto.CalculateDTO;
import com.zm.finaper.service.CalculateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by wzhang on 18/05/2017.
 */
@Controller
@RequestMapping("/calculate")
public class CalculateController {

    @Autowired
    private CalculateService calculateService;

    @RequestMapping(value = "/calculate", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public CalculateDTO calculate(@RequestBody CalculateDTO dto) {
        dto.setBill(calculateService.calculateBill(dto));
        dto.setPayer("Changed Payer");
        return dto;
    }
}
