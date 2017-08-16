package roseindia.web.common;
/*
 * common bean class use to set id and value of a cumbo 
 * 
 */
public class DataBean {
	
	//identifiers fields
	private String id;
	private String pid;
	private String value;
	
	
	//setter getter methods
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	

}
