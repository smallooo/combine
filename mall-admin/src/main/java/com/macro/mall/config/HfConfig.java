package com.macro.mall.config;


import com.huifu.bspay.sdk.opps.core.BasePay;
import com.huifu.bspay.sdk.opps.core.config.MerConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HfConfig {

    @Bean
    public static void initMerchantConfig() {
        BasePay.debug = true;
        BasePay.prodMode = BasePay.MODE_PROD;
        MerConfig merConfig = new MerConfig();
        merConfig.setProcutId("EDUSTD");      //汇付分配产品号
        merConfig.setSysId("6666000122751000");         //汇付分配系统号  渠道号
        merConfig.setRsaPrivateKey("MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQC53vb85DPQPKI9tvazG2f3O6qt2Dm5tGoEaPwKucOxJnD/ztVe5z+jU2+8GMFEyD1SwFDMISWp2P24/E5XWMVOPCb7ArtBxeet3QWu1uzOTZSIKrt0013dsmc4df/SwWSZVU8DaHmL0x5hY60QUmzul3D+jC8akC4D92DqWwFivCORjvNz0sTbo0ExsNsQEtZdsIg+SjBvPbDvxdN3Z89ZdGt8R3V6IYll6gEzMyvYD3T5NtzEjCnAzrA8MtEiRtqAJ99VhHI08cMP5qEKA3bjRJArxuplNgWEFyBMuAJHSJQTSvY9zM/VO38BjYDB60WZxo5RO5TtsDJRiDDjtkCtAgMBAAECggEAVwSVqUvFHiZk5nO0B6I7CDo86+qhC9n1EF9+MB9MCLGwkXJp3mZxGqvDUdJdGTCN1SIIMakLEvttvZ8Rpj7/EGOE9FsRA/f9QR6KvJIOh382nJE09brG5TXSsVI9FJRJ3qdbuIK+9MFAJeQeb9fG++SWl/VVUCBUCrNUAiPdADW8KD9Kx3ufCu6vkFPZTRMuq/U43Kvp2SLE59OG4lPywvTbhbJRTWrNUk3xv+S3RRSLXYKJz0ysE/F/XYh9DjWtPLgbyZSxzB51r4vdlQKaoULIanir8fWIAGlDtvvdcsTm4wnmI6rSCc0YMTEX+o17kWqzG6q7TZupUPD33a9UAQKBgQDiDtjmWAExmmAoXS923i+tl3MdMBkBeXoYrJOnc5Dkru4w5HOo38YseOKTJcqg/TgiRIxX4qu5W+9pN5QxgOYVjXPhp+gqn0dxiSsdyS80+SRmImHUlbDSc40/xXZjTvr1KkwkdnBMqz3mdK6GgjddXyU34LYJQCfim6+dwl3dgQKBgQDSfXWQGPp89MDIGuoB2U6caGy8jqC715rcV3vwyv7fqWBHJ2xHjqiAk9Ml6hxfL5Sv2pSY/eyPKQj31AK+FDKAAm2Q9oNnbxUEzEn2fQ1UwXJm5ssB/14AVe43gCJlOf+LL60gEAKJbuqbFZiY7nCoAj3X8lmqpYxCMEdFh2DRLQKBgHTPqUL1zMAd/nw9Es7ApzBzZxd5CCLb67yeSLopnICe6BQ5qI5l+5h1atcQmzEvR/dlJoQva/8fQ4pCHwCpk7slWfEL+4syvQ8tCyucDxm3eBiSwazBIRrOfPmsBq3wXPucvLXGwebMQfM47goxdXx5Mtk587a6ASI2wrupeSmBAoGAbpQEN9A3f3+g6z7gYlpD5v0g6qnPHP92Vn0LGoO6A8vaTWcThkAWm32NNmTXxNWdOgkNeZYkOU0obfGOA0dfBErCPp6Sh7segqfDz18Aqt75d7+VNJZwTqLWA4goCZ+/dOJ2A9sFSiffzds5kFXrDwgmbxTdMD3KAleUiZ1GKn0CgYAvsRnUeNf1qYUW2oM6vIGyclxkakBW5Ard61x/jvpMwLfiQ+z/upQKr4UBXfOI3FzVSlAGO/yFhJmJ/KKF4gb2KeQTbhfZxCUx6LIuGC8w14a5uOfSo8Z3uPWoyoR5kioKpeKNMH1CkwSd4gQfFXTkA2VY38RxYPmRLYpiaxnX+g==");  //汇付分配私钥
        merConfig.setRsaPublicKey("MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAt5hd0XSAusIkRYMEXv6ZHlCU9XIQsgJWmnarxJamVQ/4hjCeefUoD/PX7cH+pmw6IMhDYLSrbM8Jdcfz4cxZl1cOLEchpYEkRehr6hER1/bJqWTLDDEWzPSWqcwpQLCW70XueJh2LHu/u2EillRUf8RT4aiO4zobujlUhblSgAYI7M8/wH2ehva8rlAQ2go8evhZcWW1WafW5IjmXbYqAyXF/swukG4tTFAXrtwdUVZAT4jJphVfdO0UbxMng4Kv9S/K9Hh+H1mtwb2SKJwAmfTWMt9YVJFk00jPhFJsxqliGxY0TMjb9wC2Y8A1eElZWP4VcWQoKe+Sx1kg37KolQIDAQAB");
        try {
            BasePay.initWithMerConfig(merConfig);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
