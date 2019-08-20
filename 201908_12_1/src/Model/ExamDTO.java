package Model;

public class ExamDTO {

	private int stubun;
	private String stuname;
	private String stuaddr;
	private String stuphone;
	private String stubirth;
	
	private int kor;
	private int eng;
	private int math;
	public int getStubun() {
		return stubun;
	}
	public void setStubun(int stubun) {
		this.stubun = stubun;
	}
	public String getStuname() {
		return stuname;
	}
	public void setStuname(String stuname) {
		this.stuname = stuname;
	}
	public String getStuaddr() {
		return stuaddr;
	}
	public void setStuaddr(String stuaddr) {
		this.stuaddr = stuaddr;
	}
	public String getStuphone() {
		return stuphone;
	}
	public void setStuphone(String stuphone) {
		this.stuphone = stuphone;
	}
	public String getStubirth() {
		return stubirth;
	}
	public void setStubirth(String stubirth) {
		this.stubirth = stubirth;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	
	
	public int getTotal() {
		return kor+math+eng;
	}

}
