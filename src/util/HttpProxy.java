package util;

import java.io.IOException;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.util.EntityUtils;

public class HttpProxy
{
	// http客户端
	private DefaultHttpClient client;

	public HttpProxy()
	{
		this.client = new DefaultHttpClient(new ThreadSafeClientConnManager());
	}

	/**
	 * HttpPost
	 * 
	 * @param url
	 * @param headers
	 * @param args
	 * @param encoding
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public String httpPost(String url, Map<String, String> headers, Map<String, String> args, String encoding) throws ClientProtocolException, IOException
	{
		// post请求
		HttpPost post = new HttpPost(url);
		// 设置头文件
		if (headers != null && headers.size() > 0)
		{
			for (Entry<String, String> header : headers.entrySet())
			{
				post.setHeader(header.getKey(), header.getValue());
			}
		}
		// 请求参数
		if (args != null && args.size() > 0)
		{
			List<NameValuePair> nvps = new ArrayList<NameValuePair>();
			for (Entry<String, String> arg : args.entrySet())
			{
				nvps.add(new BasicNameValuePair(arg.getKey(), arg.getValue()));
			}
			post.setEntity(new UrlEncodedFormEntity(nvps, encoding));
		}
		// 执行请求
		HttpResponse response = client.execute(post);

		// 获取执行结果
		HttpEntity responseEntity = response.getEntity();

		return EntityUtils.toString(responseEntity);
	}

	/**
	 * HttpGet
	 * 
	 * @param url
	 * @param headers
	 * @param args
	 * @param encoding
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public String httpGet(String url, Map<String, String> headers, Map<String, String> args, String encoding) throws ClientProtocolException, IOException
	{
		// client.getParams().setParameter(ClientPNames.ALLOW_CIRCULAR_REDIRECTS, true);

		HttpProtocolParams.setUseExpectContinue(client.getParams(), false);

		// 请求参数
		if (args != null && args.size() > 0)
		{
			for (Entry<String, String> arg : args.entrySet())
			{
				url += arg.getKey() + "=" + arg.getValue() + "&";
			}
		}
		// get请求
		HttpGet get = new HttpGet(url);
		// 设置头文件
		if (headers != null && headers.size() > 0)
		{
			for (Entry<String, String> header : headers.entrySet())
			{
				get.setHeader(header.getKey(), header.getValue());
			}
		}
		// 执行请求
		HttpResponse response = client.execute(get);

		// 获取执行结果
		HttpEntity responseEntity = response.getEntity();

		return EntityUtils.toString(responseEntity);
	}

	/**
	 * 获取到目的地的距离
	 * 
	 * @param lng1
	 * @param lat1
	 * @param lng2
	 * @param lat2
	 * @return
	 */
	public static double GetDistance(double lng1, double lat1, double lng2, double lat2)
	{
		return 0;
	}

	/**
	 * 获取文件的MIME类型
	 * 
	 * @param fileUrl
	 * @return String
	 * @throws IOException
	 */
	public static String getMimeType(String fileUrl) throws IOException
	{
		return URLConnection.getFileNameMap().getContentTypeFor(fileUrl);
	}

	public static void main(String[] args) throws ClientProtocolException, IOException
	{
		Map<String, String> params = new HashMap<String, String>();

		// params.put("mode", "transit");
		// params.put("origin", "秦淮区七里街公交站台");
		// params.put("destination", "南京东站");
		// params.put("region", "南京");

		params.put("query", "加油站");
		params.put("location", "32.026595,118.787914");
		params.put("radius", "2000");

		params.put("output", "json");
		params.put("ak", "378852d259340de5e6fc2580215c501ck");

		System.out.println(new HttpProxy().httpGet("http://api.map.baidu.com/place/v2/search?", null, params, "utf-8"));
	}
}