package entity;

import java.math.BigInteger;
import java.sql.Date;

/**
 * @author yuyu
 * @since 2018/2/4 17:08
 */

public class Img {
        private BigInteger id;
        private BigInteger user_id;
        private Integer star;
        private Date date;
        private String url;
        private BigInteger acticle_id;

    public BigInteger getActicle_id() {
        return acticle_id;
    }

    public void setActicle_id(BigInteger acticle_id) {
        this.acticle_id = acticle_id;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public BigInteger getUser_id() {
        return user_id;
    }

    public void setUser_id(BigInteger user_id) {
        this.user_id = user_id;
    }

    public Integer getStar() {
        return star;
    }

    public void setStar(Integer star) {
        this.star = star;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
