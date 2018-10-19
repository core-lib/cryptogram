package io.codex.cryptogram.stringify;

/**
 * 字符串类型的串化器
 *
 * @author 杨昌沛 646742615@qq.com
 * 2018/10/17
 */
public class StringStringify implements Stringify<CharSequence> {

    public boolean support(Class<?> type) {
        return CharSequence.class.isAssignableFrom(type);
    }

    public String stringify(CharSequence value, StringifyProvider provider) {
        return value.toString();
    }
}
