package com.codingfist.burninghouseuser.globalcommon.globalcommon.dto.response;




@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ApiPagingResponseWithDifferentResponse<T,P> {




    private T model;

    private PagingResponse<P> response;



}
