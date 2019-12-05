package headfirst.designpatterns.filters;

public class BreakFilter implements Filter {
    @Override
    public String doFilter(Request request, Response response, FilterChain chain) {
        request.requestStr += "---BreakFilter()";
        response.responseStr += "---BreakFilter()";
        return "break";
    }
}
