//package hahahahahahahaha

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

public class JsonToObject {

	public static void main(String[] args) {



	try	{
			// Json 문자열이 파일인 경우
//          {
//		      "name": "Proxy-1"
//		      "routePath": [
//			    {"/notice" : "Proxy-2"},
//			    {"/service" : "Proxy-3"},
//			    {"/auth" : "Service-1" }
//		      ]
//          }
		    Path path = new File(System.getProperty("user.dir") + File.separator + "json-parse-test.txt").toPath();
			List<String> lines = Files.readAllLines(path);	

			// 또는 걍 
			String jsonStr = "{\"name\":\"Proxy-1\", \"routePath\":[{\"/notice\":\"Proxy-2\"},{\"/service\":\"Proxy-3\"},{\"/auth\":\"Service-1\"}]}";
			
			
			// line by line 또는
			for(String line : lines) {
//				System.out.println(line);
			}
			
			System.out.println("================");
			// jdk 11 미만은 이래야함
			String contents = String.join("\n", lines);
			
			
			// Gson 이용하여 모델로 변경
			Gson gson = new Gson();			
			ProxyServer proxyServer = gson.fromJson(jsonStr, ProxyServer.class);
			
			System.out.println(proxyServer.getName());
			List<Map<String, String>> paths = proxyServer.getRoutePath();
			for(Map pathMap : paths) {
				System.out.println(pathMap.toString());
			}
		
		}catch(Exception e){
			e.printStackTrace();
		}

	}
	
  // Model Example
	public class ProxyServer {
		
		private String name;
		private List<Map<String, String>> routePath;
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public List<Map<String, String>> getRoutePath() {
			return routePath;
		}
		public void setRoutePath(List<Map<String, String>> routePath) {
			this.routePath = routePath;
		}		
	}
}


