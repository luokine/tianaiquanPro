package com.luokine.user.service.filter;

import com.alibaba.fastjson.JSONObject;
import com.luokine.user.service.utils.TokenUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @author: tiantziquan
 * @create: 2019-06-17 19:34
 */
@Component
public class TokenInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (request.getMethod().equals("OPTIONS")) {
            response.setStatus(HttpServletResponse.SC_OK);
            return true;
        }

        response.setCharacterEncoding("utf-8");

        String token = request.getHeader("User-Info");
        if (token != null) {
            boolean result = TokenUtil.verify(token);
            if (result) {
//                System.out.println("通过拦截器");
                return true;
            }
        }
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        PrintWriter out = null;
        try {
            JSONObject json = new JSONObject();
            json.put("success", "false");
            json.put("msg", "认证失败，未通过拦截器");
            json.put("code", "-1000");
            response.getWriter().append(json.toJSONString());
            System.out.println("认证失败，未通过拦截器");
            response.getWriter().write("50000");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(500);
            return false;
        }


        return false;

    }

}
