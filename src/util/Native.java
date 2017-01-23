package util;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;

public class Native
{

	public static void main(String[] args) throws Exception
	{
		String mobile = "15850781443";

		// i
		String url = "http://virtual.paipai.com/extinfo/GetMobileProductInfo?";

		HttpProxy httpProxy = new HttpProxy();
		Map<String, String> params = new HashMap<String, String>();
		params.put("amount", "10000");
		params.put("mobile", mobile);

		String result = httpProxy.httpGet(url, null, params, "utf-8");
		JSONObject loc = JSONObject.parseObject(result.substring(result.indexOf("(") + 1, result.indexOf(")")));

		//System.out.println(loc);
		System.out.println(loc.getString("province"));
		System.out.println(loc.getString("cityname"));
	}
}
