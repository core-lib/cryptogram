package io.codex.cryptogram.decoding;

import org.apache.commons.codec.binary.Base64;

/**
 * Base64解码器
 *
 * @author 杨昌沛 646742615@qq.com
 * 2018/10/17
 */
public class Base64Decoder implements Decoder {

    public String algorithm() {
        return "Base64";
    }

    public byte[] decode(String data) {
        return Base64.decodeBase64(data);
    }
}
