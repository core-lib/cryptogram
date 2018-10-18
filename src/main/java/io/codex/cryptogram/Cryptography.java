package io.codex.cryptogram;

import io.codex.cryptogram.codec.Base64Codec;
import io.codex.cryptogram.codec.Codec;
import io.codex.cryptogram.codec.HexCodec;
import io.codex.cryptogram.flatting.DefaultFlattingProvider;
import io.codex.cryptogram.flatting.FlattingProvider;
import io.codex.cryptogram.signature.MD5WithRSASignatureProvider;
import io.codex.cryptogram.signature.SignatureProvider;
import io.codex.cryptogram.verification.MD5WithRSAVerificationProvider;
import io.codex.cryptogram.verification.VerificationProvider;

/**
 * 密码术
 *
 * @author 杨昌沛 646742615@qq.com
 * 2018/10/17
 */
public class Cryptography {
    private final Codec signCodec;
    private final Codec keyCodec;
    private final FlattingProvider flattingProvider;
    private final SignatureProvider signatureProvider;
    private final VerificationProvider verificationProvider;

    public Cryptography() {
        this(
                new HexCodec(),
                new Base64Codec(),
                new DefaultFlattingProvider(),
                new MD5WithRSASignatureProvider(),
                new MD5WithRSAVerificationProvider()
        );
    }

    public Cryptography(Codec signCodec, Codec keyCodec, FlattingProvider flattingProvider, SignatureProvider signatureProvider, VerificationProvider verificationProvider) {
        this.signCodec = signCodec;
        this.keyCodec = keyCodec;
        this.flattingProvider = flattingProvider;
        this.signatureProvider = signatureProvider;
        this.verificationProvider = verificationProvider;
    }

    public String sign(Object value, String key) throws Exception {
        return sign(value, "", "", key);
    }

    public String sign(Object value, String prefix, String suffix, String key) throws Exception {
        String flatted = flattingProvider.flat(value);
        String message = prefix + flatted + suffix;
        byte[] k = keyCodec.decode(key);
        byte[] sign = signatureProvider.sign(message.getBytes(), k);
        return signCodec.encode(sign);
    }

    public boolean verify(Object value, String signature, String key) throws Exception {
        return verify(value, "", "", signature, key);
    }

    public boolean verify(Object value, String prefix, String suffix, String signature, String key) throws Exception {
        String flatted = flattingProvider.flat(value);
        String message = prefix + flatted + suffix;
        byte[] s = signCodec.decode(signature);
        byte[] k = keyCodec.decode(key);
        return verificationProvider.verify(message.getBytes(), s, k);
    }

    public Codec getSignCodec() {
        return signCodec;
    }

    public Codec getKeyCodec() {
        return keyCodec;
    }

    public FlattingProvider getFlattingProvider() {
        return flattingProvider;
    }

    public SignatureProvider getSignatureProvider() {
        return signatureProvider;
    }

    public VerificationProvider getVerificationProvider() {
        return verificationProvider;
    }

}
