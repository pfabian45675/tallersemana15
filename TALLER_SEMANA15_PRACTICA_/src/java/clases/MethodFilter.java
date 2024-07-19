/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author FABIAN
 */
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.IOException;

@WebFilter("/*")
public class MethodFilter implements Filter {
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String method = httpRequest.getParameter("_method");
        if (method != null && (method.equalsIgnoreCase("put") || method.equalsIgnoreCase("delete"))) {
            httpRequest = new HttpServletRequestWrapper(httpRequest) {
                @Override
                public String getMethod() {
                    return method;
                }
            };
        }
        chain.doFilter(httpRequest, response);
    }

    public void init(FilterConfig filterConfig) throws ServletException {}

    public void destroy() {}
}

