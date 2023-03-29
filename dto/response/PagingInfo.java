package com.codingfist.burninghouseuser.globalcommon.globalcommon.dto.response;


@NoArgsConstructor
@Getter
@AllArgsConstructor
public class PagingInfo<T> {

    private int currentPage;
    private int totalPage;
    private Long totalCount;


    public PagingInfo(Page<T> list){


        this.currentPage = list.getPageable().getPageNumber();

        this.totalCount = list.getTotalElements();

        this.totalPage = list.getTotalPages();


    }

}
