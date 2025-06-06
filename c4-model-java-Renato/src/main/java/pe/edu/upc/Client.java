package pe.edu.upc;

import com.structurizr.api.StructurizrClientException;

public class Client {
    public static void main(String[] args) throws StructurizrClientException {
        C4 c4 = new C4();
        c4.generate();
    }
}