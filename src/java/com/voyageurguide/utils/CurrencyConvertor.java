/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.voyageurguide.utils;

import com.sun.org.apache.xerces.internal.dom.DeferredAttrImpl;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author 10945
 */
public class CurrencyConvertor {

    private static Map<String, String> currencyMap;

    public static Map<String, String> getRates() {
        if (currencyMap != null && !currencyMap.isEmpty()) {
            return currencyMap;
        }

        Map<String, String> currency = new HashMap();
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            URL url = new URL("http://www.ecb.europa.eu/stats/eurofxref/eurofxref-daily.xml");
            InputStream is = url.openStream();
            int ptr = 0;
            StringBuffer buffer = new StringBuffer();
            while ((ptr = is.read()) != -1) {
                buffer.append((char) ptr);
            }
            System.out.println(buffer.toString());

            ByteArrayInputStream input = new ByteArrayInputStream(buffer.toString().getBytes("UTF-8"));
            Document doc = builder.parse(input);
            Element element = doc.getDocumentElement();

            NodeList nodeList = element.getElementsByTagName("Cube");

            for (int i = 0; i < nodeList.getLength(); i++) {
                NamedNodeMap attributes = nodeList.item(i).getAttributes();
                for (int j = 0; j < attributes.getLength(); j++) {
                    Node attr = attributes.item(j);
                    if (attr instanceof DeferredAttrImpl) {
                        DeferredAttrImpl impl = (DeferredAttrImpl) attr;

                        if (impl.getName().equals("currency")) {
//                            System.out.println(impl.getValue());
                            Node rate = attributes.item(++j);
//                            System.out.println(rate.getNodeValue());

                            currency.put(impl.getValue(), rate.getNodeValue());
                        }
                    }

                }
            }
            is.close();

        } catch (MalformedURLException ex) {
            Logger.getLogger(CurrencyConvertor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CurrencyConvertor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(CurrencyConvertor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(CurrencyConvertor.class.getName()).log(Level.SEVERE, null, ex);
        }

        currencyMap = currency;

        currencyMap.put("EUR", "1");
        return currencyMap;
    }

    public static List<String> getCurrencies() {
        Map<String, String> currencies = getRates();
        return new ArrayList<>(currencies.keySet());
    }

    public static String valueOf(String currency) {
        Map<String, String> currencies = getRates();

        return currencies.get(currency);
    }

    public static double convert(String fromCurrency, String toCurrency) {
        Map<String, String> currencies = getRates();
        double fromValue = Double.parseDouble(currencies.get(fromCurrency));
        double toValue = Double.parseDouble(currencies.get(toCurrency));

        return toValue / fromValue;
    }

    public static double convert(String fromCurrency, String toCurrency, double value) {
        Map<String, String> currencies = getRates();
        double fromValue = Double.parseDouble(currencies.get(fromCurrency));
        double toValue = Double.parseDouble(currencies.get(toCurrency));

        return (toValue / fromValue) * value;
    }

    public static void main(String[] args) {
        List<String> currencies = getCurrencies();
        currencies.stream().forEach(curr -> System.out.print(curr + ","));
        System.out.println("\n" + valueOf(Currency.JPY.toString()));
        System.out.println(convert(Currency.USD.toString(), Currency.INR.toString()));
        System.out.println(convert(Currency.USD.toString(), Currency.INR.toString(), 3));
    }

    enum Currency {
        USD,
        JPY,
        BGN,
        CZK,
        DKK,
        GBP,
        HUF,
        PLN,
        RON,
        SEK,
        CHF,
        NOK,
        HRK,
        RUB,
        TRY,
        AUD,
        BRL,
        CAD,
        CNY,
        HKD,
        IDR,
        ILS,
        INR,
        KRW,
        MXN,
        MYR,
        NZD,
        PHP,
        SGD,
        THB,
        ZAR
    }
}
