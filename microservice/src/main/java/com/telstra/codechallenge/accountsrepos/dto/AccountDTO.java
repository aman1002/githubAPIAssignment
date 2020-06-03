package com.telstra.codechallenge.accountsrepos.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountDTO {

    Long id;
    String login;
    @JsonProperty("html_url")
    String htmlUrl;

    public AccountDTO() {
    }

    public AccountDTO(Long id, String login, String htmlUrl) {
        this.id = id;
        this.login = login;
        this.htmlUrl = htmlUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String gethtmlUrl() {
        return htmlUrl;
    }

    public void sethtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
    }

    @Override
    public String toString() {
    	String str = String.format("{id:%s, login:%s, html_url:%s}", id, login, htmlUrl);
        return str;
    }
}
