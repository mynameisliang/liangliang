package cn.jxy.sdnweb.controller;




import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cn.jxy.sdnweb.base.BaseController;
import cn.jxy.sdnweb.entity.User;
import cn.jxy.sdnweb.util.PageCut;



/**
 * 
 * @author Administrator
 *用户管理控制类
 */
@Controller
@RequestMapping("/user/")
public class UserController extends BaseController{
	
	private ModelAndView mv;
	
	//获得用户
	@RequestMapping(value = "find", method = RequestMethod.GET)
	public ModelAndView find(
			@RequestParam(defaultValue = "0" , name = "curr") int curr,	
			@RequestParam(defaultValue = "8" , name = "size") int size,
			@RequestParam(defaultValue = "" , name = "search") String search,			
			HttpSession session
			) throws Exception {
		//清空节点缓存
		deleteSession(session, "start","end","nodes","relations","routess");
		
		mv=new ModelAndView();
		search=new String (search.getBytes("ISO-8859-1"),"UTF-8");
		String msg=(String)session.getAttribute("msg");
		if( !(msg==null  || msg.equals(""))) {
			session.removeAttribute("msg");
			mv.addObject("msg", msg);
		}
		PageCut<User> pc=null;
		if(search.equals("") || search==null) {
			pc=userService.finds(curr, size, "all");
		}else {
			pc=userService.finds(curr, size, "search",search);
			mv.addObject("search",search);
		}
		mv.addObject("pc", pc);
		mv.setViewName("userMge");
		return mv;
	}
	
	//进入添加用户
	@RequestMapping(value = "toAdd", method = RequestMethod.GET)
	public ModelAndView toAdd(HttpSession session){
		mv=new ModelAndView();
		String msg=(String)session.getAttribute("msg");
		if(msg!=null) {
			mv.addObject("msg",msg);
			session.removeAttribute("msg");
		}
		mv.setViewName("add");
		return mv;
	}
	
	//添加用户
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public ModelAndView add(User user,HttpSession session){
		mv=new ModelAndView();
		User u=userService.findOne("only", user.getUsername());
		String msg="";
		if(u!=null) {
			msg="添加失败,用户名已被注册！";
		}else {
			boolean bool=userService.add(user);
			if(bool==true) {
				msg="添加成功！";
			}else {
				msg="添加失败！";
			}
		}	
		session.setAttribute("msg", msg);
		mv.setViewName("redirect:toAdd");
		return mv;
	}	
	
	//获得个人信息
	@RequestMapping(value = "toUpdate", method = RequestMethod.GET)
	public ModelAndView toUpdate(@RequestParam(defaultValue = "0" , name = "id") int id,HttpSession session){
		mv=new ModelAndView();
		
		if(id==0) {
			int userId=(int)session.getAttribute("userId");
			System.out.println("userId="+userId);
			id=userId;
			session.removeAttribute("userId");
		}
		User user=userService.findOne("id", id);
		
		String msg=(String)session.getAttribute("msg");
		mv.addObject("userInfo", user);
		
		if(msg!=null) {
			mv.addObject("msg",msg);
			session.removeAttribute("msg");
		}
		mv.setViewName("update");
		return mv;
	}
	
	
	//修改信息
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public ModelAndView update(User user,HttpSession session){
		System.out.println(user);
		mv=new ModelAndView();		
		User oldUser=userService.findOne("id", user.getId());
		user.setType(oldUser.getType());
		boolean bool=userService.update(user);	
		String msg="";
		if(bool==true) {
			mv.addObject("userInfo",user);
			msg="修改成功！";
		}else {
			mv.addObject("userInfo",user);
			msg="修改失败！";
		}
		session.setAttribute("msg", msg);
		session.setAttribute("userId", user.getId());
		mv.setViewName("redirect:toUpdate");
		return mv;
	}
	
	//删除用户
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String delete(int id,HttpSession session){
		mv=new ModelAndView();
		boolean bool=userService.delete(id);
		String msg="";		
		if(bool==true) {
			msg="删除成功！";
		}else {
			msg="删除失败！";
		}
		session.setAttribute("msg", msg);		
		return "redirect:find"; 
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
