package trong.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonMapperObj {
  public static String obj2Str(Object obj) throws JsonProcessingException {
    ObjectMapper objMapper = new ObjectMapper();
    return objMapper.writeValueAsString(obj);
  }
}
