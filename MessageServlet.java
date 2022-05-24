import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class MessageServlet extends HttpServlet{
	
	private final long serialVersionUID = 1L;
	
	// get 
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException{
		
		String uriPath = req.getRequestURI();
		System.out.println(uriPath);
		String[] uriParamList = uriPath.split("/");
		String cmd = uriParamList[1];
		String qName = uriParamList[2];
		
		JsonObject result = MessageService.messageService(cmd, qName, req);
		
		Gson gson = new Gson();
		res.setContentType("application/json");
		res.setCharacterEncoding("utf-8");
		
		res.setStatus(200); //status
		res.getWriter().write(gson.toJson(result));
	}
	
	// post
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		String uriPath = req.getRequestURI();
		System.out.println(uriPath);
		String[] uriParamList = uriPath.split("/");
		
		String cmd = uriParamList[1];
		String qName = uriParamList[2];
		
		JsonObject result = MessageService.messageService(cmd, qName, req);
		
		Gson gson = new Gson();
		res.setContentType("application/json");
		res.setCharacterEncoding("utf-8");
		
		res.setStatus(200);
		res.getWriter().write(gson.toJson(result));
	}

}
