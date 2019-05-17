package com.ezads.Pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Set;

public class HashTagsList {

    @SerializedName("hashTags")
    @Expose
    private Set<String> hashTags = null;

    @SerializedName("versionName")
    @Expose
    private String versionName = null;

    public Set<String> getHashTags() {
        return hashTags;
    }

    public void setHashTags(Set<String> hashTags) {
        this.hashTags = hashTags;
    }

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    @Override
    public String toString() {
        return "HashTagsList{" +
                "hashTags=" + hashTags +
                ", versionName='" + versionName + '\'' +
                '}';
    }
}
