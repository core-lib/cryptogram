package io.codex.cryptogram.verification;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.InputStream;
import java.util.Arrays;

/**
 * HMAC签名器
 *
 * @author 杨昌沛 646742615@qq.com
 * 2018/10/17
 */
public class HMACVerificationProvider extends AbstractVerificationProvider {
    private final String algorithm;
    private final int bufferSize;

    public HMACVerificationProvider(String algorithm) {
        this(algorithm, 1024);
    }

    public HMACVerificationProvider(String algorithm, int bufferSize) {
        this.algorithm = algorithm;
        this.bufferSize = bufferSize;
    }

    public String algorithm() {
        return algorithm;
    }

    public boolean verify(InputStream in, byte[] signature, byte[] key) throws Exception {
        Mac mac = Mac.getInstance(algorithm);
        SecretKeySpec secretKey = new SecretKeySpec(key, algorithm);
        mac.init(secretKey);
        byte[] buf = new byte[bufferSize];
        int len;
        while ((len = in.read(buf)) != -1) mac.update(buf, 0, len);
        byte[] s = mac.doFinal();
        return Arrays.equals(s, signature);
    }
}
