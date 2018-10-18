package io.codex.cryptogram.encoding;

import io.codex.cryptogram.Algorithm;

/**
 * 编码器
 *
 * @author 杨昌沛 646742615@qq.com
 * 2018/10/17
 */
public interface Encoder extends Algorithm {

    /**
     * 编码
     *
     * @param data 原数据
     * @return 编码后数据
     */
    String encode(byte[] data);

}
