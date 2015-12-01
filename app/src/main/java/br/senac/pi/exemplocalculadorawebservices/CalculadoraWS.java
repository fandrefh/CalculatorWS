package br.senac.pi.exemplocalculadorawebservices;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

/**
 * Created by Note on 30/11/2015.
 */
public class CalculadoraWS {

    public CalculadoraWS() {}

    public int add(int i, int j) throws IOException, XmlPullParserException {
        SoapObject soap = new SoapObject("http://calculator.me.org/", "add");
        soap.addProperty("i", i);
        soap.addProperty("j", j);
        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.setOutputSoapObject(soap);
        HttpTransportSE transportSE = new HttpTransportSE("http://10.19.9.2:8080/CalculatorApp/CalculatorWSService?wsdl");
        transportSE.call("add", envelope);
        Object resultado = envelope.getResponse();
        return Integer.parseInt(resultado.toString());
    }
}
