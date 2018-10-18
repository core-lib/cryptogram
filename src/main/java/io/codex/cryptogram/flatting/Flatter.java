package io.codex.cryptogram.flatting;

/**
 * 摊平器
 *
 * @author 杨昌沛 646742615@qq.com
 * 2018/10/17
 */
public interface Flatter<T> {

    /**
     * 是否支持该类型的摊平
     *
     * @param type 类型
     * @return true:支持 false:不支持
     */
    boolean support(Class<?> type);

    /**
     * 将对象摊平成字符串
     *
     * @param value    对象
     * @param provider 摊平提供器
     * @return 对象摊平后的字符串
     */
    String flat(T value, FlattingProvider provider);

}
