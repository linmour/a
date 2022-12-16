package com.lsc.Handler.security;

import com.alibaba.fastjson.JSON;
import com.lsc.domain.Result;
import com.lsc.enums.AppHttpCodeEnum;
import com.lsc.utils.WebUtils;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AccessDeniedHandlerImpl implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        accessDeniedException.printStackTrace();
        WebUtils.renderString(response,JSON.toJSONString(Result.errorResult(AppHttpCodeEnum.NO_OPERATOR_AUTH)));
 
    }
}
 