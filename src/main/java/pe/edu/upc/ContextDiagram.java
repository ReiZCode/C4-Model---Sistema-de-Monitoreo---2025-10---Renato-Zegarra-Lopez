package pe.edu.upc;

import com.structurizr.model.*;
import com.structurizr.view.*;

public class ContextDiagram {
    private final C4 c4;
    private SoftwareSystem MonitoringSystem;
    private SoftwareSystem GoogleMaps;
    private SoftwareSystem AircraftSystem;
    private Person Ciudadano;
    private Person Admin;

    public ContextDiagram(C4 c4) {
        this.c4 = c4;
    }

    public void generate() {
        addElements();
        addRelationships();
        applyStyles();
        createView();
    }

    private void addElements() {
        addPeople();
        addSoftwareSystems();
    }

    private void addPeople() {
        Ciudadano = c4.getModel().addPerson("Ciudadano", "Ciudadano peruano.");
        Admin = c4.getModel().addPerson("Admin", "User Admin.");
    }

    private void addSoftwareSystems() {
        MonitoringSystem = c4.getModel().addSoftwareSystem("Monitoreo del Traslado Aéreo de Vacunas SARS-CoV-2", "Permite el seguimiento y monitoreo del traslado aéreo a nuestro país de las vacunas para la COVID-19.");
        GoogleMaps = c4.getModel().addSoftwareSystem("Google Maps", "Plataforma que ofrece una REST API de información geo referencial.");
        AircraftSystem = c4.getModel().addSoftwareSystem("Aircraft System", "Permite transmitir información en tiempo real por el avión del vuelo a nuestro sistema");
    }

    private void addRelationships() {
        Ciudadano.uses(MonitoringSystem, "Realiza consultas para mantenerse al tanto de la planificación de los vuelos hasta la llegada del lote de vacunas al Perú");
        Admin.uses(MonitoringSystem, "Realiza consultas para mantenerse al tanto de la planificación de los vuelos hasta la llegada del lote de vacunas al Perú");

        MonitoringSystem.uses(AircraftSystem, "Consulta información en tiempo real por el avión del vuelo");
        MonitoringSystem.uses(GoogleMaps, "Usa la API de google maps");
    }

    private void applyStyles() {
        setTags();

        Styles styles = c4.getViewSet().getConfiguration().getStyles();

        styles.addElementStyle("Ciudadano")
                .background("#0a60ff")
                .color("#ffffff")
                .shape(Shape.Person);

        styles.addElementStyle("Admin")
                .background("#aa60af")
                .color("#ffffff")
                .shape(Shape.Person);

        styles.addElementStyle("MonitoringSystem")
                .background("#008f39")
                .color("#ffffff")
                .shape(Shape.RoundedBox);

        styles.addElementStyle("GoogleMaps")
                .background("#90714c")
                .color("#ffffff")
                .shape(Shape.RoundedBox);

        styles.addElementStyle("AircraftSystem")
            .background("#2f95c7")
            .color("#ffffff")
            .shape(Shape.RoundedBox);
    }

    private void setTags() {
        Ciudadano.addTags("Ciudadano");
        Admin.addTags("Admin");

        MonitoringSystem.addTags("MonitoringSystem");
        GoogleMaps.addTags("GoogleMaps");
        AircraftSystem.addTags("AircraftSystem");
    }

    private void createView() {
        SystemContextView contextView = c4.getViewSet().createSystemContextView(MonitoringSystem, "Contexto", "Diagrama de Contexto");
        contextView.addAllSoftwareSystems();
        contextView.addAllPeople();
    }

    public SoftwareSystem getMonitoringSystem() {
        return MonitoringSystem;
    }

    public SoftwareSystem getGoogleMaps() {
        return GoogleMaps;
    }

    public SoftwareSystem getAircraftSystem() {
        return AircraftSystem;
    }

    public Person getCiudadano() {
        return Ciudadano;
    }

    public Person getAdmin() {
        return Admin;
    }
}