package com.example.demo.service.getAlbumsService;

import com.example.demo.domain.dto.AlbumDto;
import com.example.demo.domain.dto.PageInfoDto;
import com.example.demo.domain.dto.PaginatedAlbumsDto;
import com.example.demo.domain.entity.Album;
import com.example.demo.repository.album.AlbumRepository;
import com.example.demo.service.searchAlbumAndSongService.SearchAlbumAndSongServiceImpl;
import com.example.demo.util.ModelMapperUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.stream.Collectors;

@Service
public class GetAlbumsServiceImpl implements GetAlbumsService{

    private AlbumRepository albumRepository;

    private ModelMapperUtil modelMapperUtil;

    private Logger logger = LoggerFactory.getLogger(SearchAlbumAndSongServiceImpl.class);

    public GetAlbumsServiceImpl(AlbumRepository albumRepository,
                                ModelMapperUtil modelMapperUtil) {
        this.albumRepository = albumRepository;
        this.modelMapperUtil = modelMapperUtil;
    }

    @Transactional
    public PaginatedAlbumsDto getAlbumsWithPaging(Pageable pageable, String locale, String url) {

        Page<Album> pagingAlbumLocalesIn =
                albumRepository.getPagingAlbumLocalesIn(pageable, locale);

        int pageSize = pageable.getPageSize();
        int current = pageable.getPageNumber();
        int last = pagingAlbumLocalesIn.getTotalPages() - 1;
        int first = 0;

        String firstPage = pagingAlbumLocalesIn.isFirst() ? null : makePageLink(url, first, pageSize, locale);
        String lastPage = pagingAlbumLocalesIn.isLast() ? null : makePageLink(url, last, pageSize, locale);
        String nextPage = current == last ? null : makePageLink(url,current + 1, pageSize, locale);
        String prevPage = current == first ? null : makePageLink(url,current - 1, pageSize, locale);


        PaginatedAlbumsDto paginatedAlbumsDto = PaginatedAlbumsDto.builder()
                .albums(pagingAlbumLocalesIn.get().map(it -> modelMapperUtil.convertToDomain(it, AlbumDto.class))
                        .collect(Collectors.toList()))
                .pages(
                        PageInfoDto.builder()
                                .next(nextPage)
                                .prev(prevPage)
                                .first(firstPage)
                                .last(lastPage)
                                .build()
                )
                .build();

        logger.info("getAlbumsWithPaging result - {}", paginatedAlbumsDto.toString());

        return paginatedAlbumsDto;

    }

    private String makePageLink(String url, int pageNumber, int size, String locale) {
        return url + "?page=" + pageNumber + "&size=" + size + "&locale=" + locale;
    }

}
