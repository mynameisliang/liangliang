package cn.jxy.sdnweb.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cn.jxy.sdnweb.base.BaseController;
import cn.jxy.sdnweb.entity.User;
/**
 * 
 * @author Administrator
 *	登录控制类
 */
@Controller
@RequestMapping("/")
public class LoginController extends BaseController{
	
	private ModelAndView mv;
	
	//进入首页
	@RequestMapping(value = "toIndex", method = RequestMethod.GET)
	public String toLogin() {
		return "login";
	}
	
	//登录
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public ModelAndView login(User user,HttpSession session) {
		mv=new ModelAndView();
		
		User newUser=userService.findOne("login",user.getUsername(),user.getPassword());
		if(newUser!=null) {
			session.setAttribute("user", newUser);	
			mv.setViewName("redirect:weight/toIndex");
		}else {
			mv.addObject("msg", "密码或用户名错误！");
			mv.setViewName("login");
		}	
		return mv;
	}
	
	//注销
	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		deleteSession(session, "user","start","end","nodes","relations","routess");		
		return "login";
	}
	
	//清空部分session
	public void deleteSession(HttpSession session,String...strings) {
		for(int i=0;i<strings.length;i++) {
			if(session.getAttribute(strings[i])!=null) {
				session.removeAttribute(strings[i]);
			}
		}
	}
}
