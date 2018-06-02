package entity;

import lombok.Data;

import java.math.BigInteger;
import java.sql.Date;

/**
 * @author yuyu
 * @since 2018/2/4 19:37
 */

@Data
public class LyUser  {
    private BigInteger id;
    private String userName;
    private String password;
    private String address;
    private String email;
    private String gender;
    private String name;
    private Integer age;
    private String role;
    private Date date;
    private String phone;
    private String state;

    public LyUser(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public LyUser() {
    }
}
