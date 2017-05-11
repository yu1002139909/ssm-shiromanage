package entity;

/**
 * @Author qq_emial1002139909@qq.com
 * @Date 2017/5/2 17:07
 */
public class Muen {

    private String id;
    private String name;
    private String parentId;
    private String url;
    private String icon;
    private String order;
    private String isHeader;
    private String childMenus;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getIsHeader() {
        return isHeader;
    }

    public void setIsHeader(String isHeader) {
        this.isHeader = isHeader;
    }

    public String getChildMenus() {
        return childMenus;
    }

    public void setChildMenus(String childMenus) {
        this.childMenus = childMenus;
    }
}
