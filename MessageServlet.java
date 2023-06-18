package com.lgcns.test;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class MessageServlet extends HttpServlet{
	
	private final long serialVersionUID = 1L;

	// 범용
	public void service(HttpServletRequest req, HttpServletResponse res) {

		String method = req.getMethod(); //method 구분 
						
		
	}
	
	// get 
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException{
		
		String uriPath = req.getRequestURI();
		// json 에서 Rule 가져옴
		String nextTarget = "http://127.0.0.1";
		
				
				
			
		System.out.println("====uri:" + uriPath);
		String[] uriParamList = uriPath.split("/");
		
		JsonObject result = MessageService.messageService(uriParamList, req);
		
		Gson gson = new Gson();
		res.setContentType("application/json");
		res.setCharacterEncoding("utf-8");
		
		res.setStatus(200); //status
		res.getWriter().write(gson.toJson(result));
	}
	
	// post
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		String uriPath = req.getRequestURI();
		String[] uriParamList = uriPath.split("/");
		
		JsonObject result = MessageService.messageService(uriParamList, req);
		
		Gson gson = new Gson();
		res.setContentType("application/json");
		res.setCharacterEncoding("utf-8");
		
		res.setStatus(200);
		res.getWriter().write(gson.toJson(result));
	}

}
