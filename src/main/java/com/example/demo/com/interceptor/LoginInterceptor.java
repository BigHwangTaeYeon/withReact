package com.example.demo.com.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {
    /**
     * 세션에 계정정보(SessionVO)가 있는지 여부로 인증 여부를 체크한다. 계정정보(SessionVO)가 없다면, 로그인 페이지로 이동한다.
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException {
        System.out.println("Get iN");
        return true;
//        SessionVO sessionVo = null;
//
//        try {
//            sessionVo = (SessionVO) SessionUtil.getSessionAttribute(request, "sessUser");
//
//            if (sessionVo != null && sessionVo.getSessUserID() != null) {
//                return true;
//            } else {
//                ModelAndView modelAndView = new ModelAndView("redirect:/forward.do");
//                modelAndView.addObject("msgCode", "세션이 만료되어 로그아웃 되었습니다. 다시 로그인 해주세요.");
//                modelAndView.addObject("returnUrl", "/login.do");
//                throw new ModelAndViewDefiningException(modelAndView);
//            }
//        } catch (Exception e) {
//            ModelAndView modelAndView = new ModelAndView("redirect:/forward.do");
//            modelAndView.addObject("msgCode", "세션이 만료되어 로그아웃 되었습니다. 다시 로그인 해주세요.");
//            modelAndView.addObject("returnUrl", "/login.do");
//            throw new ModelAndViewDefiningException(modelAndView);
//        }
    }
}
