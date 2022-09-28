package web.reggie.utils;

public class BaseContext {
    private static ThreadLocal<Long> longThreadLocal = new ThreadLocal<>();

    public static void setId(Long id) {
        longThreadLocal.set(id);
    }

    public static Long getId() {
        return longThreadLocal.get();
    }
}
