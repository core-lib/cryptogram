package io.codex.cryptogram.signature;

/**
 * SHA256WithRSA签名器
 *
 * @author 杨昌沛 646742615@qq.com
 * 2018/10/17
 */
public class SHA256WithRSASignatureProvider extends RSASignatureProvider {

    public SHA256WithRSASignatureProvider() {
        super("SHA256WithRSA");
    }
}
