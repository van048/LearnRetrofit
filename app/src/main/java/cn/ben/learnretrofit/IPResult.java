package cn.ben.learnretrofit;

//{
//        "Status": 0,
//        "Description": "ok",
//        "Base_info": {
//          "country": "美国", //国家
//          "city": null, //城市
//           "county": null, //区、县
//           "isp": null, //运营商
//           "province": null, //省
//        },
//        "Net_info":{
//          "Is_ntp":0, //是否提供ntp服务
//          "Ntp_port":-1, //ntp端口号
//          "Is_dns":1, //是否提供dns服务
//          "Dns_port":53, //dns端口号
//          "Is_proxy":0, //是否提供proxy服务
//          "Proxy_port":-1, //proxy端口号
//          "Is_vpn":0, //是否提供vpn服务
//          "Vpn_port":-1, //vpn端口号
//        }
//}
@SuppressWarnings("unused")
public class IPResult {
    private int Status;
    private String Description;
    private BaseInfoEntity Base_info;
    private NetInfoEntity Net_info;

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public BaseInfoEntity getBase_info() {
        return Base_info;
    }

    public void setBase_info(BaseInfoEntity base_info) {
        Base_info = base_info;
    }

    public NetInfoEntity getNet_info() {
        return Net_info;
    }

    public void setNet_info(NetInfoEntity net_info) {
        Net_info = net_info;
    }

    private class NetInfoEntity {
        private int Is_ntp;
        private int Ntp_port;
        private int Is_dns;
        private int Dns_port;
        private int Is_proxy;
        private int Proxy_port;
        private int Is_vpn;
        private int Vpn_port;

        public int getIs_ntp() {
            return Is_ntp;
        }

        public void setIs_ntp(int is_ntp) {
            Is_ntp = is_ntp;
        }

        public int getNtp_port() {
            return Ntp_port;
        }

        public void setNtp_port(int ntp_port) {
            Ntp_port = ntp_port;
        }

        public int getIs_dns() {
            return Is_dns;
        }

        public void setIs_dns(int is_dns) {
            Is_dns = is_dns;
        }

        public int getDns_port() {
            return Dns_port;
        }

        public void setDns_port(int dns_port) {
            Dns_port = dns_port;
        }

        public int getIs_proxy() {
            return Is_proxy;
        }

        public void setIs_proxy(int is_proxy) {
            Is_proxy = is_proxy;
        }

        public int getProxy_port() {
            return Proxy_port;
        }

        public void setProxy_port(int proxy_port) {
            Proxy_port = proxy_port;
        }

        public int getIs_vpn() {
            return Is_vpn;
        }

        public void setIs_vpn(int is_vpn) {
            Is_vpn = is_vpn;
        }

        public int getVpn_port() {
            return Vpn_port;
        }

        public void setVpn_port(int vpn_port) {
            Vpn_port = vpn_port;
        }
    }

    public static class BaseInfoEntity {
        private String country;
        private String city;
        private String county;
        private String isp;
        private String province;

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getCounty() {
            return county;
        }

        public void setCounty(String county) {
            this.county = county;
        }

        public String getIsp() {
            return isp;
        }

        public void setIsp(String isp) {
            this.isp = isp;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }
    }
}
