
package com.altimetrik.donorschoose.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class SearchResponse implements Serializable {

    @SerializedName("searchTerms")
    @Expose
    private String searchTerms;
    @SerializedName("searchURL")
    @Expose
    private String searchURL;
    @SerializedName("totalProposals")
    @Expose
    private String totalProposals;
    @SerializedName("index")
    @Expose
    private String index;
    @SerializedName("max")
    @Expose
    private String max;
    @SerializedName("breadcrumb")
    @Expose
    private List<List<String>> breadcrumb = null;
    @SerializedName("proposals")
    @Expose
    private List<Proposal> proposals = null;
    private final static long serialVersionUID = 5441174047113685925L;

    public String getSearchTerms() {
        return searchTerms;
    }

    public void setSearchTerms(String searchTerms) {
        this.searchTerms = searchTerms;
    }

    public String getSearchURL() {
        return searchURL;
    }

    public void setSearchURL(String searchURL) {
        this.searchURL = searchURL;
    }

    public String getTotalProposals() {
        return totalProposals;
    }

    public void setTotalProposals(String totalProposals) {
        this.totalProposals = totalProposals;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getMax() {
        return max;
    }

    public void setMax(String max) {
        this.max = max;
    }

    public List<List<String>> getBreadcrumb() {
        return breadcrumb;
    }

    public void setBreadcrumb(List<List<String>> breadcrumb) {
        this.breadcrumb = breadcrumb;
    }

    public List<Proposal> getProposals() {
        return proposals;
    }

    public void setProposals(List<Proposal> proposals) {
        this.proposals = proposals;
    }

}
