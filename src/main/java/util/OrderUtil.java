package util;

public class OrderUtil {


    public OrderUtil() {
    }

    /**
     * 生成一个唯一的订单号
     * OrderUtil.getOrderNumber()<BR>
     * <P>Author :  fangxiaowen </P>
     * <P>Date : 2016年9月2日 </P>
     *
     * @param source
     * @return
     */
    public static String getOrderNumber(final String source) {
        return source + "" + System.currentTimeMillis();
    }


    public static void main(String[] args) {

        System.out.println(getOrderNumber("5"));
    }
}
