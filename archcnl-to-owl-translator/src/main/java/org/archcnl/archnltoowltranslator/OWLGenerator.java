package org.archcnl.archnltoowltranslator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.archcnl.ArchCNLBaseListener;
import org.archcnl.ArchCNLParser.ModelContext;
import org.archcnl.ArchCNLParser.NegationRuleContext;
import org.archcnl.ArchCNLParser.SentenceContext;
import org.archcnl.common.datatypes.RuleType;
import org.archcnl.owlcreator.api.APIFactory;
import org.archcnl.owlcreator.api.OntologyAPI;

public class OWLGenerator extends ArchCNLBaseListener {
	private static final Logger LOG = LogManager.getLogger(OWLGenerator.class);
	private final String namespace = "http://www.arch-ont.org/ontologies/architecture.owl";
	private final OntologyAPI api = APIFactory.get();
	private static int id = 0;
	
	/**
	 * Represents the top level item
	 * Can contain multiple sentences
	 */
	@Override
	public void enterModel(ModelContext ctx) {
		LOG.trace("Entering model context");
		var filename = RuleTypeStorageSingleton.getInstance().getOutputFile();
		api.createOntology(filename, namespace);
	}
	@Override
	public void exitModel(ModelContext ctx) {
		api.removeOntology();
	}
	
	

	@Override
	public void enterSentence(SentenceContext ctx) {
		LOG.trace("Entering sentence context");
		id++;
	}
	
	@Override
	public void enterNegationRule(NegationRuleContext ctx) {
		LOG.trace("Entering negation context");
		
		var typeStorage = RuleTypeStorageSingleton.getInstance();
		typeStorage.storeTypeOfRule(id, RuleType.NEGATION);
	}
}
