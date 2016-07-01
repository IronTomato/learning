Java Web编程备查
===============

在Cookie中存入中文
--------------------
Cookie的值不支持中文，要将中文存入Cookie需要经过编码，取出时再解码

	String cookieValue = java.net.URLEncoder.encode(chineseString,"UTF-8");
	String origin = java.net.URLDecoder.decode(cookieValue,"UTF-8");