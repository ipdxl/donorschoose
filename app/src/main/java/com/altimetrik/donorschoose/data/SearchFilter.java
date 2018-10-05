package com.altimetrik.donorschoose.data;

/**
 * Created by José Guadalupe Mandujano on 10/5/18.
 */
public class SearchFilter {

    private String[] keywords;
    private int subject;
    private int[] additionalSubjects;
    private double latitude;
    private double longitude;
    private double centerLat;
    private double centerLng;
    private int sortBy;

    private SearchFilter() {
    }

    public String[] getKeywords() {
        return keywords;
    }

    public void setKeywords(String[] keywords) {
        this.keywords = keywords;
    }

    public int getSubject() {
        return subject;
    }

    public void setSubject(int subject) {
        this.subject = subject;
    }

    public int[] getAdditionalSubjects() {
        return additionalSubjects;
    }

    public void setAdditionalSubjects(int[] additionalSubjects) {
        this.additionalSubjects = additionalSubjects;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getCenterLat() {
        return centerLat;
    }

    public void setCenterLat(double centerLat) {
        this.centerLat = centerLat;
    }

    public double getCenterLng() {
        return centerLng;
    }

    public void setCenterLng(double centerLng) {
        this.centerLng = centerLng;
    }

    public int getSortBy() {
        return sortBy;
    }

    public void setSortBy(int sortBy) {
        this.sortBy = sortBy;
    }

    public static class Builder {
        private final SearchFilter request;

        public Builder() {
            request = new SearchFilter();
        }

        public SearchFilter create() {
            return request;
        }

        public Builder setSubject(int subject) {
            request.setSubject(subject);
            return this;
        }

        public Builder setAdditionalSubjects(int[] additionalSubjects) {
            request.setAdditionalSubjects(additionalSubjects);
            return this;
        }

        public Builder setLatLng(double lat, double lng) {
            request.setLatitude(lat);
            request.setLongitude(lng);
            return this;
        }

        public Builder setCenterLatLng(double lat, double lng) {
            request.setCenterLat(lat);
            request.setCenterLng(lng);
            return this;
        }
    }
}
