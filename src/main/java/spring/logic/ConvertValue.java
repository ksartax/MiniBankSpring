package spring.logic;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by Damian Stępniak on 02.04.2017.
 */
public class ConvertValue<T> {

    private final Class<T> typeParameterClass;

    public ConvertValue(Class<T> typeParameterClass){
        this.typeParameterClass = typeParameterClass;
    }

    public T convertToObject(T object, JsonNode node, ObjectMapper mapper, String jsonElement)
    {
        object = mapper.convertValue(node.get(jsonElement), typeParameterClass);
        return object;
    }

}