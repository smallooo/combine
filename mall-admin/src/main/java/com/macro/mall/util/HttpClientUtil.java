package com.macro.mall.util;

import org.apache.http.client.HttpClient;

import java.io.UnsupportedEncodingException;


public class HttpClientUtil {
//    private static String CHAR_ENCODING = "UTF-8";
//    public static String send(String webUrl, String xmlFile, String charset) throws UnsupportedEncodingException {
//        StringBuffer sBuffer = new StringBuffer();
//        // 构造HttpClient的实例
//        HttpClient httpClient = new HttpClient();
//        // 创建POS方法的实例
//        PostMethod postMethod = new PostMethod(webUrl);
//        postMethod.setRequestHeader("Content-Type","application/json");
//        postMethod.setRequestHeader("charset",charset);
//        postMethod.setRequestEntity(new StringRequestEntity(xmlFile, "application/json", charset));
//        postMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler());
//        postMethod.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 60000*100);
//        postMethod.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, 60000*100);
//        try {
//            // 执行getMethod
//            int statusCode = httpClient.executeMethod(postMethod);
//            if (statusCode != HttpStatus.SC_OK) {
//                System.err.println("Method failed: " + postMethod.getStatusLine());
//            }
//            // 读取内容
//            byte[] responseBody = postMethod.getResponseBody();
//            // 处理内容
//            sBuffer.append(new String(responseBody, "UTF-8"));
//        } catch (HttpException e) {
//            // 发生致命的异常，可能是协议不对或者返回的内容有问题
//            System.out.println("Please check your provided http address!");
//            e.printStackTrace();
//        } catch (IOException e) {
//            // 发生网络异常
//            e.printStackTrace();
//        } finally {
//            // 释放连接
//            postMethod.releaseConnection();
//        }
//        return sBuffer.toString();
//    }
//
//    public static void main(String[] args) throws InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException, BadPaddingException, IllegalBlockSizeException, IllegalStateException {
//        //加密KEY
//        String desKey = "lOC7BdYsQP8v9VXgzofJiaiX";
//
//        String payerName = HttpClientUtil.encode(desKey,"张三峰");
//        String idCardNo = HttpClientUtil.encode(desKey,"410521199310128511");
//        String cardNo = HttpClientUtil.encode(desKey,"6226220282587115");
//        System.out.println("payerName="+payerName);
//        System.out.println("idCardNo="+idCardNo);
//        System.out.println("cardNo="+cardNo);
//    }
//
//    /**
//     * Base64编码
//     * @param key
//     * @param data
//     * @return
//     */
//    public static String encode(String key, String data) {
//        try {
//            byte[] keyByte = key.getBytes(CHAR_ENCODING);
//            byte[] dataByte = data.getBytes(CHAR_ENCODING);
//            byte[] valueByte = HttpClientUtil.des3Encryption(keyByte, dataByte);
//            String value = new String(Base64Util.encode(valueByte).getBytes(), CHAR_ENCODING);
//            return value;
//        } catch (Exception e) {
//            return null;
//        }
//    }
//
//    /**
//     * des3Encryption加密
//     * @param key
//     * @param data
//     * @return
//     * @throws NoSuchPaddingException
//     * @throws NoSuchAlgorithmException
//     * @throws InvalidKeyException
//     * @throws BadPaddingException
//     * @throws IllegalBlockSizeException
//     * @throws IllegalStateException
//     */
//    public static byte[] des3Encryption(byte[] key, byte[] data) throws
//            NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException,
//            BadPaddingException, IllegalBlockSizeException, IllegalStateException {
//        final String Algorithm = "DESede";
//
//        SecretKey deskey = new SecretKeySpec(key, Algorithm);
//
//        Cipher c1 = Cipher.getInstance(Algorithm);
//        c1.init(Cipher.ENCRYPT_MODE, deskey);
//        return c1.doFinal(data);
//    }
//
//    /**
//     * 封装HTTP POST方法
//     * @param
//     * @param
//     * @return
//     * @throws ClientProtocolException
//     * @throws java.io.IOException
//     */
//    public static String post(String url, Map paramMap) throws ClientProtocolException, IOException {
//        DefaultHttpClient httpClient = new DefaultHttpClient();
//        /** 忽略SSL证书校验*/
//        try {
//            //Secure Protocol implementation.
//            SSLContext ctx = SSLContext.getInstance("SSL");
//            //Implementation of a trust manager for X509 certificates
//            X509TrustManager tm = new X509TrustManager() {
//                public void checkClientTrusted(X509Certificate[] xcs,
//                                               String string) throws CertificateException {
//                }
//                public void checkServerTrusted(X509Certificate[] xcs,
//                                               String string) throws CertificateException {
//                }
//                public X509Certificate[] getAcceptedIssuers() {
//                    return null;
//                }
//            };
//            ctx.init(null, new TrustManager[] { tm }, null);
//            SSLSocketFactory ssf = new SSLSocketFactory(ctx);
//            ClientConnectionManager ccm = httpClient.getConnectionManager();
//            //register https protocol in httpclient's scheme registry
//            SchemeRegistry sr = ccm.getSchemeRegistry();
//            sr.register(new Scheme("https", 443, ssf));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        HttpPost httpPost = new HttpPost(url);
//        List<NameValuePair> formparams = setHttpParams(paramMap);
//        UrlEncodedFormEntity param = new UrlEncodedFormEntity(formparams, HTTP.UTF_8);
//        httpPost.setEntity(param);
//        HttpResponse response = httpClient.execute(httpPost);
//        String httpEntityContent = getHttpEntityContent(response);
//        httpPost.abort();
//        return httpEntityContent;
//    }
//
//    /**
//     * 设置请求参数
//     * @param
//     * @return
//     */
//    private static List<NameValuePair> setHttpParams(Map<String, String> paramMap) {
//        List<NameValuePair> formparams = new ArrayList<NameValuePair>();
//        Set<Map.Entry<String, String>> set = paramMap.entrySet();
//        for (Map.Entry<String, String> entry : set) {
//            formparams.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
//        }
//        return formparams;
//    }
//
//    /**
//     * 获得响应HTTP实体内容
//     * @param response
//     * @return
//     * @throws java.io.IOException
//     * @throws java.io.UnsupportedEncodingException
//     */
//    private static String getHttpEntityContent(HttpResponse response) throws IOException, UnsupportedEncodingException {
//        HttpEntity entity = response.getEntity();
//        if (entity != null) {
//            InputStream is = entity.getContent();
//            BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
//            String line = br.readLine();
//            StringBuilder sb = new StringBuilder();
//            while (line != null) {
//                sb.append(line + "\n");
//                line = br.readLine();
//            }
//            return sb.toString();
//        }
//        return "";
//    }
//
//
//
//
//
//    /**
//     * 向指定 URL 发送POST方法的请求 JSON参数
//     *
//     * @param url
//     *            发送请求的 URL
//     * @param param
//     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
//     * @return 所代表远程资源的响应结果
//     */
//    public static String sendJsonPost(String url, String param)
//    {
//        PrintWriter out = null;
//        BufferedReader in = null;
//        String result = "";
//        try
//        {
//            URL realUrl = new URL(url);
//            // 打开和URL之间的连接
//            URLConnection conn = realUrl.openConnection();
//            // 设置通用的请求属性
//            conn.setRequestProperty("accept", "*/*");
//            conn.setRequestProperty("connection", "Keep-Alive");
//            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
//            conn.setRequestProperty("Content-Type", "application/json; charset=utf-8");
//            // 发送POST请求必须设置如下两行
//            conn.setDoOutput(true);
//            conn.setDoInput(true);
//            // 获取URLConnection对象对应的输出流
//            out = new PrintWriter(conn.getOutputStream());
//            // 发送请求参数
//            out.print(param);
//            // flush输出流的缓冲
//            out.flush();
//            // 定义BufferedReader输入流来读取URL的响应
//            in = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
//            String line;
//            while ((line = in.readLine()) != null)
//            {
//                result += line;
//            }
//        }
//        catch (Exception e)
//        {
//            System.out.println("发送 POST 请求出现异常！" + e);
//            e.printStackTrace();
//        }
//        // 使用finally块来关闭输出流、输入流
//        finally
//        {
//            try
//            {
//                if (out != null)
//                {
//                    out.close();
//                }
//                if (in != null)
//                {
//                    in.close();
//                }
//            }
//            catch (IOException ex)
//            {
//                ex.printStackTrace();
//            }
//        }
//        return result;
//    }
}
