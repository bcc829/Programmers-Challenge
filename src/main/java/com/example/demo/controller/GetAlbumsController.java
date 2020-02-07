package com.example.demo.controller;

import com.example.demo.domain.dto.PaginatedAlbumsDto;
import com.example.demo.service.getAlbumsService.GetAlbumsServiceImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


@RestController
public class GetAlbumsController {

    private GetAlbumsServiceImpl getAlbumsService;

    public GetAlbumsController(GetAlbumsServiceImpl getAlbumsService) {
        this.getAlbumsService = getAlbumsService;
    }

    @GetMapping(value = "/albums")
    public PaginatedAlbumsDto getAlbumsWithPaging(@RequestParam int page,
                                                  @RequestParam String locale,
                                                  @RequestParam(required = false, defaultValue = "10") int size,
                                                  HttpServletRequest request) {

        Pageable pageable = PageRequest.of(page, size);

        return getAlbumsService.getAlbumsWithPaging(pageable, locale, request.getRequestURL().toString());
    }

}
