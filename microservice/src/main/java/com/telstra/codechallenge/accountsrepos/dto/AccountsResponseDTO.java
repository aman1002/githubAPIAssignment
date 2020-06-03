package com.telstra.codechallenge.accountsrepos.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.telstra.codechallenge.accountsrepos.dto.AccountDTO;

import java.util.List;

public class AccountsResponseDTO {

    @JsonProperty("total_count")
	Long totalCount;
    @JsonProperty("incomplete_results")
    Boolean incompleteResults;
    List<AccountDTO> items;

    public AccountsResponseDTO() {

    }

    public AccountsResponseDTO(Long totalCount, Boolean incompleteResults, List<AccountDTO> items) {
        this.totalCount = totalCount;
        this.incompleteResults = incompleteResults;
        this.items = items;
    }

    public Long gettotalCount() {
        return totalCount;
    }

    public void settotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }

    public Boolean getincompleteResults() {
        return incompleteResults;
    }

    public void setincompleteResults(Boolean incompleteResults) {
        this.incompleteResults = incompleteResults;
    }

    public List<AccountDTO> getItems() {
        return items;
    }

    public void setItems(List<AccountDTO> items) {
        this.items = items;
    }
}
