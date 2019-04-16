package com.controller;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.ws.soap.Addressing;

import org.apache.jasper.tagplugins.jstl.core.Redirect;
import org.omg.PortableInterceptor.ForwardRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pojo.User;
import com.service.UserService;
import com.utils.MD5;

@Controller
public class UserController {
    
	@Autowired
	UserService userService;
	
	
	@RequestMapping("/loginServlet")
	public String login(String username,String password,HttpServletRequest request){
			//加密
				MD5  md=new MD5();
				String pwd=md.getMD5String(password);
				User user=userService.login(username, pwd);
				if (user!=null) {
					HttpSession session=request.getSession();
					session.setAttribute("user", user);
//					Date date=new Date();
//					SimpleDateFormat spdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//					String time=spdf.format(date);
					//userService.updateTime(user.getId(),time);
					return "forward:index.jsp";
				}else {
					return "redirect:register.jsp";
				}
		
	}
}
