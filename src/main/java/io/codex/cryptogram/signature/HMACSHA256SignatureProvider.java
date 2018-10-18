package io.codex.cryptogram.signature;

/**
 * HmacSHA256签名提供器
 *
 * @author 杨昌沛 646742615@qq.com
 * 2018/10/17
 */
public class HMACSHA256SignatureProvider extends HMACSignatureProvider {

    public HMACSHA256SignatureProvider() {
        super("HmacSHA256");
    }

}
