package org.arpit.java2blog.bean;

public class AuthResponse {
	private String accessToken;
	private String refreshToken;
	private String expiresOn;
	/**
	 * @return the accessToken
	 */
	public String getAccessToken() {
		return accessToken;
	}
	/**
	 * @param accessToken the accessToken to set
	 */
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	/**
	 * @return the refreshToken
	 */
	public String getRefreshToken() {
		return refreshToken;
	}
	/**
	 * @param refreshToken the refreshToken to set
	 */
	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}
	/**
	 * @return the expiresOn
	 */
	public String getExpiresOn() {
		return expiresOn;
	}
	/**
	 * @param expiresOn the expiresOn to set
	 */
	public void setExpiresOn(String expiresOn) {
		this.expiresOn = expiresOn;
	}

}
