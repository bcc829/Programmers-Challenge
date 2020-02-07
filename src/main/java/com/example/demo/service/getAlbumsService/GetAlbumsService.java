package com.example.demo.service.getAlbumsService;

import com.example.demo.domain.dto.PaginatedAlbumsDto;
import org.springframework.data.domain.Pageable;

public interface GetAlbumsService {
    PaginatedAlbumsDto getAlbumsWithPaging(Pageable pageable, String locale, String url);
}
