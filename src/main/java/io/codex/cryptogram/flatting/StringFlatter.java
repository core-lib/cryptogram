package io.codex.cryptogram.flatting;

/**
 * 字符串类型的摊平器
 *
 * @author 杨昌沛 646742615@qq.com
 * 2018/10/17
 */
public class StringFlatter implements Flatter<CharSequence> {

    public boolean support(Class<?> type) {
        return CharSequence.class.isAssignableFrom(type);
    }

    public String flat(CharSequence value, FlattingProvider provider) {
        return value.toString();
    }
}
