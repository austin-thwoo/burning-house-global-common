package com.codingfist.burninghouseuser.globalcommon.globalcommon.dto.response;



@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class ApiResponse<T> {

    private T data;

}
