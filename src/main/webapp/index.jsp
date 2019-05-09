<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<body>

<h1>下载、上传excel 的读写单个工作表 演示</h1>
<a href="<%=request.getContextPath()%>/ExcelDow?sheet=1&sort=xls" >下载excel.xls（写单个工作表）</a><br/>
<a href="<%=request.getContextPath()%>/ExcelDow?sheet=1&sort=xlsx" >下载excel.xlsx（写单个工作表）</a><br/>
<br/>
上传excel文档.xls或 excel文档.xlsx
<form id="form-1" action="<%=request.getContextPath()%>/ExcelUpload?sheet=1" method="post" enctype="multipart/form-data">
	<input name="excelfilename" type="file">
	<br/>
	<input type="submit" value="提交">
</form>
<br/>
<br/>
<hr/>
<h1>下载、上传excel 的读写【多个工作表】 演示</h1>
<a href="<%=request.getContextPath()%>/ExcelDow?sheet=2&sort=xls" >下载excel.xls（写多个工作表）</a><br/>
<a href="<%=request.getContextPath()%>/ExcelDow?sheet=2&sort=xlsx" >下载excel.xlsx（写多个工作表）</a><br/>
<br/>
上传excel文档.xls或 excel文档.xlsx
<form id="form-1" action="<%=request.getContextPath()%>/ExcelUpload?sheet=2" method="post" enctype="multipart/form-data">
	<input name="excelfilename" type="file">
	<br/>
	<input type="submit" value="提交">
</form>
<br/>
<br/>
<hr/>
</body>
</html>
