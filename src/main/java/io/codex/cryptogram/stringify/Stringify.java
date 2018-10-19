package io.codex.cryptogram.stringify;

/**
 * 串化器
 *
 * @author 杨昌沛 646742615@qq.com
 * 2018/10/17
 */
public interface Stringify<T> {

    /**
     * 是否支持该类型的串化
     *
     * @param type 类型
     * @return true:支持 false:不支持
     */
    boolean support(Class<?> type);

    /**
     * 将对象串化成字符串
     *
     * @param value    对象
     * @param provider 串化提供器
     * @return 对象串化后的字符串
     */
    String stringify(T value, StringifyProvider provider);

}
