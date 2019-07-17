package com.gaohx.springcloud.practice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.gaohx.springcloud.practice.domain.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import javax.xml.bind.*;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Properties;

@Controller
public class HtmlController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/index")
    public String index() throws IOException {
        Properties properties = new Properties();
        ClassPathResource classPathResource = new ClassPathResource("aaa.xml");
        properties.loadFromXML(classPathResource.getInputStream());

        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity httpEntity = new HttpEntity(httpHeaders);
        restTemplate.exchange("", HttpMethod.GET, httpEntity, String.class, new Object[0]);
        return "index";
    }

    public static void main(String[] args) throws JAXBException, IOException {
        xmlToObj();
        //objToXml();
    }

    public static void xmlToObj() throws JAXBException, IOException {
        ClassPathResource classPathResource = new ClassPathResource("aaa.xml");
        File file = classPathResource.getFile();

        JAXBContext jaxbContext = JAXBContext.newInstance( Country.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        QName qName = new QName("http://schemas.xmlsoap.org/soap/envelope/", "Envelope");
        Object obj = jaxbUnmarshaller.unmarshal(file);
        System.out.println("obj");
    }

    public static void objToXml() throws JAXBException {
        Country spain = new Country();
        spain.setHeader("");

        Country.Body body = spain.getBody();

        Country.IfService ifService = new Country.IfService();
        ifService.setIfCode("test");
        ifService.setIfPass("test");
        ifService.setIfUser("test");
        ifService.setIfEvent("");

        body.setIfService(ifService);

        /* init jaxb marshaler */
        JAXBContext jaxbContext = JAXBContext.newInstance(Country.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

        /*QName qName = new QName("http://schemas.xmlsoap.org/soap/envelope/", "Envelope");
        JAXBElement<Country> element = new JAXBElement<Country>(qName, Country.class, spain);*/

        /* set this flag to true to format the output */
        jaxbMarshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jaxbMarshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);

        /* marshaling of java objects in xml (output to file and standard output) */
        StringWriter writer = new StringWriter();
        jaxbMarshaller.marshal(spain, writer);
        System.out.println(writer);
    }
}
