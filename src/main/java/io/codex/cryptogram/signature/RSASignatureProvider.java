package io.codex.cryptogram.signature;

import java.io.InputStream;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;

/**
 * RSA算法签名器
 *
 * @author 杨昌沛 646742615@qq.com
 * 2018/10/17
 */
public class RSASignatureProvider extends AbstractSignatureProvider {
    private final String algorithm;
    private final int bufferSize;

    public RSASignatureProvider(String algorithm) {
        this(algorithm, 1024);
    }

    public RSASignatureProvider(String algorithm, int bufferSize) {
        this.algorithm = algorithm;
        this.bufferSize = bufferSize;
    }

    public String algorithm() {
        return algorithm;
    }

    public byte[] sign(InputStream in, byte[] key) throws Exception {
        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(key);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PrivateKey privateKey = keyFactory.generatePrivate(spec);

        Signature signature = Signature.getInstance(algorithm);
        signature.initSign(privateKey);

        byte[] buf = new byte[bufferSize];
        int len;
        while ((len = in.read(buf)) != -1) signature.update(buf, 0, len);

        return signature.sign();
    }

}
