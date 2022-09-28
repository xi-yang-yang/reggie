package web.reggie.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import web.reggie.filter.LoginFilter;

@Configuration
public class LoginFilterConfig {
    @Bean
    public FilterRegistrationBean<LoginFilter> loginFilterFilterRegistrationBean() {
        FilterRegistrationBean<LoginFilter> filterRegistrationBean = new FilterRegistrationBean<>(new LoginFilter());
        filterRegistrationBean.setName("loginFilter");
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.setOrder(1);
        return filterRegistrationBean;
    }
}
