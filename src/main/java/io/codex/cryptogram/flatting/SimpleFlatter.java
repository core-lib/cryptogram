package io.codex.cryptogram.flatting;

/**
 * 简单类型的摊平器
 *
 * @author 杨昌沛 646742615@qq.com
 * 2018/10/17
 */
public class SimpleFlatter implements Flatter<Object> {

    public boolean support(Class<?> type) {
        return type.isPrimitive()
                || type == Boolean.class
                || type == Byte.class
                || type == Short.class
                || type == Character.class
                || type == Integer.class
                || type == Float.class
                || type == Long.class
                || type == Double.class;
    }

    public String flat(Object value, FlattingProvider provider) {
        return String.valueOf(value);
    }

}
