/**
 * 
 */
package com.trade.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table;

/**
 * @author jatin
 *
 */
@Entity
@Table(name = "banner")
class Banner extends BaseEntity  {

	@Column(name = "title")
	private String title ;

	@Column(name = "image_url")
	private String imageUrl;
	@Column(name = "url")
	private String url;
	@Column(name="primary_text")
	private String primaryText;
	@Column(name="secondary_text")
	private String secondaryText;

	@Column(name="showinUI")
	private String showInUI;


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPrimaryText() {
		return primaryText;
	}

	public void setPrimaryText(String primaryText) {
		this.primaryText = primaryText;
	}

	public String getSecondaryText() {
		return secondaryText;
	}

	public void setSecondaryText(String secondaryText) {
		this.secondaryText = secondaryText;
	}

	public String getLongDescription() {
		return longDescription;
	}

	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}


	public String getShowInUI() {
		return showInUI;
	}

	public void setShowInUI(String showInUI) {
		this.showInUI = showInUI;
	}


	@Override
	public String toString() {
		return "Banner{" +
				"title='" + title + '\'' +
				", imageUrl='" + imageUrl + '\'' +
				", url='" + url + '\'' +
				", primaryText='" + primaryText + '\'' +
				", secondaryText='" + secondaryText + '\'' +
				", showInUI=" + showInUI +
				'}';
	}
}
