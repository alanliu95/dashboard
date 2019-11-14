package com.alan.dashboard.redis;

import com.alibaba.fastjson.JSON;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

public class MyRedisSerializer implements RedisSerializer<Object> {
    @Override
    public byte[] serialize(Object value) throws SerializationException {
        if (value == null)
            return null;
        Class<?> clazz = value.getClass();
        if (clazz == int.class || clazz == Integer.class) {
            return ("" + value).getBytes();
        } else if (clazz == String.class) {
            return ((String) value).getBytes();
        } else if (clazz == long.class || clazz == Long.class) {
            return ("" + value).getBytes();
        } else {
            return JSON.toJSONBytes(value);
        }
    }

    @Override
    public Object deserialize(byte[] bytes) throws SerializationException {
        return null;
    }
}
