@XmlSchema(
        xmlns = {
                @XmlNs(
                        prefix = "soapenv",
                        namespaceURI = "http://schemas.xmlsoap.org/soap/envelope/"
                ),
                @XmlNs(
                        prefix = "base",
                        namespaceURI = "http://base.webservice.ctsh.com"
                )
        },
        elementFormDefault = XmlNsForm.QUALIFIED)
package com.gaohx.springcloud.practice.domain;

import javax.xml.bind.annotation.XmlNs;
import javax.xml.bind.annotation.XmlNsForm;
import javax.xml.bind.annotation.XmlSchema;