package io.codex.cryptogram.flatting;

import java.util.Collection;

/**
 * 集合类型的摊平器
 *
 * @author 杨昌沛 646742615@qq.com
 * 2018/10/17
 */
public class CollectionFlatter implements Flatter<Collection<?>> {

    public boolean support(Class<?> type) {
        return Collection.class.isAssignableFrom(type);
    }

    public String flat(Collection<?> value, FlattingProvider provider) {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (Object val : value) {
            if (val == null) continue;
            if (builder.length() > 1) builder.append(",");
            builder.append(provider.flat(val));
        }
        builder.append("]");
        return builder.toString();
    }
}
