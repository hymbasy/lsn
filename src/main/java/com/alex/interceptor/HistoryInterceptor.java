package com.alex.interceptor;

import com.alex.annotation.History;
import com.alex.service.HistoryService;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class HistoryInterceptor extends HandlerInterceptorAdapter {

    @Resource
    private HistoryService historyService;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        if (!(handler instanceof HandlerMethod)) {
            return;
        }

        final HandlerMethod handlerMethod = (HandlerMethod) handler;
        History history = handlerMethod.getMethodAnnotation(History.class);
        if (history != null) {
            Map<String, String> record = new HashMap<>();
            String[] param = history.param();
            if (param != null && param.length > 0) {
                for (String s : param) {
                    String value = request.getParameter(s);
                    record.put(s, value);
                }
            }
            historyService.save2Redis(record);
    }
    }
}
