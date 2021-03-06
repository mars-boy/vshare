package com.marsboy.vshare.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "video", catalog = "vshare")
public class Video implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private long videoId;
	private User user;
	private String videoName;
	private String videoPath;
	private Date uploadedOn;
	private boolean status;

	public Video() {
	}

	public Video(long videoId, User user, String videoName, String videoPath, Date uploadedOn, boolean status) {
		this.videoId = videoId;
		this.user = user;
		this.videoName = videoName;
		this.videoPath = videoPath;
		this.uploadedOn = uploadedOn;
		this.status = status;
	}

	@Id

	@Column(name = "video_id", unique = true, nullable = false)
	public long getVideoId() {
		return this.videoId;
	}

	public void setVideoId(long videoId) {
		this.videoId = videoId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "uploaded_by", nullable = false)
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "video_name", nullable = false)
	public String getVideoName() {
		return this.videoName;
	}

	public void setVideoName(String videoName) {
		this.videoName = videoName;
	}

	@Column(name = "video_path", nullable = false)
	public String getVideoPath() {
		return this.videoPath;
	}

	public void setVideoPath(String videoPath) {
		this.videoPath = videoPath;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "uploaded_on", nullable = false, length = 19)
	public Date getUploadedOn() {
		return this.uploadedOn;
	}

	public void setUploadedOn(Date uploadedOn) {
		this.uploadedOn = uploadedOn;
	}

	@Column(name = "status", nullable = false)
	public boolean isStatus() {
		return this.status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

}
