范例 - SpringMVC使用HTTPS协议
---

访问以下地址 `https://localhost:8443/ssl`

* 地址: `https://localhost:8443/ssl`
* 方法: `GET` 或 `POST`
* 参数: 不限制，请任意测试。
* 请求头: 不限制，请任意测试。

如：

```bash
# 发送请求
curl -k -X POST -d 'name=yingzhuo&name=yinyingchun' -H 'token:yingzhuo123456' -u 'yingzhuo:yingzhuo' https://localhost:8443/ssl
```

```bash
# 获得应答

{
  "path" : "/ssl",
  "headers" : {
    "authorization" : "Basic eWluZ3podW86eWluZ3podW8=",
    "content-length" : "30",
    "host" : "localhost:8443",
    "content-type" : "application/x-www-form-urlencoded",
    "user-agent" : "curl/7.49.1",
    "accept" : "*/*",
    "token" : "yingzhuo123456"
  },
  "parameters" : {
    "name" : [ "yingzhuo", "yinyingchun" ]
  }
}
```