package io.codex.cryptogram.stringify;

import java.util.Collection;

/**
 * 集合类型的串化器
 *
 * @author 杨昌沛 646742615@qq.com
 * 2018/10/17
 */
public class CollectionStringify implements Stringify<Collection<?>> {

    public boolean support(Class<?> type) {
        return Collection.class.isAssignableFrom(type);
    }

    public String stringify(Collection<?> value, StringifyProvider provider) {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (Object val : value) {
            if (val == null) continue;
            if (builder.length() > 1) builder.append(",");
            builder.append(provider.stringify(val));
        }
        builder.append("]");
        return builder.toString();
    }
}
