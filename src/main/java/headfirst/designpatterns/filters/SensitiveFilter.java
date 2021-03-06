package headfirst.designpatterns.filters;

public class SensitiveFilter implements Filter {
    @Override
    public String doFilter(Request request, Response response, FilterChain chain) {
        //处理字符串中的敏感信息，将被就业和谐成就业
        request.requestStr = request.requestStr
                .replace("被就业", "就业").replace("敏感", "") +
                //后面添加的是便于我们观察代码执行步骤的字符串
                " ---sensitiveFilter()";
        String ret = chain.doFilter(request, response, chain);
        response.responseStr += "---sensitiveFilter()";
        return ret;
    }
}
