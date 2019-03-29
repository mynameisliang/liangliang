package cn.jxy.sdnweb.controller;

import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.jxy.sdnweb.util.ExcelUtil;
import cn.jxy.sdnweb.util.Routes;
/**
 * 导出excel 路由表导出控制类
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/excel/")
public class ExcelController {
	/*
	 * 导出excel 路由表
	 */
	
	@RequestMapping(value = "outputRoutes", method = RequestMethod.GET)
	public void outputRoutes(HttpSession session,HttpServletRequest request,HttpServletResponse response) throws Exception {
		List<Routes> routess=(List<Routes>)session.getAttribute("routess");
		if(routess!=null) {
			OutputStream output = response.getOutputStream();
            response.reset();
            response.setHeader("Content-disposition", "attachment; filename=routes.xls");
            response.setContentType("application/x-download");
            output = response.getOutputStream();
            ExcelUtil.creat2003Excel(routess,output);
            output.flush();
            output.close();
	           
		}else {
			
		}
	}
	
}
