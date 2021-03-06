package com.democracyapps.cnp.graphanalyzer.tasks;

import com.democracyapps.cnp.graphanalyzer.Main;
import com.democracyapps.cnp.graphanalyzer.dataproviders.GraphDataProvider;
import com.democracyapps.cnp.graphanalyzer.graph.AdjMatrixGraph;
import com.democracyapps.cnp.graphanalyzer.graph.Graph;
import org.json.simple.JSONObject;

import java.io.IOException;
import java.util.logging.Logger;

public class TestingGraphTask extends Task {
    JSONObject dataProviderSpecification = null;
    JSONObject analysisSpecification = null;
    private Logger logger;

    public TestingGraphTask(JSONObject taskConfiguration) throws IOException {
        super(taskConfiguration);

        dataProviderSpecification = (JSONObject) taskConfiguration.get("dataprovider");
        analysisSpecification     = (JSONObject) taskConfiguration.get("analysis");

        logger = Main.gaGetLogger();
    }

    @Override
    public void run() {
        Graph graph;
        GraphDataProvider gdp = new GraphDataProvider ();
        gdp.initialize(dataProviderSpecification);
        graph = (Graph)gdp.getData();
        AdjMatrixGraph adjMatrixGraph = new AdjMatrixGraph(graph);

        adjMatrixGraph.printAdjMatrix();
        System.out.println("there are currently " +
                Integer.toString(graph.countEdges()) + " edges");
    }
}

