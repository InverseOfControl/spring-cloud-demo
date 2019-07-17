
package com.gaohx.springcloud.practice.domain;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlNs;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "soapenv:Envelope",namespace = "")
// @XmlType(propOrder = {"header", "body"})
public class Country {

    private String header;

    public String getHeader() {
        return header;
    }

    @XmlElement(name = "soapenv:Header")
    public void setHeader(String header) {
        this.header = header;
    }

    private Body body = new Body();

    public Body getBody() {
        return body;
    }

    @XmlElement(name = "soapenv:Body")
    public void setBody(Body body) {
        this.body = body;
    }

    public static class Body {
        private IfService IfService;

        public Country.IfService getIfService() {
            return IfService;
        }
        @XmlElement(name = "base:IfService")
        public void setIfService(Country.IfService ifService) {
            IfService = ifService;
        }
    }

    public static class IfService {
        private String ifUser;
        private String ifPass;
        private String ifCode;
        private String ifEvent;
        private String info;

        public String getIfUser() {
            return ifUser;
        }
        @XmlElement(name = "base:ifUser")
        public void setIfUser(String ifUser) {
            this.ifUser = ifUser;
        }

        public String getIfPass() {
            return ifPass;
        }
        @XmlElement(name = "base:ifPass")
        public void setIfPass(String ifPass) {
            this.ifPass = ifPass;
        }

        public String getIfCode() {
            return ifCode;
        }
        @XmlElement(name = "base:ifCode")
        public void setIfCode(String ifCode) {
            this.ifCode = ifCode;
        }

        public String getIfEvent() {
            return ifEvent;
        }
        @XmlElement(name = "base:ifEvent")
        public void setIfEvent(String ifEvent) {
            this.ifEvent = ifEvent;
        }

        public String getInfo() {
            return info;
        }
        @XmlElement(name = "base:info")
        public void setInfo(String info) {
            this.info = info;
        }
    }
}
