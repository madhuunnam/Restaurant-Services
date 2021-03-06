package com.reverseengineering.model;
// Generated Mar 16, 2016 6:54:18 PM by Hibernate Tools 4.3.1.Final

/**
 * SectionsId generated by hbm2java
 */
public class SectionsId implements java.io.Serializable {

	private int resId;
	private String secName;

	public SectionsId() {
	}

	public SectionsId(int resId, String secName) {
		this.resId = resId;
		this.secName = secName;
	}

	public int getResId() {
		return this.resId;
	}

	public void setResId(int resId) {
		this.resId = resId;
	}

	public String getSecName() {
		return this.secName;
	}

	public void setSecName(String secName) {
		this.secName = secName;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof SectionsId))
			return false;
		SectionsId castOther = (SectionsId) other;

		return (this.getResId() == castOther.getResId())
				&& ((this.getSecName() == castOther.getSecName()) || (this.getSecName() != null
						&& castOther.getSecName() != null && this.getSecName().equals(castOther.getSecName())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getResId();
		result = 37 * result + (getSecName() == null ? 0 : this.getSecName().hashCode());
		return result;
	}

}
