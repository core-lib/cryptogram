package io.codex.cryptogram;

import io.codex.cryptogram.codec.Base64Codec;
import io.codex.cryptogram.codec.Codec;
import io.codex.cryptogram.codec.HexCodec;
import io.codex.cryptogram.flatting.DefaultFlattingProvider;
import io.codex.cryptogram.signature.SHA256WithRSASignatureProvider;
import io.codex.cryptogram.verification.SHA256WithRSAVerificationProvider;

import java.security.KeyPair;
import java.security.KeyPairGenerator;

/**
 * 测试类
 *
 * @author 杨昌沛 646742615@qq.com
 * 2018/10/18
 */
public class Test {

    @org.junit.Test
    public void test() throws Exception {
        Cryptography cryptography = new Cryptography(
                new HexCodec(),
                new Base64Codec(),
                new DefaultFlattingProvider(),
                new SHA256WithRSASignatureProvider(),
                new SHA256WithRSAVerificationProvider()
        );

        Codec codec = new Base64Codec();

        KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
        generator.initialize(1024);
        KeyPair keyPair = generator.generateKeyPair();
        String publicKey = codec.encode(keyPair.getPublic().getEncoded());
        String privateKey = codec.encode(keyPair.getPrivate().getEncoded());

        String signature = cryptography.sign("message", privateKey);
        System.out.println(signature);
        boolean verified = cryptography.verify("message", signature, publicKey);
        System.out.println(verified);
    }

}
