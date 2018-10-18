package io.codex.cryptogram.codec;

import io.codex.cryptogram.decoding.PlainDecoder;
import io.codex.cryptogram.encoding.PlainEncoder;

/**
 * 原样编解码器
 *
 * @author 杨昌沛 646742615@qq.com
 * 2018/10/18
 */
public class PlainCodec extends ComboCodec {

    public PlainCodec() {
        super(new PlainEncoder(), new PlainDecoder());
    }
}
