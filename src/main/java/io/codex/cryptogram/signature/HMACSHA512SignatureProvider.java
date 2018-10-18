package io.codex.cryptogram.signature;

/**
 * HmacSHA512签名提供器
 *
 * @author 杨昌沛 646742615@qq.com
 * 2018/10/17
 */
public class HMACSHA512SignatureProvider extends HMACSignatureProvider {

    public HMACSHA512SignatureProvider() {
        super("HmacSHA512");
    }

}
