package weixinkeji.vip.expand.poi.test.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import weixinkeji.vip.expand.poi.JWEOfficeEnum;
import weixinkeji.vip.expand.poi.JWEOfficeR;
import weixinkeji.vip.expand.poi.test.entity.User;

public class ExcelUpload extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String sheet = req.getParameter("sheet");
		if (sheet.equalsIgnoreCase("1")) {
			this.readOne(req, resp);
		} else {
			this.readMany(req, resp);
		}
	}
	private void readOne(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Part part=req.getPart("excelfilename");
		try {
			System.out.println(part.getSubmittedFileName()+"//"+part.getName());
			
			List<User> list=null;
			if(part.getSubmittedFileName().endsWith(".xls")) {
				list=JWEOfficeR.readExcel_xls(User.class,"用户信息",part.getInputStream());
			}
			if(part.getSubmittedFileName().endsWith(".xlsx")) {
				list=JWEOfficeR.readExcel_xlsx(User.class,"用户信息",part.getInputStream());
			}
			this.prUser(list);
			
			resp.sendRedirect(req.getContextPath()+"/index.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void readMany(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Part part=req.getPart("excelfilename");
		try {
			System.out.println(part.getSubmittedFileName()+"//"+part.getName());
			List<User> list=null;
			if(part.getSubmittedFileName().endsWith(".xls")) {
				JWEOfficeR obj=new JWEOfficeR(part.getInputStream(),JWEOfficeEnum.xls);
				list=obj.readExcel(User.class, "用户信息");
				this.prUser(list);
				System.out.println("------------------------------------");
				list=obj.readExcel(User.class, "用户信息2");
				this.prUser(list);
			}
			if(part.getSubmittedFileName().endsWith(".xlsx")) {
				JWEOfficeR obj=new JWEOfficeR(part.getInputStream(),JWEOfficeEnum.xlsx);
				list=obj.readExcel(User.class, "用户信息");
				this.prUser(list);
				System.out.println("------------------------------------");
				list=obj.readExcel(User.class, "用户信息2");
				this.prUser(list);
			}
			resp.sendRedirect(req.getContextPath()+"/index.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	private void prUser(List<User> list) {
		for(User user:list) {
			System.out.println(user.toString());
		}
	}

}
