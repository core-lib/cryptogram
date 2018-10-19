package io.codex.cryptogram.stringify;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;

/**
 * 数组类型的串化器
 *
 * @author 杨昌沛 646742615@qq.com
 * 2018/10/17
 */
public class ArrayStringify implements Stringify<Object> {

    public boolean support(Class<?> type) {
        return type.isArray();
    }

    public String stringify(Object value, StringifyProvider provider) {
        Collection<Object> collection = new ArrayList<Object>();
        int length = Array.getLength(value);
        for (int i = 0; i < length; i++) {
            Object val = Array.get(value, i);
            collection.add(val);
        }
        return provider.flat(collection);
    }

}
