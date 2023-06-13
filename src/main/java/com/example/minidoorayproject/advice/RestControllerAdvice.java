package com.example.minidoorayproject.advice;

import com.example.minidoorayproject.domain.ExceptionRequest;
import com.example.minidoorayproject.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

@org.springframework.web.bind.annotation.RestControllerAdvice
public class RestControllerAdvice {

    @ExceptionHandler(ValidationFailedException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ExceptionRequest validationFailed(Exception ig, HttpServletRequest req) {
        ExceptionRequest eventErrorRequest = new ExceptionRequest();
        eventErrorRequest.setStatusCode(405);
        eventErrorRequest.setError(ig.getMessage());
        eventErrorRequest.setPath(req.getServletPath());

        return eventErrorRequest;
    }

    @ExceptionHandler(value = {NotFoundMemberException.class, NotFoundProjectException.class,
            NotFoundProjectMemberBundleException.class, NotFoundStatusCodeException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ExceptionRequest notFounds(Exception ig, HttpServletRequest req) {
        ExceptionRequest eventErrorRequest = new ExceptionRequest();
        eventErrorRequest.setStatusCode(404);
        eventErrorRequest.setError(ig.getMessage());
        eventErrorRequest.setPath(req.getServletPath());

        return eventErrorRequest;
    }

}
