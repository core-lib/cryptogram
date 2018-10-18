package io.codex.cryptogram.signature;

import java.io.InputStream;
import java.security.MessageDigest;

/**
 * Message Digest签名提供器
 *
 * @author 杨昌沛 646742615@qq.com
 * 2018/10/18
 */
public class MDSignatureProvider extends AbstractSignatureProvider {
    private final String algorithm;
    private final int bufferSize;

    public MDSignatureProvider(String algorithm) {
        this(algorithm, 1024);
    }

    public MDSignatureProvider(String algorithm, int bufferSize) {
        this.algorithm = algorithm;
        this.bufferSize = bufferSize;
    }

    public String algorithm() {
        return algorithm;
    }

    public byte[] sign(InputStream in, byte[] key) throws Exception {
        MessageDigest md = MessageDigest.getInstance(algorithm);
        byte[] buf = new byte[bufferSize];
        int len;
        while ((len = in.read(buf)) != -1) md.update(buf, 0, len);
        md.update(key);
        return md.digest();
    }
}
