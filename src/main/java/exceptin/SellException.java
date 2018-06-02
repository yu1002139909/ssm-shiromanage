package exceptin;


import emuns.ResultEnum;

/**
 * @author yuyu
 * @since 2017/11/22 14:51
 */
public class SellException extends RuntimeException {
        private Integer code;
        public SellException(ResultEnum resultEnum){
            super(resultEnum.getMessage());
            this.code = resultEnum.getCode();
        }
        public SellException(Integer code, String message){
            super(message);
            this.code = code;
        }
}
