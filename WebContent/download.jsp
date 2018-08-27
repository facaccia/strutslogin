<%@page import="com.candidjava.service.UserServiceImpl"%>
<%@page import="com.candidjava.service.UserService"%>
<%@ taglib prefix="s" uri="/struts-tags"%> 
<%@ taglib prefix="a" uri="/struts-tags" %>
<a:include value="header.jsp" ></a:include>


	<%@ taglib prefix="s" uri="/struts-tags" %>


<h1>Struts 2 download file example</h1>

<s:url id="fileDownload" namespace="/" action="download" ></s:url>

<ins class="adsbygoogle"
     style="display:block"
     data-ad-client="ca-pub-2836379775501347"
     data-ad-slot="8821506761"
     data-ad-format="auto"
     data-ad-region="mkyongregion"></ins>
<script>
(adsbygoogle = window.adsbygoogle || []).push({});
</script><h2>Download file - <s:a href="%{fileDownload}">fileABC.txt</s:a>
</h2>

<s:url id="fileDownloadImg" namespace="/" action="downloadImage" ></s:url>

<ins class="adsbygoogle"
     style="display:block"
     data-ad-client="ca-pub-2836379775501347"
     data-ad-slot="8821506761"
     data-ad-format="auto"
     data-ad-region="mkyongregion"></ins>
<script>
(adsbygoogle = window.adsbygoogle || []).push({});
</script><h2>Download file - <s:a href="%{fileDownloadImg}">fileABC.img</s:a>
</h2>

<s:url id="fileDownloadWord" namespace="/" action="downloadWord" ></s:url>

<ins class="adsbygoogle"
     style="display:block"
     data-ad-client="ca-pub-2836379775501347"
     data-ad-slot="8821506761"
     data-ad-format="auto"
     data-ad-region="mkyongregion"></ins>
<script>
(adsbygoogle = window.adsbygoogle || []).push({});
</script><h2>Download file - <s:a href="%{fileDownloadWord}">fileABC.docx</s:a>
</h2>

<a href="controllo.jsp">Home</a>
	
</body>
</html>

