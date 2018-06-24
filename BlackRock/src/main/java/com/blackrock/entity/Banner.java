package com.blackrock.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the banner database table.
 * 
 */
@Entity
@NamedQuery(name = "Banner.findAll", query = "SELECT b FROM Banner b")
public class Banner implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name = "image_url")
	private String imageUrl;

	@Column(name = "primary_text")
	private String primaryText;

	@Column(name = "secondary_text")
	private String secondaryText;

	private String showinUI;

	private String title;

	private String url;

	public Banner() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImageUrl() {
		return this.imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getPrimaryText() {
		return this.primaryText;
	}

	public void setPrimaryText(String primaryText) {
		this.primaryText = primaryText;
	}

	public String getSecondaryText() {
		return this.secondaryText;
	}

	public void setSecondaryText(String secondaryText) {
		this.secondaryText = secondaryText;
	}

	public String getShowinUI() {
		return this.showinUI;
	}

	public void setShowinUI(String showinUI) {
		this.showinUI = showinUI;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "Banner [id=" + id + ", imageUrl=" + imageUrl + ", primaryText=" + primaryText + ", secondaryText="
				+ secondaryText + ", showinUI=" + showinUI + ", title=" + title + ", url=" + url + "]";
	}

}