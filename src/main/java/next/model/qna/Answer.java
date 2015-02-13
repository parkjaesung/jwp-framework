package next.model.qna;

import java.util.Date;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class Answer {
	private long answerId;
	
	@Size(min = 2, max = 30)
	private String writer;
	
	@NotEmpty
	private String contents;
	
	private Date createdDate;

	private long questionId;
	
	public Answer() {
		this.createdDate = new Date();
	}
	
	public Answer(String writer, String contents, long questionId) {
		this(0, writer, contents, new Date(), questionId);
	}
	
	public Answer(long answerId, String writer, String contents, Date createdDate, long questionId) {
		this.answerId = answerId;
		this.writer = writer;
		this.contents = contents;
		this.createdDate = createdDate;
		this.questionId = questionId;
	}
	
	public long getAnswerId() {
		return answerId;
	}

	public void setAnswerId(long answerId) {
		this.answerId = answerId;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public Date getCreatedDate() {
		return createdDate;
	}
	
	public long getTimeFromCreateDate() {
		return this.createdDate.getTime();
	}
	
	public long getQuestionId() {
		return questionId;
	}
	
	public void setQuestionId(long questionId) {
		this.questionId = questionId;
	}
	
	public boolean isSameUser(String writer) {
		if (this.writer == null) {
			return false;
		}
		
		return this.writer.equals(writer);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (answerId ^ (answerId >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Answer other = (Answer) obj;
		if (answerId != other.answerId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Answer [answerId=" + answerId + ", writer=" + writer
				+ ", contents=" + contents + ", createdDate=" + createdDate
				+ ", questionId=" + questionId + "]";
	}
}
