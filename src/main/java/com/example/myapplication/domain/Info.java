package com.example.myapplication.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Info {

    private String appName;
    private String appDescription;
    private String appVersion;
}
