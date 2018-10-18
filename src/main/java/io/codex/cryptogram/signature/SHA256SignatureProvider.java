package io.codex.cryptogram.signature;

/**
 * SHA-256算法签名提供器
 *
 * @author 杨昌沛 646742615@qq.com
 * 2018/10/18
 */
public class SHA256SignatureProvider extends MDSignatureProvider {

    public SHA256SignatureProvider() {
        super("SHA-256");
    }
}
