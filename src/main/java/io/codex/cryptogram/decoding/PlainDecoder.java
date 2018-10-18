package io.codex.cryptogram.decoding;

/**
 * 原样解码器
 *
 * @author 杨昌沛 646742615@qq.com
 * 2018/10/18
 */
public class PlainDecoder implements Decoder {

    public String algorithm() {
        return "plain";
    }

    public byte[] decode(String data) {
        return data.getBytes();
    }
}
