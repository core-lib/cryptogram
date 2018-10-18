package io.codex.cryptogram.verification;

import java.io.ByteArrayInputStream;

/**
 * 抽象的验证提供器
 *
 * @author 杨昌沛 646742615@qq.com
 * 2018/10/17
 */
public abstract class AbstractVerificationProvider implements VerificationProvider {

    public boolean verify(byte[] message, byte[] signature, byte[] key) throws Exception {
        return verify(new ByteArrayInputStream(message), signature, key);
    }

}
