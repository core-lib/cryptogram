package io.codex.cryptogram.verification;

/**
 * HmacSHA256签名提供器
 *
 * @author 杨昌沛 646742615@qq.com
 * 2018/10/17
 */
public class HMACSHA256VerificationProvider extends HMACVerificationProvider {

    public HMACSHA256VerificationProvider() {
        super("HmacSHA256");
    }

}
