package com.raise.pigs.service.controller;

import com.raise.pigs.service.config.globalException.ServiceException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *
 * </p>
 *
 * @author osumg
 * @since 2020/8/21
 */
@RestController
@RequestMapping("/test")
public class TestController {
    @GetMapping("/s")
    public String getS(){
        return "test-s";
    }
}
