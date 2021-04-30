package org.archcnl.archnltoowltranslator;

import java.io.IOException;
import java.util.BitSet;

import org.antlr.v4.runtime.ANTLRErrorListener;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.archcnl.ArchCNLBaseListener;
import org.archcnl.ArchCNLLexer;
import org.archcnl.ArchCNLParser;
import org.archcnl.common.datatypes.RuleType;
import org.architecture.cnl.RuleTypeStorageSingleton;

public class CNL2OWLGeneratorAntlr {
	private static final Logger LOG = LogManager.getLogger(CNL2OWLGeneratorAntlr.class);

    public RuleType transformCNLFile(String rulePath, String ontologyPath) {
    	try {
    		LOG.trace("start transforming file {} to {}", rulePath, ontologyPath);
    		RuleTypeStorageSingleton.getInstance().setOutputFile(ontologyPath);
            var charStream = CharStreams.fromFileName(rulePath);
        	var lexer = new ArchCNLLexer(charStream);
            var tokenStream = new CommonTokenStream(lexer);
            var parser = new ArchCNLParser(tokenStream);
            parser.addErrorListener(new ErrorListener());
            var tree = parser.model();
            var walker = new ParseTreeWalker();
            walker.walk(new OWLGenerator(), tree);
            LOG.trace("done transforming");
            return null;
    	} catch(IOException ex) {
    		LOG.error(ex);
    		return null;
    	}
        
    }
    
    private class ErrorListener extends BaseErrorListener {

		@Override
		public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine,
				String msg, RecognitionException e) {
			LOG.error("Parser detetced an error at line {}, position {}. Msg: {}, exception: {}", line, charPositionInLine, msg, e);
		}
    }
}
