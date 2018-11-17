package br.eti.urbano.mobile.androidretrofit2.model;

import lombok.Builder;
import lombok.Data;

@Data
public class Photo {

    private Long albumId;
    private Long id;
    private String title;
    private String url;
    private String thumbnailUrl;

    @Builder
    public Photo(Long albumId, Long id, String title, String url, String thumbnailUrl) {
        this.albumId = albumId;
        this.id = id;
        this.title = title;
        this.url = url;
        this.thumbnailUrl = thumbnailUrl;
    }

}
