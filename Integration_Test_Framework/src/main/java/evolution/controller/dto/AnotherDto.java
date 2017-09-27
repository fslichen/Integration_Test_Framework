package evolution.controller.dto;

public class AnotherDto {
	private String url;
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public String toString() {
		return "AnotherDto [url=" + url + "]";
	}
}
