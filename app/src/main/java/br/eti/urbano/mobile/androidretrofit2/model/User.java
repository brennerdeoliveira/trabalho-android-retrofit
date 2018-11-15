package br.eti.urbano.mobile.androidretrofit2.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Created by bruno on 28/09/18.
 */

/**
 * @link https://stackoverflow.com/questions/44948858/lombok-builder-on-a-class-that-extends-another-class
 * @link https://blog.codecentric.de/en/2016/05/reducing-boilerplate-code-project-lombok/
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class User extends DefaultModel {

    private String uuid;
    private String userName;
    private byte[] avatar;

    @Builder
    public User(String uuid, String userName,
                byte[] avatar, Integer id,
                String data){
        super(id,data);
        this.uuid = uuid;
        this.userName = userName;
        this.avatar = avatar;
    }
}
