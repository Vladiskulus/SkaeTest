package com.iambulance.skai.test.model;

import lombok.*;

@Setter
@Getter
@Builder
@EqualsAndHashCode
public class ApiRequest {

    private String ip;
    private String data;
    private String requestMethod;
    private String uri;
    private int requestStatus;
}