package com.example.demo.services;

import javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalControllerExceptionHandler {


    @ExceptionHandler(Exception.class)
    public ModelAndView handleConflict(HttpServletRequest req, Exception e) {

        ModelAndView mav = new ModelAndView();
        mav.addObject("exceptionMessage", e.getMessage());
        mav.addObject("url", req.getRequestURL());
        mav.setViewName("/error/defaultError");
        return mav;
    }



}
