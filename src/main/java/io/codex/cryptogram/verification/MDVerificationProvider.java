package io.codex.cryptogram.verification;

import java.io.InputStream;
import java.security.MessageDigest;
import java.util.Arrays;

/**
 * HMAC签名器
 *
 * @author 杨昌沛 646742615@qq.com
 * 2018/10/17
 */
public class MDVerificationProvider extends AbstractVerificationProvider {
    private final String algorithm;
    private final int bufferSize;

    public MDVerificationProvider(String algorithm) {
        this(algorithm, 1024);
    }

    public MDVerificationProvider(String algorithm, int bufferSize) {
        this.algorithm = algorithm;
        this.bufferSize = bufferSize;
    }

    public String algorithm() {
        return algorithm;
    }

    public boolean verify(InputStream in, byte[] signature, byte[] key) throws Exception {
        MessageDigest md = MessageDigest.getInstance(algorithm);
        byte[] buf = new byte[bufferSize];
        int len;
        while ((len = in.read(buf)) != -1) md.update(buf, 0, len);
        md.update(key);
        byte[] digest = md.digest();
        return Arrays.equals(digest, signature);
    }
}
