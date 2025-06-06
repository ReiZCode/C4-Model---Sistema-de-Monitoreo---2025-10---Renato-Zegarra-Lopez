package pe.edu.upc;

import com.structurizr.model.*;
import com.structurizr.view.*;

public class MonitoringComponentDiagram {
    private final C4 c4;
    private final ContextDiagram contextDiagram;
    private final ContainerDiagram containerDiagram;
    private final String componentTag = "Component";
    private Component domainLayer;
    private Component interfaceLayer;
    private Component applicationLayer;
    private Component infrastructureLayer;
    private Component googleMapsConnector;

    public MonitoringComponentDiagram(C4 c4, ContextDiagram contextDiagram, ContainerDiagram containerDiagram) {
        this.c4 = c4;
        this.contextDiagram = contextDiagram;
        this.containerDiagram = containerDiagram;
    }

    public void generate() {
        addComponents();
        addRelationships();
        applyStyles();
        createView();
    }

    private void addComponents() {
        domainLayer = containerDiagram.getApiRest().addComponent("Domain Layer Monitoring", "", "NodeJS (NestJS)");
        interfaceLayer = containerDiagram.getApiRest().addComponent("Interface Layer Monitoring", "", "NodeJS (NestJS)");
        applicationLayer = containerDiagram.getApiRest().addComponent("Application Layer Monitoring", "", "NodeJS (NestJS)");
        infrastructureLayer = containerDiagram.getApiRest().addComponent("Infrastructure Layer Monitoring", "", "NodeJS (NestJS)");
        googleMapsConnector = containerDiagram.getApiRest().addComponent("Google Maps Connector", "", "NodeJS (NestJS)");
    }

    private void addRelationships() {
        interfaceLayer.uses(applicationLayer, "", "");
        applicationLayer.uses(domainLayer, "", "");
        applicationLayer.uses(infrastructureLayer, "", "");
        infrastructureLayer.uses(domainLayer, "", "");
        infrastructureLayer.uses(containerDiagram.getDatabase(), "Usa", "");
        infrastructureLayer.uses(googleMapsConnector, "", "");
        googleMapsConnector.uses(contextDiagram.getGoogleMaps(), "", "JSON/HTTPS");
        infrastructureLayer.uses(contextDiagram.getAircraftSystem(), "JSON/HTTPS");
    }

    private void applyStyles() {
        setTags();
    }

    private void setTags() {
        domainLayer.addTags(this.componentTag);
        interfaceLayer.addTags(this.componentTag);
        applicationLayer.addTags(this.componentTag);
        infrastructureLayer.addTags(this.componentTag);
        googleMapsConnector.addTags(this.componentTag);
    }

    private void createView() {
        String title = "Monitoring BC Component Diagram";
        ComponentView componentView = c4.getViewSet().createComponentView(containerDiagram.getApiRest(), title, title);
        componentView.setTitle(title);
        componentView.add(containerDiagram.getDatabase());
        componentView.add(contextDiagram.getAircraftSystem());
        componentView.add(contextDiagram.getGoogleMaps());
        componentView.add(this.domainLayer);
        componentView.add(this.interfaceLayer);
        componentView.add(this.applicationLayer);
        componentView.add(this.infrastructureLayer);
        componentView.add(this.googleMapsConnector);
    }
}