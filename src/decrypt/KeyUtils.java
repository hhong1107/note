package com.fincar.base.utile.tool;

import com.google.common.base.Strings;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;

/**
 * @author ljhong
 * @since 15/5/31 下午7:06
 */
public class KeyUtils {


    public PublicKey getPublicKey(File publicKeyPathFile) {
        try {
            FileInputStream in = new FileInputStream(publicKeyPathFile);
            return getPublicKey(in);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("初始化证书异常", e);
        }
    }


    public PublicKey getPublicKey(String publicKeyPath) {
        if (!publicKeyPath.startsWith("/"))
            publicKeyPath = "/" + publicKeyPath;
        publicKeyPath = getClass().getResource(publicKeyPath).getPath();
        File file = new File(publicKeyPath);
        return getPublicKey(file);
    }


    public PublicKey getPublicKey(InputStream in) {
        try {
            try {
                CertificateFactory certificateFactory = CertificateFactory
                        .getInstance("X.509");
                Certificate certificate = certificateFactory.generateCertificate(in);
                return certificate.getPublicKey();
            } finally {
                if (in != null) in.close();
            }
        } catch (Exception e) {
            throw new RuntimeException("初始化秘钥异常", e);
        }
    }

    public PrivateKey getPrivateKey(File keyStoreFile, String password, String alias) {
        try {
            return getPrivateKey(new FileInputStream(keyStoreFile), password, alias);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("初始化秘钥异常", e);
        }
    }

    public PrivateKey getPrivateKey(String keyStorePath, String password, String alias) {
        try {
            FileInputStream in = null;
            try {
                if (!keyStorePath.startsWith("/"))
                    keyStorePath = "/" + keyStorePath;
                keyStorePath = getClass().getResource(keyStorePath).getPath();
                in = new FileInputStream(keyStorePath);
                return getPrivateKey(in, password, alias);
            } finally {
                if (null != in) in.close();
            }
        } catch (Exception e) {
            throw new RuntimeException("初始化秘钥异常", e);
        }
    }

    public PrivateKey getPrivateKey(InputStream keyStoreIO, String password, String alias) {

        PrivateKey privateKey = null;
        try {
            KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());
            ks.load(keyStoreIO, password.toCharArray());
            if (Strings.isNullOrEmpty(alias)) {
                privateKey = (PrivateKey) ks.getKey(ks.aliases().nextElement(), password.toCharArray());
            } else {
                privateKey = (PrivateKey) ks.getKey(alias, password.toCharArray());
            }
        } catch (Exception e) {
            throw new RuntimeException("初始化秘钥异常", e);
        }
        return privateKey;
    }
}
