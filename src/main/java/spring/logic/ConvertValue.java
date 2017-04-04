package spring.logic;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * Created by Damian Stępniak on 02.04.2017.
 */
public class ConvertValue<T> {

    private final Class<T> typeParameterClass;
    private ObjectMapper mapper;
    private JsonNode node;

    public ConvertValue(Class<T> typeParameterClass, String json) throws IOException {
        mapper = new ObjectMapper();
        this.typeParameterClass = typeParameterClass;
        node = mapper.readTree(json);
    }

    public JsonNode getNode(){
        return node;
    }

    public T convertToObject(String jsonElement) throws IllegalArgumentException
    {
        return mapper.convertValue(node.get(jsonElement), typeParameterClass);
    }

}