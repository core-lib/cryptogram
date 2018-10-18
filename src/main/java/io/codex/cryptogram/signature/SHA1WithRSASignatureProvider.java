package io.codex.cryptogram.signature;

/**
 * SHA1WithRSA签名器
 *
 * @author 杨昌沛 646742615@qq.com
 * 2018/10/17
 */
public class SHA1WithRSASignatureProvider extends RSASignatureProvider {

    public SHA1WithRSASignatureProvider() {
        super("SHA1WithRSA");
    }

}
