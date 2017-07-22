package com.qhit.api;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qhit.util.upload.FileUploadHelper;

/**
 * 上传文件
 * 
 * @author Administrator
 * 
 */
@WebServlet(name = "UploadServlet", urlPatterns = "/upload")
public class UploadServlet extends HttpServlet {

	private static final long serialVersionUID = 4145994666221493636L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FileUploadHelper helper = new FileUploadHelper();

		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");

		String result = helper.upload(request);

		response.getWriter().append(result);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}