package weixinkeji.vip.expand.poi.test.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import weixinkeji.vip.expand.poi.JWEOfficeEnum;
import weixinkeji.vip.expand.poi.JWEOfficeW;
import weixinkeji.vip.expand.poi.test.entity.User;

public class ExcelDow extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String sheet = req.getParameter("sheet");
		if (sheet.equalsIgnoreCase("1")) {
			this.doOneSheet(req, resp);
		} else {
			this.doManySheet(req, resp);
		}
	}
	
	//单个工作表时
	private void doOneSheet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String sort = req.getParameter("sort");
		if (null == sort || sort.equalsIgnoreCase("xls")) {
			this.setFileContentHeader(resp, "用户信息集合(单表).xls");
			JWEOfficeW.writeToExcel_xls(resp.getOutputStream(), "用户信息", this.getUser());
		} else {
			this.setFileContentHeader(resp, "用户信息集合(单表).xlsx");
			JWEOfficeW.writeToExcel_xlsx(resp.getOutputStream(), "用户信息", this.getUser());
		}
	}
	
	//多个工作表时
	private void doManySheet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String sort = req.getParameter("sort");
		if (null == sort || sort.equalsIgnoreCase("xls")) {
			this.setFileContentHeader(resp, "用户信息集合(多表).xls");
			JWEOfficeW obj = new JWEOfficeW(resp.getOutputStream(), JWEOfficeEnum.xls);
			try {
				obj.addToExcel("用户信息", this.getUser());
				obj.addToExcel("用户信息2", this.getUser());
				obj.writeAndAutoCloseIO();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			this.setFileContentHeader(resp, "用户信息集合(多表).xlsx");
			JWEOfficeW obj = new JWEOfficeW(resp.getOutputStream(), JWEOfficeEnum.xlsx);
			try {
				obj.addToExcel("用户信息", this.getUser());
				obj.addToExcel("用户信息2", this.getUser());
				obj.writeAndAutoCloseIO();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}
	//设置下载时，文件名的显示 及编号 处理
	private void setFileContentHeader(HttpServletResponse resp,String filename) throws IOException {
		resp.setHeader("Content-Disposition",
				"attachment;filename=" + new String(filename.getBytes("utf-8"), "ISO8859-1"));
	}
	
	/**
	 * 模拟后台数据
	 * @return
	 */
	private List<User> getUser() {
		List<User> list = new ArrayList<>();
		User user;
		for (int i = 0; i < 2; i++) {
			user = new User();
			user.setId(i);
			user.setUserAge(18);
			user.setUserBirthday(new Date());
			user.setCreateTime(new Date());
			user.setUserMoney(200.44);
			user.setUserName("userName" + i);
			user.setUserSex((short) 1);
			list.add(user);
		}
		return list;
	}

}
