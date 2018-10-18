package io.codex.cryptogram.codec;

import io.codex.cryptogram.decoding.Base64Decoder;
import io.codex.cryptogram.encoding.Base64Encoder;

/**
 * Base64编解码器
 *
 * @author 杨昌沛 646742615@qq.com
 * 2018/10/17
 */
public class Base64Codec extends ComboCodec {

    public Base64Codec() {
        super(new Base64Encoder(), new Base64Decoder());
    }
}
