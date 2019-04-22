package com.charles.service;

import com.charles.result.SingleResult;
import com.charles.utils.RSAUtils;
import com.charles.request.KeyRequest;
import com.charles.response.KeyResponse;
import com.charles.response.RSAResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class EncryptOpenService{

    @Value("${rsa.publicKey}")
    private String publicKey;
    @Value("${rsa.privateKey}")
    private String privateKey;
    @Value("${api.encrypt.key}")
    private String key;

    public SingleResult<RSAResponse> getRSA() {
        RSAResponse response = RSAResponse.options()
                .setServerPublicKey(publicKey)
                .build();
        return SingleResult.buildSuccess(response);
    }

    public SingleResult<KeyResponse> getKey(KeyRequest request)throws Exception {
        String clientPublicKey = RSAUtils.privateDecrypt(request.getClientEncryptPublicKey(), RSAUtils.getPrivateKey(privateKey));
        String encryptKey = RSAUtils.publicEncrypt(key,RSAUtils.getPublicKey(clientPublicKey));
        KeyResponse response = KeyResponse.options()
                .setKey(encryptKey)
                .build();
        return SingleResult.buildSuccess(response);
    }
}
