package imageAPI;

public class Ex02 {
	final static int MAXIMUM = 1000;
	public static void main(String[] args) {
		try {
			NaverImageApi api = new NaverImageApi();
			for(int start=1;start<MAXIMUM;) {
				System.out.println(start);
				SearchResult<ImageItem> res = api.get("자동차", start);
				// 이미지 처리
				
				start += res.getDisplay();
				Thread.sleep(1000);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
