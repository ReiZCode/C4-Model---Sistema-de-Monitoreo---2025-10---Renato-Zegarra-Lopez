package pe.edu.upc;

import com.structurizr.model.*;
import com.structurizr.view.*;

public class VaccinesBCComponentDiagram {
    private final C4 c4;
    private final ContainerDiagram containerDiagram;
    private final String componentTag = "Component";
    private Component domainLayer;
    private Component interfaceLayer;
    private Component applicationLayer;
    private Component infrastructureLayer;

    public VaccinesBCComponentDiagram(C4 c4, ContainerDiagram containerDiagram) {
        this.c4 = c4;
        this.containerDiagram = containerDiagram;
    }

    public void generate() {
        addComponents();
        addRelationships();
        applyStyles();
        createView();
    }

    private void addComponents() {
        domainLayer = containerDiagram.getApiRest().addComponent("Domain Layer Vaccines", "", "NodeJS (NestJS)");
        interfaceLayer = containerDiagram.getApiRest().addComponent("Interface Layer Vaccines", "", "NodeJS (NestJS)");
        applicationLayer = containerDiagram.getApiRest().addComponent("Application Layer Vaccines", "", "NodeJS (NestJS)");
        infrastructureLayer = containerDiagram.getApiRest().addComponent("Infrastructure Layer Vaccines", "", "NodeJS (NestJS)");
    }

    private void addRelationships() {
        interfaceLayer.uses(applicationLayer, "", "");
        applicationLayer.uses(domainLayer, "", "");
        applicationLayer.uses(infrastructureLayer, "", "");
        infrastructureLayer.uses(domainLayer, "", "");
        infrastructureLayer.uses(containerDiagram.getDatabase(), "Usa", "");
    }

    private void applyStyles() {
        setTags();
    }

    private void setTags() {
        domainLayer.addTags(this.componentTag);
        interfaceLayer.addTags(this.componentTag);
        applicationLayer.addTags(this.componentTag);
        infrastructureLayer.addTags(this.componentTag);
    }

    private void createView() {
        String title = "Vaccines BC Component Diagram";
        ComponentView componentView = c4.getViewSet().createComponentView(containerDiagram.getApiRest(), title, title);
        componentView.setTitle(title);
        componentView.add(containerDiagram.getDatabase());
        componentView.add(this.domainLayer);
        componentView.add(this.interfaceLayer);
        componentView.add(this.applicationLayer);
        componentView.add(this.infrastructureLayer);
    }
}