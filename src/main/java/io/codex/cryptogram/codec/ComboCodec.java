package io.codex.cryptogram.codec;

import io.codex.cryptogram.decoding.Decoder;
import io.codex.cryptogram.encoding.Encoder;

/**
 * 组合的编解码器
 *
 * @author 杨昌沛 646742615@qq.com
 * 2018/10/17
 */
public class ComboCodec implements Codec {
    private final Encoder encoder;
    private final Decoder decoder;

    public ComboCodec(Encoder encoder, Decoder decoder) {
        this.encoder = encoder;
        this.decoder = decoder;
    }

    public String algorithm() {
        String encoding = encoder.algorithm();
        String decoding = decoder.algorithm();
        return encoding.equals(decoding) ? encoding : "combo";
    }

    public String encode(byte[] data) {
        return encoder.encode(data);
    }

    public byte[] decode(String data) {
        return decoder.decode(data);
    }
}
