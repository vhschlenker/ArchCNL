package core;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.jena.ontology.DatatypeProperty;
import org.apache.jena.ontology.Individual;
import org.apache.jena.ontology.ObjectProperty;
import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.rdf.model.ModelFactory;

public class GeneralSoftwareArtifactOntology {
	private OntModel model;
	private GeneralSoftwareArtifactClassesAndProperties classesAndProperties;
	private long artifactId;
	

	public GeneralSoftwareArtifactOntology(InputStream ontologyInputStream) {
		loadOntology(ontologyInputStream);
		classesAndProperties = new GeneralSoftwareArtifactClassesAndProperties();
	}

	private void loadOntology(InputStream ontologyInpuStream) {
		model = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM, null);
		model.read(ontologyInpuStream, null);
	}
	
	public void setSoftwareArtifactFileContainsSoftwareArtifact(Individual artifact, Individual file) {
		ObjectProperty property = classesAndProperties.getFileContainsProperty(model);
		artifact.addProperty(property, file);
	}
	
	public Individual getSoftwareArtifactFileIndividual() {
		return classesAndProperties.getSoftwareArtifactFileIndividual(model, artifactId++);
	}
	
	public void setHasFilePath(Individual fileIndividual, String filePath) {
		DatatypeProperty property = classesAndProperties.getHasPathProperty(model);
		fileIndividual.addLiteral(property, filePath);
	}

	public OntModel getOntology() {
		return model;
	}
}