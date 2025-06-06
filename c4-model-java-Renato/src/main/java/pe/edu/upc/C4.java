package pe.edu.upc;

import com.structurizr.*;
import com.structurizr.api.*;
import com.structurizr.model.*;
import com.structurizr.view.*;

public class C4 {
    private final long workspaceId = 0;
    private final String apiKey = "";
    private final String apiSecret = "";
    private WorkspaceApiClient structurizrClient;
    private Workspace workspace;
    private Model model;
    private ViewSet viewSet;

    public C4() {
        String workspaceName = "Software Design & Patterns - C4 Model - Sistema de Monitoreo - 2025-10";
        String workspaceDescription = "Sistema de Monitoreo del Traslado Aéreo de Vacunas SARS-CoV-2";
        structurizrClient = new WorkspaceApiClient(apiKey, apiSecret);
        workspace = new Workspace(workspaceName, workspaceDescription);
        model = workspace.getModel();
        viewSet = workspace.getViews();
    }

    public void generate() throws StructurizrClientException {
        ContextDiagram contextDiagram = new ContextDiagram(this);
        ContainerDiagram containerDiagram = new ContainerDiagram(this, contextDiagram);

        APIRestComponentDiagram apiRestComponentDiagram = new APIRestComponentDiagram(this, contextDiagram, containerDiagram);

        MonitoringComponentDiagram monitoringComponentDiagram = new MonitoringComponentDiagram(this, contextDiagram, containerDiagram);
        SecurityBCComponentDiagram securityComponentDiagram = new SecurityBCComponentDiagram(this, containerDiagram);
        FlightsBCComponentDiagram flightPlanningComponentDiagram = new FlightsBCComponentDiagram(this, containerDiagram);
        AirportsBCComponentDiagram airportComponentDiagram = new AirportsBCComponentDiagram(this, containerDiagram);
        AircraftsBCComponentDiagram aircraftInventoryComponentDiagram = new AircraftsBCComponentDiagram(this, containerDiagram);
        VaccinesBCComponentDiagram vaccinesInventoryComponentDiagram = new VaccinesBCComponentDiagram(this, containerDiagram);

        contextDiagram.generate();
        containerDiagram.generate();
        apiRestComponentDiagram.generate();
        monitoringComponentDiagram.generate();
        securityComponentDiagram.generate();
        flightPlanningComponentDiagram.generate();
        airportComponentDiagram.generate();
        aircraftInventoryComponentDiagram.generate();
        vaccinesInventoryComponentDiagram.generate();
        structurizrClient.putWorkspace(workspaceId, workspace);
    }

    public WorkspaceApiClient getStructurizrClient() {
        return structurizrClient;
    }

    public Workspace getWorkspace() {
        return workspace;
    }

    public Model getModel() {
        return model;
    }

    public ViewSet getViewSet() {
        return viewSet;
    }
}