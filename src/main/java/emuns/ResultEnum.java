package emuns;

import lombok.Getter;

/**
 * @author yuyu
 * @since 2017/11/22 14:52
 */
@Getter
public enum ResultEnum {
    USER_NOT_NULL(500,"用户不为空"),
    INPUT_ERROR(500,"导出失败")
    ;
    private Integer code;
    private String message;
    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
