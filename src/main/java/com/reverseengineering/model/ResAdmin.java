package com.reverseengineering.model;
// Generated Mar 16, 2016 6:54:18 PM by Hibernate Tools 4.3.1.Final

/**
 * ResAdmin generated by hbm2java
 */
public class ResAdmin implements java.io.Serializable {

	private int resId;
	private Float sales;
	private Integer numOrders;
	private Float popularity;
	private Integer likes;
	private Integer dislikes;
	private Integer numRev;
	private Float avgStar;
	private Integer numYelp;
	private Float yelpStar;
	private String priceRange;
	private Integer recomenderId;
	private String recomType;
	private String commissionType;
	private String promoCode;
	private String adChannel;
	private Integer numCust;
	private Integer numRes;

	public ResAdmin() {
	}

	public ResAdmin(int resId) {
		this.resId = resId;
	}

	public ResAdmin(int resId, Float sales, Integer numOrders, Float popularity, Integer likes, Integer dislikes,
			Integer numRev, Float avgStar, Integer numYelp, Float yelpStar, String priceRange, Integer recomenderId,
			String recomType, String commissionType, String promoCode, String adChannel, Integer numCust,
			Integer numRes) {
		this.resId = resId;
		this.sales = sales;
		this.numOrders = numOrders;
		this.popularity = popularity;
		this.likes = likes;
		this.dislikes = dislikes;
		this.numRev = numRev;
		this.avgStar = avgStar;
		this.numYelp = numYelp;
		this.yelpStar = yelpStar;
		this.priceRange = priceRange;
		this.recomenderId = recomenderId;
		this.recomType = recomType;
		this.commissionType = commissionType;
		this.promoCode = promoCode;
		this.adChannel = adChannel;
		this.numCust = numCust;
		this.numRes = numRes;
	}

	public int getResId() {
		return this.resId;
	}

	public void setResId(int resId) {
		this.resId = resId;
	}

	public Float getSales() {
		return this.sales;
	}

	public void setSales(Float sales) {
		this.sales = sales;
	}

	public Integer getNumOrders() {
		return this.numOrders;
	}

	public void setNumOrders(Integer numOrders) {
		this.numOrders = numOrders;
	}

	public Float getPopularity() {
		return this.popularity;
	}

	public void setPopularity(Float popularity) {
		this.popularity = popularity;
	}

	public Integer getLikes() {
		return this.likes;
	}

	public void setLikes(Integer likes) {
		this.likes = likes;
	}

	public Integer getDislikes() {
		return this.dislikes;
	}

	public void setDislikes(Integer dislikes) {
		this.dislikes = dislikes;
	}

	public Integer getNumRev() {
		return this.numRev;
	}

	public void setNumRev(Integer numRev) {
		this.numRev = numRev;
	}

	public Float getAvgStar() {
		return this.avgStar;
	}

	public void setAvgStar(Float avgStar) {
		this.avgStar = avgStar;
	}

	public Integer getNumYelp() {
		return this.numYelp;
	}

	public void setNumYelp(Integer numYelp) {
		this.numYelp = numYelp;
	}

	public Float getYelpStar() {
		return this.yelpStar;
	}

	public void setYelpStar(Float yelpStar) {
		this.yelpStar = yelpStar;
	}

	public String getPriceRange() {
		return this.priceRange;
	}

	public void setPriceRange(String priceRange) {
		this.priceRange = priceRange;
	}

	public Integer getRecomenderId() {
		return this.recomenderId;
	}

	public void setRecomenderId(Integer recomenderId) {
		this.recomenderId = recomenderId;
	}

	public String getRecomType() {
		return this.recomType;
	}

	public void setRecomType(String recomType) {
		this.recomType = recomType;
	}

	public String getCommissionType() {
		return this.commissionType;
	}

	public void setCommissionType(String commissionType) {
		this.commissionType = commissionType;
	}

	public String getPromoCode() {
		return this.promoCode;
	}

	public void setPromoCode(String promoCode) {
		this.promoCode = promoCode;
	}

	public String getAdChannel() {
		return this.adChannel;
	}

	public void setAdChannel(String adChannel) {
		this.adChannel = adChannel;
	}

	public Integer getNumCust() {
		return this.numCust;
	}

	public void setNumCust(Integer numCust) {
		this.numCust = numCust;
	}

	public Integer getNumRes() {
		return this.numRes;
	}

	public void setNumRes(Integer numRes) {
		this.numRes = numRes;
	}

}
