package com.telstra.codechallenge.accountsrepos.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RepositoriesResponseDTO {

    @JsonProperty("total_count")
	Long totalCount;
    @JsonProperty("incomplete_results")
    Boolean incompleteResults;
    List<RepositoriesDTO> items;

    public RepositoriesResponseDTO() {

    }

    public RepositoriesResponseDTO(Long totalCount, Boolean incompleteResults, List<RepositoriesDTO> items) {
        this.totalCount = totalCount;
        this.incompleteResults = incompleteResults;
        this.items = items;
    }

    public Long getTotal_count() {
        return totalCount;
    }

    public void setTotal_count(Long totalCount) {
        this.totalCount = totalCount;
    }

    public Boolean getincompleteResults() {
        return incompleteResults;
    }

    public void setincompleteResults(Boolean incompleteResults) {
        this.incompleteResults = incompleteResults;
    }

    public List<RepositoriesDTO> getItems() {
        return items;
    }

    public void setItems(List<RepositoriesDTO> items) {
        this.items = items;
    }
}