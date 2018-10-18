package io.codex.cryptogram.codec;

import io.codex.cryptogram.decoding.HexDecoder;
import io.codex.cryptogram.encoding.HexEncoder;

/**
 * 十六进制编解码器
 *
 * @author 杨昌沛 646742615@qq.com
 * 2018/10/17
 */
public class HexCodec extends ComboCodec {

    public HexCodec() {
        super(new HexEncoder(), new HexDecoder());
    }
}
