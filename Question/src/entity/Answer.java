package entity;
public class Answer {
	
	private int answerId;//回复者id
	
	private int replayId;//回复者id
	
	private int oid;//主题id
	
	private int qSeq;//问题选项大小

	
	private int seSeq;//选择的选项
	
	private String seValue;//选项的value值
	
	private String remark;//备忘录

	public int getAnswerId() {
		return answerId;
	}

	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}

	public int getReplayId() {
		return replayId;
	}

	public void setReplayId(int replayId) {
		this.replayId = replayId;
	}

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public int getqSeq() {
		return qSeq;
	}

	public void setqSeq(int qSeq) {
		this.qSeq = qSeq;
	}

	public int getSeSeq() {
		return seSeq;
	}

	public void setSeSeq(int seSeq) {
		this.seSeq = seSeq;
	}

	public String getSeValue() {
		return seValue;
	}

	public void setSeValue(String seValue) {
		this.seValue = seValue;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
