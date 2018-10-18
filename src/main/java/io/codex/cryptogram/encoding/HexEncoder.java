package io.codex.cryptogram.encoding;

import org.apache.commons.codec.binary.Hex;

/**
 * 十六进制编码器
 *
 * @author 杨昌沛 646742615@qq.com
 * 2018/10/17
 */
public class HexEncoder implements Encoder {

    public String algorithm() {
        return "Hex";
    }

    public String encode(byte[] data) {
        return new String(Hex.encodeHex(data));
    }
}
