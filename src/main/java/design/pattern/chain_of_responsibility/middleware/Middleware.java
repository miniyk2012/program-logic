package design.pattern.chain_of_responsibility.middleware;

/**
 * 基础验证接口
 */
public abstract class Middleware {
    private Middleware next;

    public Middleware linkWith(Middleware next) {
        this.next = next;
        // return是为了方便链式调用
        return next;
    }

    /**
     * 抽象方法, 由子类实现
     * @param email
     * @param password
     * @return
     */
    public abstract boolean check(String email, String password);

    /**
     * Runs check on the next object in chain or ends traversing if we're in
     * last object in chain.
     */
    protected boolean checkNext(String email, String password) {
        if (next == null) {
            return true;
        }
        return next.check(email, password);
    }
}
