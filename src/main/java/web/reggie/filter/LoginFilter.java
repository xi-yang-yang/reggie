package web.reggie.filter;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.AntPathMatcher;
import web.reggie.common.R;
import web.reggie.utils.BaseContext;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Slf4j
public class LoginFilter implements Filter {
    public static final AntPathMatcher PATH_MATCHER = new AntPathMatcher();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("过滤器启动");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String requestURI = request.getRequestURI();
        String[] urls = new String[]{
                "/employee/login",
                "/employee/logout",
                "/backend/**",
                "/front/**",
                "/common/**",
                "/user/sendMsg",
                "/user/login"
        };
        boolean check = check(requestURI, urls);
        if (check) {
            filterChain.doFilter(request, response);
            return;
        } else {
            HttpSession session = request.getSession();
            Long uId = (Long) session.getAttribute("user");
            BaseContext.setId(uId);
            if (uId == null) {
                response.getWriter().write(JSON.toJSONString(R.error("NOTLOGIN")));
                return;
            } else {
                filterChain.doFilter(request, response);
            }
        }
    }

    @Override
    public void destroy() {
        log.info("过滤器关闭");
    }

    public static boolean check(String requestURL, String[] urls) {
        for (String url : urls) {
            boolean result = PATH_MATCHER.match(url, requestURL);
            if (result) {
                return true;
            }
        }
        return false;
    }
}
