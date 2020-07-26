package design.pattern.chain_of_responsibility.middleware;

/**
 * 检查用户角色
 */
public class RoleCheckMiddleware extends Middleware {

    @Override
    public boolean check(String email, String password) {
        if (email.equals("admin@example.com")) {
            System.out.println("Hello, admin!");
            return true;
        }
        System.out.println("Hello, user!");
        boolean ret = checkNext(email, password);
        System.out.println("RoleCheckMiddleware post");
        return ret;
    }
}
