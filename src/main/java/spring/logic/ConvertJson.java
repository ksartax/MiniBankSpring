package spring.logic;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * Created by Damian Stępniak on 02.04.2017.
 */
public class ConvertJson {

    private ObjectMapper mapper;
    private JsonNode node;

    public ConvertJson(){
        mapper = new ObjectMapper();
    }

    public void selectJson(String json) throws IOException {
        node = mapper.readTree(json);
    }

    public ObjectMapper getMapper() {
        return mapper;
    }

    public JsonNode getNode(){
        return node;
    }

}
