package io.codex.cryptogram.signature;

/**
 * MD5WithRSA 签名器
 *
 * @author 杨昌沛 646742615@qq.com
 * 2018/10/17
 */
public class MD5WithRSASignatureProvider extends RSASignatureProvider {

    public MD5WithRSASignatureProvider() {
        super("MD5WithRSA");
    }

}
