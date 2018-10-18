package io.codex.cryptogram.flatting;

import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * 映射类型的摊平器
 *
 * @author 杨昌沛 646742615@qq.com
 * 2018/10/17
 */
public class MapFlatter implements Flatter<Map<String, ?>> {

    public boolean support(Class<?> type) {
        return Map.class.isAssignableFrom(type);
    }

    public String flat(Map<String, ?> value, FlattingProvider provider) {
        Set<String> keys = new TreeSet<String>(value.keySet()); // 排序
        StringBuilder builder = new StringBuilder();
        builder.append("{");
        for (String key : keys) {
            Object val = value.get(key);
            if (val == null) continue;
            if (builder.length() > 1) builder.append("&");
            builder.append(key).append("=").append(provider.flat(val));
        }
        builder.append("}");
        return builder.toString();
    }
}
