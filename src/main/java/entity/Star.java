package entity;

import lombok.Data;

import java.math.BigInteger;

/**
 * @author yuyu
 * @since 2018/2/7 19:17
 */
@Data
public class Star {
    private Integer id;
    private LyUser user;
    private Acticle acticle;
    private BigInteger user_id;
    private BigInteger acticle_id;
}
