package io.codex.cryptogram.encoding;

/**
 * 原样编码器
 *
 * @author 杨昌沛 646742615@qq.com
 * 2018/10/18
 */
public class PlainEncoder implements Encoder {

    public String algorithm() {
        return "Plain";
    }

    public String encode(byte[] data) {
        return new String(data);
    }
}
