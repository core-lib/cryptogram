package io.codex.cryptogram.encoding;

import org.apache.commons.codec.binary.Base64;

/**
 * Base64编码器
 *
 * @author 杨昌沛 646742615@qq.com
 * 2018/10/17
 */
public class Base64Encoder implements Encoder {

    public String algorithm() {
        return "Base64";
    }

    public String encode(byte[] data) {
        return Base64.encodeBase64String(data);
    }
}
