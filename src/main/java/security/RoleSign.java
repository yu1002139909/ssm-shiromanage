package security;

import java.util.HashMap;
import java.util.Map;

/**
 * 角色标识配置类, <br>
 * 与 role_info 角色表中的 role_sign 字段 相对应 <br>
 * 使用:
 * 
 * <pre>
 * &#064;RequiresRoles(value = RoleSign.ADMIN)
 * public String admin() {
 *     return &quot;拥有admin角色,能访问&quot;;
 * }
 * </pre>
 * 
 * @author StarZou
 * @since 2014年6月17日 下午3:58:51
 **/
public class RoleSign {

    /**
     *超级管理员 标识
     */
    public static final String ADMIN = "admin";
    /**
     * 信息学院标识
     */
    public static final String XXXYADMIN = "xxxyadmin";

    /**
     * 财经学院标识
     */
    public static final String CJXYADMIN = "cjxeadmin";

    /**
     * 机械学院标识
     */
    public static final String JXXYADMIN = "jxxyadmin";

    /**
     * 添加更多...
     */
    //角色集合
    public static Map<String,String> Rolesigin ;

    static {
        Rolesigin = new HashMap<String, String>();
        Rolesigin.put(ADMIN,"超级管理员");
        Rolesigin.put(XXXYADMIN,"信息学院管理员");
        Rolesigin.put(CJXYADMIN,"财经学院管理员");
        Rolesigin.put(JXXYADMIN,"机械学院管理员");
    }
}
