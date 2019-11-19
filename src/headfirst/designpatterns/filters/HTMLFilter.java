package headfirst.designpatterns.filters;


/**
 * 将字符串中出现的"<>"符号替换成"[]"
 */
public class HTMLFilter implements Filter {
    @Override
    public String doFilter(Request request, Response response, FilterChain chain) {
        //将字符串中出现的"<>"符号替换成"[]"
        request.requestStr = request.requestStr
                .replace('<', '[').replace('>', ']') +
                //后面添加的是便于我们观察代码执行步骤的字符串
                "----HTMLFilter()";
        String ret = chain.doFilter(request, response, chain);
        response.responseStr += "---HTMLFilter()";
        return ret;
    }
}
