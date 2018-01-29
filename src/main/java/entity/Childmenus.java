/**
  * Copyright 2017 bejson.com 
  */
package entity;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Auto-generated: 2017-05-18 20:48:30
 *11111
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class Childmenus {

    private String id;
    private String name;
    @JsonProperty("parentId")
    private String parentid;
    private String url;
    private String icon;
    private String order;
    @JsonProperty("isHeader")
    private String isheader;
    @JsonProperty("childMenus")
    private String childmenus;
    public void setId(String id) {
         this.id = id;
     }
     public String getId() {
         return id;
     }

    public void setName(String name) {
         this.name = name;
     }
     public String getName() {
         return name;
     }

    public void setParentid(String parentid) {
         this.parentid = parentid;
     }
     public String getParentid() {
         return parentid;
     }

    public void setUrl(String url) {
         this.url = url;
     }
     public String getUrl() {
         return url;
     }

    public void setIcon(String icon) {
         this.icon = icon;
     }
     public String getIcon() {
         return icon;
     }

    public void setOrder(String order) {
         this.order = order;
     }
     public String getOrder() {
         return order;
     }

    public void setIsheader(String isheader) {
         this.isheader = isheader;
     }
     public String getIsheader() {
         return isheader;
     }

    public void setChildmenus(String childmenus) {
         this.childmenus = childmenus;
     }
     public String getChildmenus() {
         return childmenus;
     }

}