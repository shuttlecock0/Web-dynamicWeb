package imageAPI;

import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class NaverImageApi {
	static final String clientId="VzsKDChxR6Z8uYYfU_zH";
	static final String clientSecret="EQg29ZB3uQ";
	
	String baseURL = "https://openapi.naver.com/v1/search/image";
	public NaverImageApi() {}
	
	public SearchResult<ImageItem> get(Map<String, Object> map) throws Exception{
		String params = QueryMap.getQueryString(map);
		
		String apiURL = String.format("%s?%s",  baseURL, params);
		URL url = new URL(apiURL);
		
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("X-Naver-Client-Id", clientId);
		con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
		
		String response = download(con);
		Gson gson = new Gson();
		
		Type type = new TypeToken<SearchResult<ImageItem>>(){}.getType();
		return gson.fromJson(response, type);
	}
	
	public SearchResult<ImageItem> get(String keyword, int start, int display) throws Exception{
		Map<String, Object> map = new HashMap<>();
		map.put("query", keyword);
		map.put("start", start);
		map.put("display", display);
		return get(map);
	}
	
	public SearchResult<ImageItem> get(String keyword, int start) throws Exception{
		return get(keyword, start, 10);
	}
	
	public SearchResult<ImageItem> get(String keyword) throws Exception{
		return get(keyword, 1, 10);
	}
	
	String download(HttpURLConnection con) throws Exception{
		int responseCode = con.getResponseCode();
		
		if(responseCode == 200) {
			return FileUtil.readString(con.getInputStream());
		}
		// 에러 발생
		throw new Exception("에러 발생 : " + responseCode);
	}
}
