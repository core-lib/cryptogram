package io.codex.cryptogram.stringify;

import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * 映射类型的串化器
 *
 * @author 杨昌沛 646742615@qq.com
 * 2018/10/17
 */
public class MapStringify implements Stringify<Map<String, ?>> {

    public boolean support(Class<?> type) {
        return Map.class.isAssignableFrom(type);
    }

    public String stringify(Map<String, ?> value, StringifyProvider provider) {
        Set<String> keys = new TreeSet<String>(value.keySet()); // 排序
        StringBuilder builder = new StringBuilder();
        builder.append("{");
        for (String key : keys) {
            Object val = value.get(key);
            if (val == null) continue;
            if (builder.length() > 1) builder.append("&");
            builder.append(key).append("=").append(provider.stringify(val));
        }
        builder.append("}");
        return builder.toString();
    }
}
