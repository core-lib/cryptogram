package io.codex.cryptogram.flatting;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * 数组类型的摊平器
 *
 * @author 杨昌沛 646742615@qq.com
 * 2018/10/17
 */
public class ArrayFlatter implements Flatter<Object> {

    public boolean support(Class<?> type) {
        return type.isArray();
    }

    public String flat(Object value, FlattingProvider provider) {
        ArrayList<Object> collection = new ArrayList<Object>();
        int length = Array.getLength(value);
        for (int i = 0; i < length; i++) {
            Object val = Array.get(value, i);
            collection.add(val);
        }
        return provider.flat(collection);
    }

}
