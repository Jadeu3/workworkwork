
public class RequestGetJson {

  public static JsonObject getReqBodyJson(HttpServletRequest req) {

      // get parameters from reqBody
      JsonObject jsonObj = null;
      try {
        StringBuilder buffer = new StringBuilder();
        BufferedReader reader = req.getReader();
        String line;
        while ((line = reader.readLine()) != null) {
          buffer.append(line);
          buffer.append(System.lineSeparator());
        }
        String data = buffer.toString();
        System.out.println("===data: " + data);
        JsonElement jsonEl = JsonParser.parseString(data);
        jsonObj = jsonEl.getAsJsonObject();

      } catch (Exception e) {
        e.getMessage();
      }
      return jsonObj;

    }
  
  }
