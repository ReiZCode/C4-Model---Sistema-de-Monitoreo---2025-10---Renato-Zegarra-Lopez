package pe.edu.upc;

import com.structurizr.model.*;
import com.structurizr.view.*;

public class ContainerDiagram {
    private final C4 c4;
    private final ContextDiagram contextDiagram;
    private Container MobileApplication;
    private Container WebApplication;
    private Container LandingPage;
    private Container ApiRest;
    private Container Database;

    public ContainerDiagram(C4 c4, ContextDiagram contextDiagram) {
        this.c4 = c4;
        this.contextDiagram = contextDiagram;
    }

    public void generate() {
        addContainers();
        addRelationships();
        applyStyles();
        createView();
    }

    private void addContainers() {
        MobileApplication = contextDiagram.getMonitoringSystem().addContainer("Mobile App", "Permite a los usuarios visualizar un dashboard con el resumen de toda la información del traslado de los lotes de vacunas.", "Swift UI");
        WebApplication = contextDiagram.getMonitoringSystem().addContainer("Web App", "Permite a los usuarios visualizar un dashboard con el resumen de toda la información del traslado de los lotes de vacunas.", "React");
        LandingPage = contextDiagram.getMonitoringSystem().addContainer("Landing Page", "", "React");
        ApiRest = contextDiagram.getMonitoringSystem().addContainer("API REST", "API REST", "NodeJS (NestJS) port 8080");
        Database = contextDiagram.getMonitoringSystem().addContainer("DB", "", "MySQL Server RDS AWS");
    }

    private void addRelationships() {
        contextDiagram.getCiudadano().uses(MobileApplication, "Consulta");
        contextDiagram.getCiudadano().uses(WebApplication, "Consulta");
        contextDiagram.getCiudadano().uses(LandingPage, "Consulta");

        contextDiagram.getAdmin().uses(MobileApplication, "Consulta");
        contextDiagram.getAdmin().uses(WebApplication, "Consulta");
        contextDiagram.getAdmin().uses(LandingPage, "Consulta");

        MobileApplication.uses(ApiRest, "API Request", "JSON/HTTPS");
        WebApplication.uses(ApiRest, "API Request", "JSON/HTTPS");

        ApiRest.uses(Database, "", "");
        ApiRest.uses(contextDiagram.getGoogleMaps(), "API Request", "JSON/HTTPS");
        ApiRest.uses(contextDiagram.getAircraftSystem(), "API Request", "JSON/HTTPS");
    }

    private void applyStyles() {
        setTags();
        Styles styles = c4.getViewSet().getConfiguration().getStyles();
        styles.addElementStyle(MobileApplication.getName())
                .background("#9d33d6")
                .color("#ffffff")
                .shape(Shape.MobileDevicePortrait)
                .icon("");

        styles.addElementStyle(WebApplication.getName())
                .background("#9d33d6")
                .color("#ffffff")
                .shape(Shape.WebBrowser)
                .icon("");

        styles.addElementStyle(LandingPage.getName())
                .background("#929000")
                .color("#ffffff")
                .shape(Shape.WebBrowser)
                .icon("");

        styles.addElementStyle(ApiRest.getName())
                .shape(Shape.RoundedBox)
                .background("#0000ff")
                .color("#ffffff")
                .icon("");

        styles.addElementStyle(Database.getName())
                .shape(Shape.Cylinder)
                .background("#ff0000")
                .color("#ffffff")
                .icon("");

    }

    private void setTags() {
        MobileApplication.addTags(MobileApplication.getName());
        WebApplication.addTags(WebApplication.getName());
        LandingPage.addTags(LandingPage.getName());
        ApiRest.addTags(ApiRest.getName());
        Database.addTags(Database.getName());
    }

    private void createView() {
        ContainerView containerView = c4.getViewSet().createContainerView(contextDiagram.getMonitoringSystem(), "Contenedor", "Diagrama de Contenedores");
        containerView.addAllElements();
    }

    public Container getMobileApplication() {
        return MobileApplication;
    }

    public Container getWebApplication() {
        return WebApplication;
    }

    public Container getLandingPage() {
        return LandingPage;
    }

    public Container getApiRest() {
        return ApiRest;
    }

    public Container getDatabase() {
        return Database;
    }
}