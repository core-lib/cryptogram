package io.codex.cryptogram.verification;

import io.codex.cryptogram.Algorithm;

import java.io.InputStream;

/**
 * 验证提供器
 *
 * @author 杨昌沛 646742615@qq.com
 * 2018/10/17
 */
public interface VerificationProvider extends Algorithm {

    /**
     * 签名
     *
     * @param message   消息
     * @param signature 签名
     * @param key       密钥
     * @return 签名
     * @throws Exception 签名异常
     */
    boolean verify(byte[] message, byte[] signature, byte[] key) throws Exception;

    /**
     * 签名
     *
     * @param in        消息输入流
     * @param signature 签名
     * @param key       密钥
     * @return 签名
     * @throws Exception 签名异常
     */
    boolean verify(InputStream in, byte[] signature, byte[] key) throws Exception;

}
