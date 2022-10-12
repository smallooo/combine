package com.macro.mall.util;

//public class HttpsUtil {
//    private static final Log log = LogFactory.getLog(HttpsUtil.class);
//
//    private static class MyTrustManager implements X509TrustManager {
//        public void checkClientTrusted(X509Certificate[] chain, String authType)
//                throws CertificateException {
//        }
//
//        public void checkServerTrusted(X509Certificate[] chain, String authType)
//                throws CertificateException {
//        }
//
//        public X509Certificate[] getAcceptedIssuers() {
//            return new X509Certificate[] {};
//        }
//    }
//
//    private static class MyHostnameVerifier implements HostnameVerifier {
//        public boolean verify(String hostname, SSLSession session) {
//            return true;
//        }
//    }
//
//
//
//
//
//
//
//    /**
//     *
//     * HTTP协议POST请求方法
//     */
//    public static String httpMethodPost(String url,
//                                        TreeMap<String, String> paramsMap, String gb) {
//        if (null == gb || "".equals(gb)) {
//            gb = "UTF-8";
//        }
//        String params = null;
//        if (null != paramsMap) {
//            params = HttpUtils.getParamStr(paramsMap);
//        }
//        System.out.println("====post请求参数= "+params);
//        StringBuffer sb = new StringBuffer();
//        URL urls;
//        HttpsURLConnection uc = null;
//        BufferedReader in = null;
//        try {
//            SSLContext sc = SSLContext.getInstance("SSL");
//            sc.init(null, new TrustManager[] { new MyTrustManager() },
//                    new java.security.SecureRandom());
//            urls = new URL(url);
//            uc = (HttpsURLConnection) urls.openConnection();
//            uc.setSSLSocketFactory(sc.getSocketFactory());
//            uc.setHostnameVerifier(new MyHostnameVerifier());
//            uc.setRequestMethod("POST");
//            uc.setDoOutput(true);
//            uc.setDoInput(true);
//            uc.setUseCaches(false);
//            uc.setRequestProperty("Content-Type",
//                    "application/x-www-form-urlencoded");
//            uc.connect();
//            DataOutputStream out = new DataOutputStream(uc.getOutputStream());
//            out.write(params.getBytes(gb));
//            out.flush();
//            out.close();
//            in = new BufferedReader(new InputStreamReader(uc.getInputStream(),
//                    gb));
//            String readLine = "";
//            while ((readLine = in.readLine()) != null) {
//                sb.append(readLine);
//            }
//            if (in != null) {
//                in.close();
//            }
//            if (uc != null) {
//                uc.disconnect();
//            }
//        } catch (Exception e) {
//            log.error(e.getMessage(), e);
//        } finally {
//            if (uc != null) {
//                uc.disconnect();
//            }
//        }
//        return URLDecoder.decode(sb.toString());
//    }
//
//    public static String httpMethodPostGZIP(String url,
//                                            TreeMap<String, String> paramsMap, String gb) {
//        System.out.println("===url：" + url);
//        if (null == gb || "".equals(gb)) {
//            gb = "UTF-8";
//        }
//        String params = null;
//        if (null != paramsMap) {
//            params = HttpUtils.getParamStr(paramsMap);
//        }
//
//        StringBuffer sb = new StringBuffer();
//        URL urls;
//        HttpsURLConnection uc = null;
//        BufferedReader in = null;
//        try {
//            SSLContext sc = SSLContext.getInstance("SSL");
//            sc.init(null, new TrustManager[] { new MyTrustManager() },
//                    new java.security.SecureRandom());
//            urls = new URL(url);
//            uc = (HttpsURLConnection) urls.openConnection();
//            uc.setSSLSocketFactory(sc.getSocketFactory());
//            uc.setHostnameVerifier(new MyHostnameVerifier());
//            uc.setRequestMethod("POST");
//            uc.setDoOutput(true);
//            uc.setDoInput(true);
//            uc.setUseCaches(false);
//            uc.setRequestProperty("Content-Type",
//                    "application/x-www-form-urlencoded");
//            uc.connect();
//            DataOutputStream out = new DataOutputStream(uc.getOutputStream());
//            out.write(params.getBytes(gb));
//            out.flush();
//            out.close();
//            in = new BufferedReader(new InputStreamReader(new GZIPInputStream(uc.getInputStream()),
//                    gb));
//            String readLine = "";
//            while ((readLine = in.readLine()) != null) {
//                sb.append(readLine).append("\n");
//            }
//            if (in != null) {
//                in.close();
//            }
//            if (uc != null) {
//                uc.disconnect();
//            }
//        } catch (Exception e) {
//            log.error(e.getMessage(), e);
//        } finally {
//            if (uc != null) {
//                uc.disconnect();
//            }
//        }
//        return sb.toString();
//    }
//
//
//
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
//        HttpClient httpClient = new DefaultHttpClient();
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
//     * 封装HTTP POST方法
//     * @param
//     * @param （如JSON串）
//     * @return
//     * @throws ClientProtocolException
//     * @throws java.io.IOException
//     */
//    public static String post(String url, String data) throws ClientProtocolException, IOException {
//        return post(url, data, true);
//    }
//
//    public static String post(String url, String data,boolean isencoder) throws ClientProtocolException, IOException {
//        HttpClient httpClient = new DefaultHttpClient();
//        HttpPost httpPost = new HttpPost(url);
//        httpPost.setHeader("Content-Type","text/json; charset=utf-8");
//        if(isencoder){
//            httpPost.setEntity(new StringEntity(URLEncoder.encode(data, "UTF-8")));
//        }else {
//            httpPost.setEntity(new StringEntity(data));
//        }
//        HttpResponse response = httpClient.execute(httpPost);
//        String httpEntityContent = getHttpEntityContent(response);
//        httpPost.abort();
//        return httpEntityContent;
//    }
//
//    /**
//     * 封装HTTP GET方法
//     * @param
//     * @return
//     * @throws ClientProtocolException
//     * @throws java.io.IOException
//     */
//    public static String get(String url) throws ClientProtocolException, IOException {
//        HttpClient httpClient = new DefaultHttpClient();
//        HttpGet httpGet = new HttpGet();
//        httpGet.setURI(URI.create(url));
//        HttpResponse response = httpClient.execute(httpGet);
//        String httpEntityContent = getHttpEntityContent(response);
//        httpGet.abort();
//        return httpEntityContent;
//    }
//
//    /**
//     * 封装HTTP GET方法
//     * @param
//     * @param
//     * @return
//     * @throws ClientProtocolException
//     * @throws java.io.IOException
//     */
//    public static String get(String url, Map<String, String> paramMap) throws ClientProtocolException, IOException {
//        HttpClient httpClient = new DefaultHttpClient();
//        HttpGet httpGet = new HttpGet();
//        List<NameValuePair> formparams = setHttpParams(paramMap);
//        String param = URLEncodedUtils.format(formparams, "UTF-8");
//        httpGet.setURI(URI.create(url + "?" + param));
//        HttpResponse response = httpClient.execute(httpGet);
//        String httpEntityContent = getHttpEntityContent(response);
//        httpGet.abort();
//        return httpEntityContent;
//    }
//
//    /**
//     * 封装HTTP PUT方法
//     * @param
//     * @param
//     * @return
//     * @throws ClientProtocolException
//     * @throws java.io.IOException
//     */
//    public static String put(String url, Map<String, String> paramMap) throws ClientProtocolException, IOException {
//        HttpClient httpClient = new DefaultHttpClient();
//        HttpPut httpPut = new HttpPut(url);
//        List<NameValuePair> formparams = setHttpParams(paramMap);
//        UrlEncodedFormEntity param = new UrlEncodedFormEntity(formparams, "UTF-8");
//        httpPut.setEntity(param);
//        HttpResponse response = httpClient.execute(httpPut);
//        String httpEntityContent = getHttpEntityContent(response);
//        httpPut.abort();
//        return httpEntityContent;
//    }
//
//    /**
//     * 封装HTTP DELETE方法
//     * @param
//     * @return
//     * @throws ClientProtocolException
//     * @throws java.io.IOException
//     */
//    public static String delete(String url) throws ClientProtocolException, IOException {
//        HttpClient httpClient = new DefaultHttpClient();
//        HttpDelete httpDelete= new HttpDelete();
//        httpDelete.setURI(URI.create(url));
//        HttpResponse response = httpClient.execute(httpDelete);
//        String httpEntityContent = getHttpEntityContent(response);
//        httpDelete.abort();
//        return httpEntityContent;
//    }
//
//    /**
//     * 封装HTTP DELETE方法
//     * @param
//     * @param
//     * @return
//     * @throws ClientProtocolException
//     * @throws java.io.IOException
//     */
//    public static String delete(String url, Map<String, String> paramMap) throws ClientProtocolException, IOException {
//        HttpClient httpClient = new DefaultHttpClient();
//        HttpDelete httpDelete = new HttpDelete();
//        List<NameValuePair> formparams = setHttpParams(paramMap);
//        String param = URLEncodedUtils.format(formparams, "UTF-8");
//        httpDelete.setURI(URI.create(url + "?" + param));
//        HttpResponse response = httpClient.execute(httpDelete);
//        String httpEntityContent = getHttpEntityContent(response);
//        httpDelete.abort();
//        return httpEntityContent;
//    }
//
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
//    /**
//     * 向指定URL发送GET方法的请求
//     *
//     * @param url
//     *            发送请求的URL
//     * @param param
//     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
//     * @return URL 所代表远程资源的响应结果
//     */
//    public static String sendGet(String url, String param)
//    {
//        String result = "";
//        BufferedReader in = null;
//        try
//        {
//            String urlNameString = url + "?" + param;
//            URL realUrl = new URL(urlNameString);
//            // 打开和URL之间的连接
//            URLConnection connection = realUrl.openConnection();
//            // 设置通用的请求属性
//            connection.setRequestProperty("accept", "*/*");
//            connection.setRequestProperty("connection", "Keep-Alive");
//            connection.setRequestProperty("user-agent",
//                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
//            // 建立实际的连接
//            connection.connect();
//            // 获取所有响应头字段
//            Map<String, List<String>> map = connection.getHeaderFields();
//            // 遍历所有的响应头字段
//            for (String key : map.keySet())
//            {
//                System.out.println(key + "--->" + map.get(key));
//            }
//            // 定义 BufferedReader输入流来读取URL的响应
//            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//            String line;
//            while ((line = in.readLine()) != null)
//            {
//                result += line;
//            }
//        }
//        catch (Exception e)
//        {
//            System.out.println("发送GET请求出现异常！" + e);
//            e.printStackTrace();
//        }
//        // 使用finally块来关闭输入流
//        finally
//        {
//            try
//            {
//                if (in != null)
//                {
//                    in.close();
//                }
//            }
//            catch (Exception e2)
//            {
//                e2.printStackTrace();
//            }
//        }
//        return result;
//    }
//
//    /**
//     * 向指定 URL 发送POST方法的请求
//     *
//     * @param url
//     *            发送请求的 URL
//     * @param param
//     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
//     * @return 所代表远程资源的响应结果
//     */
//    public static String sendPost(String url, String param)
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
//
//}
