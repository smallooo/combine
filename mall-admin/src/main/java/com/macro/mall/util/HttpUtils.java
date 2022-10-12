package com.macro.mall.util;

//@SuppressWarnings("all")
//public class HttpUtils {
//    private static final Log log = LogFactory.getLog(HttpUtils.class);
//
//    /**
//     *
//     * HTTP协议GET请求方法
//     */
//    public static String httpMethodGet(String url, String gb) {
//        if (null == gb || "".equals(gb)) {
//            gb = "UTF-8";
//        }
//        StringBuffer sb = new StringBuffer();
//        URL urls;
//        HttpURLConnection uc = null;
//        BufferedReader in = null;
//        try {
//            urls = new URL(url);
//            uc = (HttpURLConnection) urls.openConnection();
//            uc.setRequestMethod("GET");
//            uc.connect();
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
//        return sb.toString();
//    }
//
//    public static String post(String url, String body) throws Exception {
//        CloseableHttpClient httpclient = HttpClients.custom().build();
//        HttpPost post = null;
//        String resData = null;
//        CloseableHttpResponse result = null;
//        try {
//            post = new HttpPost(url);
//            post.setConfig(RequestConfig.custom().setConnectTimeout(300000).setSocketTimeout(300000).build());
//            post.setHeader("Content-Type", "application/json");
//            if (body != null) {
//                HttpEntity entity2 = new StringEntity(body, Consts.UTF_8);
//                post.setEntity(entity2);
//            }
//            result = httpclient.execute(post);
//            if (HttpStatus.SC_OK == result.getStatusLine().getStatusCode()) {
//                resData = EntityUtils.toString(result.getEntity());
//            }
//        } finally {
//            if (result != null) {
//                result.close();
//            }
//            if (post != null) {
//                post.releaseConnection();
//            }
//            httpclient.close();
//        }
//        return resData;
//    }
//
//
//    /**
//     *
//     * HTTP协议POST请求方法
//     */
//    public static String httpMethodPost(String url, String params, String gb) {
//        if (null == gb || "".equals(gb)) {
//            gb = "UTF-8";
//        }
//        StringBuffer sb = new StringBuffer();
//        URL urls;
//        HttpURLConnection uc = null;
//        BufferedReader in = null;
//        try {
//            urls = new URL(url);
//            uc = (HttpURLConnection) urls.openConnection();
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
//        } catch (IOException e) {
//            log.error(e.getMessage(), e);
//        } finally {
//            if (uc != null) {
//                uc.disconnect();
//            }
//        }
//        return sb.toString();
//    }
//
//    /**
//     *
//     * HTTP协议POST请求方法
//     */
//    public static String httpMethodPost(String url,
//                                        TreeMap<String, String> paramsMap, String gb) {
//        if (null == gb || "".equals(gb)) {
//            gb = "utf-8";
//        }
//        String params = null;
//        if (null != paramsMap) {
//            params = getParamStr(paramsMap);
//        }
//        System.out.println("====post请求参数= "+params);
//        StringBuffer sb = new StringBuffer();
//        URL urls;
//        HttpURLConnection uc = null;
//        BufferedReader in = null;
//        try {
//            urls = new URL(url);
//            uc = (HttpURLConnection) urls.openConnection();
//            uc.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
//            uc.setDoOutput(true);
//            uc.setDoInput(true);
//            uc.setRequestMethod("POST");
//            uc.setUseCaches(false);
//            uc.connect();
//            DataOutputStream out = new DataOutputStream(uc.getOutputStream());
//            out.write(params.getBytes(gb));
//            out.flush();
//            out.close();
//            InputStream i = uc.getInputStream();
//            in = new BufferedReader(new InputStreamReader(uc.getInputStream(), gb));
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
//        } catch (IOException e) {
//            log.error(e.getMessage(), e);
//        } finally {
//            if (uc != null) {
//                uc.disconnect();
//            }
//        }
//        return sb.toString();
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
//            params = getParamStr(paramsMap);
//        }
//
//        StringBuffer sb = new StringBuffer();
//        URL urls;
//        HttpURLConnection uc = null;
//        BufferedReader in = null;
//        try {
//            urls = new URL(url);
//            uc = (HttpURLConnection) urls.openConnection();
//            uc.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
//            uc.setDoOutput(true);
//            uc.setDoInput(true);
//            uc.setRequestMethod("POST");
//            uc.setUseCaches(false);
//            uc.connect();
//            DataOutputStream out = new DataOutputStream(uc.getOutputStream());
//            out.write(params.getBytes(gb));
//            out.flush();
//            out.close();
//            in = new BufferedReader(new InputStreamReader(new GZIPInputStream(uc.getInputStream()), gb));
//
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
//        } catch (ZipException e) {
//            log.error("暂无数据");
//        } catch (IOException e) {
//            log.error(e.getMessage(), e);
//        } finally {
//            if (uc != null) {
//                uc.disconnect();
//            }
//        }
//        return sb.toString();
//    }
//
//    /**
//     *
//     * HTTP协议POST请求添加参数的封装方法
//     */
//    public static String getParamStr(TreeMap<String, String> paramsMap) {
//        StringBuilder param = new StringBuilder();
//        for (Iterator<Map.Entry<String, String>> it = paramsMap.entrySet()
//                .iterator(); it.hasNext();) {
//            Map.Entry<String, String> e = it.next();
//            param.append("&").append(e.getKey()).append("=")
//                    .append(e.getValue());
//        }
//        return param.toString().substring(1);
//    }
//
//    public static String sendPost(String url, String params) {
//        DataOutputStream out = null;
//        BufferedReader in = null;
//        String result = "";
//        URL realUrl = null;
//        HttpURLConnection con = null;
//        //尝试发送请求
//        try {
//            realUrl = new URL(url);
//            //打开和URL之间的连接
//            con = (HttpURLConnection) realUrl.openConnection();
//            //设置通用的请求属性
//            con.setRequestMethod("POST");
//            con.setRequestProperty("Content-Type", "application/json");
//            con.setUseCaches(false);
//            //发送POST请求必须设置如下两行
//            con.setDoOutput(true);
//            con.setDoInput(true);
//
//            con.connect();
//            out = new DataOutputStream(con.getOutputStream());
//            out.write(params.getBytes("utf-8"));
//            // 刷新、关闭
//            out.flush();
//            out.close();
//            //定义BufferedReader输入流来读取URL的响应
//            in = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"));
//            String line;
//            while ((line = in.readLine()) != null) {
//                result += line;
//            }
//            return result;
//        } catch (Exception e) {
//            System.out.println("请求异常！" + e);
//            e.printStackTrace();
//        }
//        //使用finally块来关闭输出流、输入流
//        finally {
//            try {
//                if (out != null) {
//                    out.close();
//                }
//                if (in != null) {
//                    in.close();
//                }
//                if (con != null) {
//                    con.disconnect();
//                }
//            } catch (IOException ex) {
//                ex.printStackTrace();
//            }
//        }
//        return result;
//    }
//
//}
