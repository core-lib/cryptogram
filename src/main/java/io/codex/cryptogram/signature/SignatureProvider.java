package io.codex.cryptogram.signature;

import io.codex.cryptogram.Algorithm;

import java.io.InputStream;

/**
 * 签名提供器
 *
 * @author 杨昌沛 646742615@qq.com
 * 2018/10/17
 */
public interface SignatureProvider extends Algorithm {

    /**
     * 签名
     *
     * @param message 消息
     * @param key     密钥
     * @return 签名
     * @throws Exception 签名异常
     */
    byte[] sign(byte[] message, byte[] key) throws Exception;

    /**
     * 签名
     *
     * @param in  消息输入流
     * @param key 密钥
     * @return 签名
     * @throws Exception 签名异常
     */
    byte[] sign(InputStream in, byte[] key) throws Exception;

}
