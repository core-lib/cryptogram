package io.codex.cryptogram.signature;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.InputStream;

/**
 * HMAC签名器
 *
 * @author 杨昌沛 646742615@qq.com
 * 2018/10/17
 */
public class HMACSignatureProvider extends AbstractSignatureProvider {
    private final String algorithm;
    private final int bufferSize;

    public HMACSignatureProvider(String algorithm) {
        this(algorithm, 1024);
    }

    public HMACSignatureProvider(String algorithm, int bufferSize) {
        this.algorithm = algorithm;
        this.bufferSize = bufferSize;
    }

    public String algorithm() {
        return algorithm;
    }

    public byte[] sign(InputStream in, byte[] key) throws Exception {
        Mac mac = Mac.getInstance(algorithm);
        SecretKeySpec secretKey = new SecretKeySpec(key, algorithm);
        mac.init(secretKey);
        byte[] buf = new byte[bufferSize];
        int len;
        while ((len = in.read(buf)) != -1) mac.update(buf, 0, len);
        return mac.doFinal();
    }
}
