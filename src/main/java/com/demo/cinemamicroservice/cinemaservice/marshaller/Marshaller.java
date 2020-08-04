package com.demo.cinemamicroservice.cinemaservice.marshaller;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.w3c.dom.Document;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.MarshalException;
import javax.xml.parsers.DocumentBuilderFactory;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Marshaller {

//    public static Document marshall(JAXBContext context, JAXBElement<?> element) throws MarshalException {
//        try {
//            Document document = DocumentBuilderFactory.newDefaultInstance().newDocumentBuilder().newDocument();
//            javax.xml.bind.Marshaller jaxbMarshaller = context.createMarshaller();
//
//        }

//    }
}
