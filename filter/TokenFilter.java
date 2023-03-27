package com.codingfist.burninghouseuser.globalcommon.globalcommon.filter;




public class TokenFilter extends GenericFilterBean {
//



    private final TokenProvider tokenProvider;

    public TokenFilter(TokenProvider tokenProvider){

        this.tokenProvider =tokenProvider;
    }




    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {



        String token = tokenProvider.resolveToken((HttpServletRequest) request);

        if(token !=null && tokenProvider.validateToken(token)){

            Authentication auth = tokenProvider.getAuthentication(token);

            SecurityContextHolder.getContext().setAuthentication(auth);

        }
        chain.doFilter(request,response);
    }
}
