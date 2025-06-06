package pe.edu.upc;

import com.structurizr.model.*;
import com.structurizr.view.*;

public class APIRestComponentDiagram {
    private final C4 c4;
    private final ContextDiagram contextDiagram;
    private final ContainerDiagram containerDiagram;
    private final String componentTag = "Component";
    private Component Aircrafts;
    private Component Airports;
    private Component Flights;
    private Component Monitoring;
    private Component Vaccines;
    private Component Security;
    private Component SharedKernel;

    public APIRestComponentDiagram(C4 c4, ContextDiagram contextDiagram, ContainerDiagram containerDiagram) {
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
        Aircrafts = containerDiagram.getApiRest().addComponent("Aircrafts", "", "NodeJS (NestJS)");
        Airports = containerDiagram.getApiRest().addComponent("Airports", "", "NodeJS (NestJS)");
        Flights = containerDiagram.getApiRest().addComponent("Flights", "", "NodeJS (NestJS)");
        Monitoring = containerDiagram.getApiRest().addComponent("Monitoring", "", "NodeJS (NestJS)");
        Vaccines = containerDiagram.getApiRest().addComponent("Vaccines", "", "NodeJS (NestJS)");
        Security = containerDiagram.getApiRest().addComponent("Security", "", "NodeJS (NestJS)");
        SharedKernel = containerDiagram.getApiRest().addComponent("Shared Kernel", "", "NodeJS (NestJS)");
    }

    private void addRelationships() {
        Aircrafts.uses(containerDiagram.getDatabase(), "Usa", "");
        Aircrafts.uses(this.SharedKernel, "Usa", "");

        Airports.uses(containerDiagram.getDatabase(), "Usa", "");
        Airports.uses(this.SharedKernel, "Usa", "");

        Flights.uses(containerDiagram.getDatabase(), "Usa", "");
        Flights.uses(this.SharedKernel, "Usa", "");

        Monitoring.uses(containerDiagram.getDatabase(), "Usa", "");
        Monitoring.uses(this.SharedKernel, "Usa", "");
        Monitoring.uses(contextDiagram.getGoogleMaps(), "Usa", "");
        Monitoring.uses(contextDiagram.getAircraftSystem(), "Usa", "");

        Vaccines.uses(containerDiagram.getDatabase(), "Usa", "");
        Vaccines.uses(this.SharedKernel, "Usa", "");

        Security.uses(containerDiagram.getDatabase(), "Usa", "");
        Security.uses(this.SharedKernel, "Usa", "");
    }

    private void applyStyles() {
        setTags();
        Styles styles = c4.getViewSet().getConfiguration().getStyles();
        styles.addElementStyle(this.componentTag)
                .shape(Shape.Component)
                .background("#facc2e")
                .icon("");
    }

    private void setTags() {
        Aircrafts.addTags(this.componentTag);
        Airports.addTags(this.componentTag);
        Flights.addTags(this.componentTag);
        Monitoring.addTags(this.componentTag);
        Vaccines.addTags(this.componentTag);
        Security.addTags(this.componentTag);
        SharedKernel.addTags(this.componentTag);
    }

    private void createView() {
        String title = "API Rest Component Diagram";
        ComponentView componentView = c4.getViewSet().createComponentView(containerDiagram.getApiRest(), title, title);
        componentView.setTitle(title);
        componentView.add(containerDiagram.getDatabase());
        componentView.add(contextDiagram.getAircraftSystem());
        componentView.add(contextDiagram.getGoogleMaps());
        componentView.addAllComponents();
    }

    public Component getAircrafts() {
        return Aircrafts;
    }

    public Component getAirports() {
        return Airports;
    }

    public Component getFlights() {
        return Flights;
    }

    public Component getMonitoring() {
        return Monitoring;
    }

    public Component getVaccines() {
        return Vaccines;
    }

    public Component getSecurity() {
        return Security;
    }

    public Component getSharedKernel() {
        return SharedKernel;
    }
}