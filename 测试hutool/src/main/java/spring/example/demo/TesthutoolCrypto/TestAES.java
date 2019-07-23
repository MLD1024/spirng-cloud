package spring.example.demo.TesthutoolCrypto;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
import cn.hutool.crypto.symmetric.SymmetricCrypto;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

/**
 * 〈测试aes加密〉
 *
 * @author LZ
 * @create 2019/7/22
 * @since 1.0.0
 */
public class TestAES {

    private byte[] key = null;
    String content = "test中文";
    // 构建
    private SymmetricCrypto aes = null;

    @Before
    public void init() {
        key = SecureUtil.generateKey(
                SymmetricAlgorithm.AES.getValue(),
                "dcfdde909acb47b9d4ed618e8642e3ee".getBytes()
        ).getEncoded();
        aes = new SymmetricCrypto(SymmetricAlgorithm.AES, key);
    }

    @Test
    public void encrypt() {
        String s = aes.encryptBase64(content);
        System.out.println(s);
    }

    @Test
    public void testSize() {
        key = SecureUtil.generateKey(
                SymmetricAlgorithm.AES.getValue(),
                "dcfdde909acb47b9d4ed618e8642e3e".getBytes()
        ).getEncoded();
        System.out.println(key.length);
    }


    @Test
    public void testSecureUtil() {
        //随机生成密钥
        byte[] key = SecureUtil.generateKey(SymmetricAlgorithm.AES.getValue()).getEncoded();
        System.out.println(key.length);
    }
    @Test
    public void testAesLoginUtil() throws Exception {
        String estr= SecureUtil.aes("dcfdde909acb47b9d4ed618e8642e3ee".getBytes()).encryptHex(content);
//        String estr = aes.encryptHex(content);
        String estr2= AesLoginUtil.encrypt(content, "dcfdde909acb47b9d4ed618e8642e3ee" );
        String dstr= AesLoginUtil.decrypt(estr, "dcfdde909acb47b9d4ed618e8642e3ee" );
        System.out.println(dstr);
    }


    @Test
    public void testAes() throws Exception {
        String estr= SecureUtil.aes("dcfdde909acb47b9d4ed618e8642e3ee".getBytes()).encryptHex(content);
        String s = AesLoginUtil.encrypt("19945722178", "wechat-mobile-201604" );
        System.out.println(s);
        System.out.println(estr);
    }



}
