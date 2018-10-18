package io.codex.cryptogram.verification;

import java.io.InputStream;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;

/**
 * RSA算法验证提供器
 *
 * @author 杨昌沛 646742615@qq.com
 * 2018/10/17
 */
public class RSAVerificationProvider extends AbstractVerificationProvider {
    private final String algorithm;
    private final int bufferSize;

    public RSAVerificationProvider(String algorithm) {
        this(algorithm, 1024);
    }

    public RSAVerificationProvider(String algorithm, int bufferSize) {
        this.algorithm = algorithm;
        this.bufferSize = bufferSize;
    }

    public String algorithm() {
        return algorithm;
    }

    public boolean verify(InputStream in, byte[] signature, byte[] key) throws Exception {
        X509EncodedKeySpec spec = new X509EncodedKeySpec(key);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PublicKey publicKey = keyFactory.generatePublic(spec);

        Signature s = Signature.getInstance(algorithm);
        s.initVerify(publicKey);

        byte[] buf = new byte[bufferSize];
        int len;
        while ((len = in.read(buf)) != -1) s.update(buf, 0, len);

        return s.verify(signature);
    }
}
