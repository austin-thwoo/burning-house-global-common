package com.codingfist.burninghouseuser.globalcommon.globalcommon.dto.response;



@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class ApiListResponse<T> {

    private List<T> data;

}
