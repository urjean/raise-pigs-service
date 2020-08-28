package com.raise.pigs.service.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.raise.pigs.service.config.globalException.ServiceException;

import java.io.IOException;

/**
 * <p>
 * 将字符串转为Long
 * </p>
 *
 * @author osumg
 * @since 2020/8/27
 */
public class StringToLong extends JsonDeserializer<Long> {

    @Override
    public Long deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        String value = jsonParser.getText();
        try {
            return value == null ? null : Long.parseLong(value);
        } catch (NumberFormatException e) {
            throw new ServiceException("数字转换异常");
        }
    }
}
