package io.codex.cryptogram.signature;

import java.io.ByteArrayInputStream;

/**
 * 抽象签名器
 *
 * @author 杨昌沛 646742615@qq.com
 * 2018/10/17
 */
public abstract class AbstractSignatureProvider implements SignatureProvider {

    public byte[] sign(byte[] message, byte[] key) throws Exception {
        return sign(new ByteArrayInputStream(message), key);
    }
}
