package br.eti.urbano.mobile.androidretrofit2.model;

import lombok.Builder;
import lombok.Data;

@Data
public class Posts {

    private Integer userId;
    private Integer id;
    private String title;
    private String body;

    @Builder
    public Posts(Integer userId, Integer id, String title, String body) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;
    }

}
