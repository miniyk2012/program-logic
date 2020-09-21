package headfirst.designpatterns.filters;

public class Main {
    public static void main(String[] args) {
        String msg = ":):,<script>,敏感,被就业,网络授课";

        Request request = new Request();
        request.setRequest(msg);

        Response response = new Response();
        response.setResponse("response");

        FilterChain filterChain = new FilterChain();
        filterChain.addFilter(new HTMLFilter())
                .addFilter(new SensitiveFilter()) //前面返回this,在此提供了方便
                .addFilter(new BreakFilter())
                .addFilter(new FaceFilter());

        String ret = filterChain.doFilter(request, response, filterChain);

        System.out.println(request.getRequest());
        System.out.println(response.getResponse());
        System.out.println("ret=" + ret);

    }
}
