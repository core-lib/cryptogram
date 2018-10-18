package io.codex.cryptogram.decoding;

import io.codex.cryptogram.Algorithm;

/**
 * 解码器
 *
 * @author 杨昌沛 646742615@qq.com
 * 2018/10/17
 */
public interface Decoder extends Algorithm {

    /**
     * 解码
     *
     * @param data 编码后数据
     * @return 原数据
     */
    byte[] decode(String data);

}
