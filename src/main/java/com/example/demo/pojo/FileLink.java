package com.example.demo.pojo;

public class FileLink extends AbstractAttachment {

	private String fileId;

	private String name;

	private int nbPages;

	private Long size;

	public FileLink() {
		super();
	}

	public FileLink(String id, String name, int nbPages, Long size) {
		super();
		this.fileId = id;
		this.name = name;
		this.nbPages = nbPages;
		this.size = size;
	}

	public String getFileId() {
		return fileId;
	}

	public void setFileId(String id) {
		this.fileId = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNbPages() {
		return nbPages;
	}

	public void setNbPages(int nbPages) {
		this.nbPages = nbPages;
	}

	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}

}
