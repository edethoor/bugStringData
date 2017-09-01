package com.example.demo.pojo;
import java.util.List;

public class Notification {

	private List<AbstractAttachment> attachments;

	private Float nbCredits;

	private Integer nbAttempts;

	public List<AbstractAttachment> getAttachments() {
		return attachments;
	}

	public void setAttachments(List<AbstractAttachment> attachments) {
		this.attachments = attachments;
	}

	public Float getNbCredits() {
		return nbCredits;
	}

	public void setNbCredits(Float nbCredits) {
		this.nbCredits = nbCredits;
	}

	public Integer getNbAttempts() {
		return nbAttempts;
	}

	public void setNbAttempts(Integer nbAttempts) {
		this.nbAttempts = nbAttempts;
	}
}
