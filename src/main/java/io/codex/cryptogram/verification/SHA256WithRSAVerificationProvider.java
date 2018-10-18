package io.codex.cryptogram.verification;

/**
 * SHA256WithRSA验证提供器
 *
 * @author 杨昌沛 646742615@qq.com
 * 2018/10/17
 */
public class SHA256WithRSAVerificationProvider extends RSAVerificationProvider {

    public SHA256WithRSAVerificationProvider() {
        super("SHA256WithRSA");
    }

}
