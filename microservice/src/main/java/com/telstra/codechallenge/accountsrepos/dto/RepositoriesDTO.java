package com.telstra.codechallenge.accountsrepos.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RepositoriesDTO {
	
	@JsonProperty("html_url")
	String htmlUrl;
	@JsonProperty("watchers_count")
	Long watchersCount;
	String language;
	String description;
	String name;
	public RepositoriesDTO() {
		
	}
	public RepositoriesDTO(String htmlUrl, Long watchersCount, String language, String description, String name) {
		this.htmlUrl = htmlUrl;
		this.watchersCount = watchersCount;
		this.language = language;
		this.description = description;
		this.name = name;
	}
		
	public String gethtmlUrl() {
		return htmlUrl;
	}
	public void sethtmlUrl(String htmlUrl) {
		this.htmlUrl = htmlUrl;
	}
	public Long getWatchersCount() {
		return watchersCount;
	}
	public void setWatchersCount(Long watchersCount) {
		this.watchersCount = watchersCount;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
    public String toString() {
		String str = String.format("{html_url:%s, watchers_count:%s, language:%s, description:%s, name:%s}", htmlUrl, watchersCount, language, description, name);
		return str;
    }

}
