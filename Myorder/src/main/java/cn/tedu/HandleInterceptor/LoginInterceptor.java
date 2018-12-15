package cn.tedu.HandleInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {

	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) throws Exception {
		
		//实现HandlerInterceptor接口  
		//重写preHandle方法 在里面进行session认证 没有登录重定向到登录页
		HttpSession session = req.getSession();
		Object obj = session.getAttribute("sessionUser");
		if(obj==null){
			
			String path = req.getContextPath()+"/system/reg.html";
			System.out.println("拦截成功");
			res.sendRedirect(path);
			return false;
		}
		//true 请求继续
		return true;
	}
	

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		
	}
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
	}
	

	
}
