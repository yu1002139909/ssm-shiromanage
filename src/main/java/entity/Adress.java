package entity;

import java.util.List;

/**
 * @author yuyu
 * @since 2018/2/8 18:50
 */
public class Adress {

    /**
     * status : 0
     * result : {"location":{"lng":112.89256199999997,"lat":23.107683010701553},"formatted_address":"广东省佛山市南海区心溪古道","business":"","addressComponent":{"country":"中国","country_code":0,"country_code_iso":"CHN","country_code_iso2":"CN","province":"广东省","city":"佛山市","city_level":2,"district":"南海区","town":"","adcode":"440605","street":"心溪古道","street_number":"","direction":"","distance":""},"pois":[{"addr":"佛山市南海区","cp":" ","direction":"东南","distance":"283","name":"心溪","poiType":"行政地标","point":{"x":112.89147272743556,"y":23.109811115715942},"tag":"行政地标;村庄","tel":"","uid":"631c4157a26e0a6131f71d76","zip":"","parent_poi":{"name":"","tag":"","addr":"","point":{"x":0,"y":0},"direction":"","distance":"","uid":""}},{"addr":"丹灶镇国家生态工业区银海大道外资工业村8号","cp":" ","direction":"东","distance":"432","name":"昼田汽车部件公司","poiType":"公司企业","point":{"x":112.8888137431269,"y":23.10862280402247},"tag":"公司企业;公司","tel":"","uid":"d0cbaa53527fbccd95f08cd0","zip":"","parent_poi":{"name":"","tag":"","addr":"","point":{"x":0,"y":0},"direction":"","distance":"","uid":""}},{"addr":"丹灶镇生态工业示范园区银海大道外资工业村7号","cp":" ","direction":"东","distance":"459","name":"勇一精锻公司","poiType":"公司企业","point":{"x":112.88850831925362,"y":23.10696081178378},"tag":"公司企业;公司","tel":"","uid":"546043559f7f66bd8bb9882a","zip":"","parent_poi":{"name":"","tag":"","addr":"","point":{"x":0,"y":0},"direction":"","distance":"","uid":""}},{"addr":"丹灶镇南海生态国家示范工业园银海大道北外资工业村","cp":" ","direction":"东","distance":"470","name":"久田(佛山)汽车配件有限公司","poiType":"公司企业","point":{"x":112.88841848870264,"y":23.108456605734915},"tag":"公司企业;公司","tel":"","uid":"97555d9f72ecebc9d62ce2bc","zip":"","parent_poi":{"name":"","tag":"","addr":"","point":{"x":0,"y":0},"direction":"","distance":"","uid":""}},{"addr":"佛山市南海区外资工业村4号1楼","cp":" ","direction":"东南","distance":"498","name":"佛山中检南方检测有限公司","poiType":"公司企业","point":{"x":112.88906526866961,"y":23.110268155842476},"tag":"公司企业;公司","tel":"","uid":"96dade53e1c614ce8bfc066e","zip":"","parent_poi":{"name":"","tag":"","addr":"","point":{"x":0,"y":0},"direction":"","distance":"","uid":""}},{"addr":"丹灶镇南海国家生态工业示范园银海大道外资工业村6号","cp":" ","direction":"东","distance":"499","name":"富士气门公司","poiType":"公司企业","point":{"x":112.88814001399464,"y":23.10696081178378},"tag":"公司企业;公司","tel":"","uid":"1b0adbfbce0d834f256e989f","zip":"","parent_poi":{"name":"","tag":"","addr":"","point":{"x":0,"y":0},"direction":"","distance":"","uid":""}},{"addr":"丹灶镇国家生态工业示范园外资工业村b幢","cp":" ","direction":"东南","distance":"675","name":"远州佛山汽车配件有限公司","poiType":"汽车服务","point":{"x":112.88787950539684,"y":23.1112570190941},"tag":"汽车服务;汽车配件","tel":"","uid":"30ba0450407ea3e929fc487e","zip":"","parent_poi":{"name":"","tag":"","addr":"","point":{"x":0,"y":0},"direction":"","distance":"","uid":""}},{"addr":"广东省佛山市南海区丹灶镇月季路金石员工大厦","cp":" ","direction":"东南","distance":"716","name":"万民百货","poiType":"购物","point":{"x":112.88850831925362,"y":23.112304042742537},"tag":"购物;超市","tel":"","uid":"0d0e70f2e0c80579bca822e6","zip":"","parent_poi":{"name":"","tag":"","addr":"","point":{"x":0,"y":0},"direction":"","distance":"","uid":""}},{"addr":"月季路与银海大道北交叉口东南50米","cp":" ","direction":"东南","distance":"754","name":"金石员工大厦","poiType":"房地产","point":{"x":112.8879693359478,"y":23.11229573306356},"tag":"房地产;住宅区","tel":"","uid":"aeb0275ede5544b9e115f944","zip":"","parent_poi":{"name":"","tag":"","addr":"","point":{"x":0,"y":0},"direction":"","distance":"","uid":""}}],"roads":[],"poiRegions":[],"sematic_description":"心溪东南283米","cityCode":138}
     */

    private int status;
    private ResultBean result;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * location : {"lng":112.89256199999997,"lat":23.107683010701553}
         * formatted_address : 广东省佛山市南海区心溪古道
         * business :
         * addressComponent : {"country":"中国","country_code":0,"country_code_iso":"CHN","country_code_iso2":"CN","province":"广东省","city":"佛山市","city_level":2,"district":"南海区","town":"","adcode":"440605","street":"心溪古道","street_number":"","direction":"","distance":""}
         * pois : [{"addr":"佛山市南海区","cp":" ","direction":"东南","distance":"283","name":"心溪","poiType":"行政地标","point":{"x":112.89147272743556,"y":23.109811115715942},"tag":"行政地标;村庄","tel":"","uid":"631c4157a26e0a6131f71d76","zip":"","parent_poi":{"name":"","tag":"","addr":"","point":{"x":0,"y":0},"direction":"","distance":"","uid":""}},{"addr":"丹灶镇国家生态工业区银海大道外资工业村8号","cp":" ","direction":"东","distance":"432","name":"昼田汽车部件公司","poiType":"公司企业","point":{"x":112.8888137431269,"y":23.10862280402247},"tag":"公司企业;公司","tel":"","uid":"d0cbaa53527fbccd95f08cd0","zip":"","parent_poi":{"name":"","tag":"","addr":"","point":{"x":0,"y":0},"direction":"","distance":"","uid":""}},{"addr":"丹灶镇生态工业示范园区银海大道外资工业村7号","cp":" ","direction":"东","distance":"459","name":"勇一精锻公司","poiType":"公司企业","point":{"x":112.88850831925362,"y":23.10696081178378},"tag":"公司企业;公司","tel":"","uid":"546043559f7f66bd8bb9882a","zip":"","parent_poi":{"name":"","tag":"","addr":"","point":{"x":0,"y":0},"direction":"","distance":"","uid":""}},{"addr":"丹灶镇南海生态国家示范工业园银海大道北外资工业村","cp":" ","direction":"东","distance":"470","name":"久田(佛山)汽车配件有限公司","poiType":"公司企业","point":{"x":112.88841848870264,"y":23.108456605734915},"tag":"公司企业;公司","tel":"","uid":"97555d9f72ecebc9d62ce2bc","zip":"","parent_poi":{"name":"","tag":"","addr":"","point":{"x":0,"y":0},"direction":"","distance":"","uid":""}},{"addr":"佛山市南海区外资工业村4号1楼","cp":" ","direction":"东南","distance":"498","name":"佛山中检南方检测有限公司","poiType":"公司企业","point":{"x":112.88906526866961,"y":23.110268155842476},"tag":"公司企业;公司","tel":"","uid":"96dade53e1c614ce8bfc066e","zip":"","parent_poi":{"name":"","tag":"","addr":"","point":{"x":0,"y":0},"direction":"","distance":"","uid":""}},{"addr":"丹灶镇南海国家生态工业示范园银海大道外资工业村6号","cp":" ","direction":"东","distance":"499","name":"富士气门公司","poiType":"公司企业","point":{"x":112.88814001399464,"y":23.10696081178378},"tag":"公司企业;公司","tel":"","uid":"1b0adbfbce0d834f256e989f","zip":"","parent_poi":{"name":"","tag":"","addr":"","point":{"x":0,"y":0},"direction":"","distance":"","uid":""}},{"addr":"丹灶镇国家生态工业示范园外资工业村b幢","cp":" ","direction":"东南","distance":"675","name":"远州佛山汽车配件有限公司","poiType":"汽车服务","point":{"x":112.88787950539684,"y":23.1112570190941},"tag":"汽车服务;汽车配件","tel":"","uid":"30ba0450407ea3e929fc487e","zip":"","parent_poi":{"name":"","tag":"","addr":"","point":{"x":0,"y":0},"direction":"","distance":"","uid":""}},{"addr":"广东省佛山市南海区丹灶镇月季路金石员工大厦","cp":" ","direction":"东南","distance":"716","name":"万民百货","poiType":"购物","point":{"x":112.88850831925362,"y":23.112304042742537},"tag":"购物;超市","tel":"","uid":"0d0e70f2e0c80579bca822e6","zip":"","parent_poi":{"name":"","tag":"","addr":"","point":{"x":0,"y":0},"direction":"","distance":"","uid":""}},{"addr":"月季路与银海大道北交叉口东南50米","cp":" ","direction":"东南","distance":"754","name":"金石员工大厦","poiType":"房地产","point":{"x":112.8879693359478,"y":23.11229573306356},"tag":"房地产;住宅区","tel":"","uid":"aeb0275ede5544b9e115f944","zip":"","parent_poi":{"name":"","tag":"","addr":"","point":{"x":0,"y":0},"direction":"","distance":"","uid":""}}]
         * roads : []
         * poiRegions : []
         * sematic_description : 心溪东南283米
         * cityCode : 138
         */

        private LocationBean location;
        private String formatted_address;
        private String business;
        private AddressComponentBean addressComponent;
        private String sematic_description;
        private int cityCode;
        private List<PoisBean> pois;
        private List<?> roads;
        private List<?> poiRegions;

        public LocationBean getLocation() {
            return location;
        }

        public void setLocation(LocationBean location) {
            this.location = location;
        }

        public String getFormatted_address() {
            return formatted_address;
        }

        public void setFormatted_address(String formatted_address) {
            this.formatted_address = formatted_address;
        }

        public String getBusiness() {
            return business;
        }

        public void setBusiness(String business) {
            this.business = business;
        }

        public AddressComponentBean getAddressComponent() {
            return addressComponent;
        }

        public void setAddressComponent(AddressComponentBean addressComponent) {
            this.addressComponent = addressComponent;
        }

        public String getSematic_description() {
            return sematic_description;
        }

        public void setSematic_description(String sematic_description) {
            this.sematic_description = sematic_description;
        }

        public int getCityCode() {
            return cityCode;
        }

        public void setCityCode(int cityCode) {
            this.cityCode = cityCode;
        }

        public List<PoisBean> getPois() {
            return pois;
        }

        public void setPois(List<PoisBean> pois) {
            this.pois = pois;
        }

        public List<?> getRoads() {
            return roads;
        }

        public void setRoads(List<?> roads) {
            this.roads = roads;
        }

        public List<?> getPoiRegions() {
            return poiRegions;
        }

        public void setPoiRegions(List<?> poiRegions) {
            this.poiRegions = poiRegions;
        }

        public static class LocationBean {
            /**
             * lng : 112.89256199999997
             * lat : 23.107683010701553
             */

            private double lng;
            private double lat;

            public double getLng() {
                return lng;
            }

            public void setLng(double lng) {
                this.lng = lng;
            }

            public double getLat() {
                return lat;
            }

            public void setLat(double lat) {
                this.lat = lat;
            }
        }

        public static class AddressComponentBean {
            /**
             * country : 中国
             * country_code : 0
             * country_code_iso : CHN
             * country_code_iso2 : CN
             * province : 广东省
             * city : 佛山市
             * city_level : 2
             * district : 南海区
             * town :
             * adcode : 440605
             * street : 心溪古道
             * street_number :
             * direction :
             * distance :
             */

            private String country;
            private int country_code;
            private String country_code_iso;
            private String country_code_iso2;
            private String province;
            private String city;
            private int city_level;
            private String district;
            private String town;
            private String adcode;
            private String street;
            private String street_number;
            private String direction;
            private String distance;

            public String getCountry() {
                return country;
            }

            public void setCountry(String country) {
                this.country = country;
            }

            public int getCountry_code() {
                return country_code;
            }

            public void setCountry_code(int country_code) {
                this.country_code = country_code;
            }

            public String getCountry_code_iso() {
                return country_code_iso;
            }

            public void setCountry_code_iso(String country_code_iso) {
                this.country_code_iso = country_code_iso;
            }

            public String getCountry_code_iso2() {
                return country_code_iso2;
            }

            public void setCountry_code_iso2(String country_code_iso2) {
                this.country_code_iso2 = country_code_iso2;
            }

            public String getProvince() {
                return province;
            }

            public void setProvince(String province) {
                this.province = province;
            }

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public int getCity_level() {
                return city_level;
            }

            public void setCity_level(int city_level) {
                this.city_level = city_level;
            }

            public String getDistrict() {
                return district;
            }

            public void setDistrict(String district) {
                this.district = district;
            }

            public String getTown() {
                return town;
            }

            public void setTown(String town) {
                this.town = town;
            }

            public String getAdcode() {
                return adcode;
            }

            public void setAdcode(String adcode) {
                this.adcode = adcode;
            }

            public String getStreet() {
                return street;
            }

            public void setStreet(String street) {
                this.street = street;
            }

            public String getStreet_number() {
                return street_number;
            }

            public void setStreet_number(String street_number) {
                this.street_number = street_number;
            }

            public String getDirection() {
                return direction;
            }

            public void setDirection(String direction) {
                this.direction = direction;
            }

            public String getDistance() {
                return distance;
            }

            public void setDistance(String distance) {
                this.distance = distance;
            }
        }

        public static class PoisBean {
            /**
             * addr : 佛山市南海区
             * cp :
             * direction : 东南
             * distance : 283
             * name : 心溪
             * poiType : 行政地标
             * point : {"x":112.89147272743556,"y":23.109811115715942}
             * tag : 行政地标;村庄
             * tel :
             * uid : 631c4157a26e0a6131f71d76
             * zip :
             * parent_poi : {"name":"","tag":"","addr":"","point":{"x":0,"y":0},"direction":"","distance":"","uid":""}
             */

            private String addr;
            private String cp;
            private String direction;
            private String distance;
            private String name;
            private String poiType;
            private PointBean point;
            private String tag;
            private String tel;
            private String uid;
            private String zip;
            private ParentPoiBean parent_poi;

            public String getAddr() {
                return addr;
            }

            public void setAddr(String addr) {
                this.addr = addr;
            }

            public String getCp() {
                return cp;
            }

            public void setCp(String cp) {
                this.cp = cp;
            }

            public String getDirection() {
                return direction;
            }

            public void setDirection(String direction) {
                this.direction = direction;
            }

            public String getDistance() {
                return distance;
            }

            public void setDistance(String distance) {
                this.distance = distance;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getPoiType() {
                return poiType;
            }

            public void setPoiType(String poiType) {
                this.poiType = poiType;
            }

            public PointBean getPoint() {
                return point;
            }

            public void setPoint(PointBean point) {
                this.point = point;
            }

            public String getTag() {
                return tag;
            }

            public void setTag(String tag) {
                this.tag = tag;
            }

            public String getTel() {
                return tel;
            }

            public void setTel(String tel) {
                this.tel = tel;
            }

            public String getUid() {
                return uid;
            }

            public void setUid(String uid) {
                this.uid = uid;
            }

            public String getZip() {
                return zip;
            }

            public void setZip(String zip) {
                this.zip = zip;
            }

            public ParentPoiBean getParent_poi() {
                return parent_poi;
            }

            public void setParent_poi(ParentPoiBean parent_poi) {
                this.parent_poi = parent_poi;
            }

            public static class PointBean {
                /**
                 * x : 112.89147272743556
                 * y : 23.109811115715942
                 */

                private double x;
                private double y;

                public double getX() {
                    return x;
                }

                public void setX(double x) {
                    this.x = x;
                }

                public double getY() {
                    return y;
                }

                public void setY(double y) {
                    this.y = y;
                }
            }

            public static class ParentPoiBean {
                /**
                 * name :
                 * tag :
                 * addr :
                 * point : {"x":0,"y":0}
                 * direction :
                 * distance :
                 * uid :
                 */

                private String name;
                private String tag;
                private String addr;
                private PointBeanX point;
                private String direction;
                private String distance;
                private String uid;

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getTag() {
                    return tag;
                }

                public void setTag(String tag) {
                    this.tag = tag;
                }

                public String getAddr() {
                    return addr;
                }

                public void setAddr(String addr) {
                    this.addr = addr;
                }

                public PointBeanX getPoint() {
                    return point;
                }

                public void setPoint(PointBeanX point) {
                    this.point = point;
                }

                public String getDirection() {
                    return direction;
                }

                public void setDirection(String direction) {
                    this.direction = direction;
                }

                public String getDistance() {
                    return distance;
                }

                public void setDistance(String distance) {
                    this.distance = distance;
                }

                public String getUid() {
                    return uid;
                }

                public void setUid(String uid) {
                    this.uid = uid;
                }

                public static class PointBeanX {
                    /**
                     * x : 0
                     * y : 0
                     */

                    private int x;
                    private int y;

                    public int getX() {
                        return x;
                    }

                    public void setX(int x) {
                        this.x = x;
                    }

                    public int getY() {
                        return y;
                    }

                    public void setY(int y) {
                        this.y = y;
                    }
                }
            }
        }
    }
}
