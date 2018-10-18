package io.codex.cryptogram.decoding;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

/**
 * 十六进制解码器
 *
 * @author 杨昌沛 646742615@qq.com
 * 2018/10/17
 */
public class HexDecoder implements Decoder {

    public String algorithm() {
        return "Hex";
    }

    public byte[] decode(String data) {
        try {
            return Hex.decodeHex(data);
        } catch (DecoderException e) {
            throw new RuntimeException(e);
        }
    }
}
