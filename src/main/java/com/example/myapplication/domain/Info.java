package com.example.myapplication.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Info {

    private String appName;
    private String appDescription;
    private String appVersion;

    public Info(String appName, String appDescription, String appVersion) {
        this.appName = appName;
        this.appDescription = appDescription;
        this.appVersion = appVersion;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("appName", appName)
                .append("appDescription", appDescription)
                .append("appVersion", appVersion)
                .toString();
    }
}
