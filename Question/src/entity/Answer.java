package entity;
public class Answer {
	
	private int answerId;//�ظ���id
	
	private int replayId;//�ظ���id
	
	private int oid;//����id
	
	private int qSeq;//����ѡ���С

	
	private int seSeq;//ѡ���ѡ��
	
	private String seValue;//ѡ���valueֵ
	
	private String remark;//����¼

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
