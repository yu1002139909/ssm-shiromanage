package entity;

import lombok.Data;

import java.math.BigInteger;
import java.sql.Date;

/**
 * @author yuyu
 * @since 2018/2/4 18:45
 */
@Data
public class Comment {

    private BigInteger id;
    private Date date;
    private BigInteger user_id;
    private BigInteger artcle_id;
    private String content;
    private LyUser lyUser;
    private Acticle acticle;
}
