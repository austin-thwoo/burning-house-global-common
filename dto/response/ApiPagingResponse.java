package com.codingfist.burninghouseuser.globalcommon.globalcommon.dto.response;



@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class ApiPagingResponse<T> {

    private PagingResponse<T> data;

}
