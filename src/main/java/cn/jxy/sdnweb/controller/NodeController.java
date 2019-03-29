package cn.jxy.sdnweb.controller;




import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cn.jxy.sdnweb.base.BaseController;
import cn.jxy.sdnweb.entity.Node;
import cn.jxy.sdnweb.util.PageCut;



/**
 * 
 * @author Administrator
 *节点控制类
 */
@Controller
@RequestMapping("/node/")
public class NodeController extends BaseController{
	
	private ModelAndView mv;
	
	
	//获得节点
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
		PageCut<Node> pc=null;
		if(search.equals("") || search==null) {
			pc=nodeService.finds(curr, size, "all");
		}else {
			pc=nodeService.finds(curr, size, "search",search);
			mv.addObject("search",search);
		}
		
		mv.addObject("pc", pc);
		mv.setViewName("nodesMge");
		return mv;
	}
	
	
	
	//删除节点
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String delete(int id,HttpSession session){
		mv=new ModelAndView();
		boolean bool=nodeService.delete(id);
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
