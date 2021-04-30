grammar ArchCNL;

model:
	sentence*;

sentence:
	everyRule | onlyCanRule | conditionalRule | negationRule | factStatement
;

everyRule:
	EVERY conceptExpression (mustRuleType | canOnlyRuleType | cardinalityRuleType | subConceptRuleType)
;

negationRule:
	nothing | (NO conceptExpression CAN object) DOT
;

anything:
	relation ANYTHING
;

nothing:
	NOTHING CAN object DOT
;

conditionalRule:
	IF conceptExpression objectRelation conceptExpression COMMA THEN IT MUST objectRelation THIS conceptExpression DOT
;

onlyCanRule:
	ONLY conceptExpression CAN object DOT
;

subConceptRuleType:
	MUST BE conceptExpression DOT
;

mustRuleType:
	MUST object DOT
;

object:
	(anything) | (objectConceptExpression (andObjectConceptExpression|orObjectConceptExpression)*)
;

canOnlyRuleType:
	CANONLY object DOT
;

//TODO: must anstatt can. Problem: Konflikt mit MustRuleType
cardinalityRuleType:
	CAN object DOT
;

objectConceptExpression:
	(relation ((ATMOST | ATLEAST | EXACTLY)  INT)? conceptExpression) | (datatypeRelation dataStatement) 
;

andObjectConceptExpression:
	AND objectConceptExpression
;

orObjectConceptExpression:
	OR objectConceptExpression
;


relation:
	objectRelation | datatypeRelation 
;

datatypeRelation:
	RELATION_NAME EQUALTO
;

objectRelation:
	RELATION_NAME
;

conceptExpression:
	(A|AN)? concept thatExpression* 
;

thatExpression:
	THAT '(' statementList+ ')'
;

statementList:
	(AND)? (relation (conceptExpression | dataStatement | variableStatement))
;


variableStatement:
	concept variable
;

dataStatement:
	STRING | INT
;

factStatement:
	'Fact' ':' (conceptAssertion | roleAssertion) DOT
	
;

conceptAssertion:
	NAME IS (A|AN) concept DOT
;

roleAssertion:
	(objectPropertyAssertion | datatypePropertyAssertion ) DOT
;

datatypePropertyAssertion:
	NAME datatypeRelation (STRING|INT)
;

objectPropertyAssertion:
	NAME objectRelation NAME
;

concept:
	NAME;
	
variable:
	VARIABLE_NAME;

// Keywords

EVERY: 'Every';
NOTHING: 'Nothing';
NO: 'No';
IF: 'If';
ONLY: 'Only';
CAN: 'can';
CANONLY: 'can-only';
THEN: 'then';
IT: 'it';
MUST: 'must';
THIS: 'this';
BE: 'be';
AND: 'and';
OR: 'or';
ANYTHING: 'anything';
ATMOST: 'at-most';
ATLEAST: 'at-least';
EXACTLY: 'exactly';
EQUALTO: 'equal-to';
A: 'a';
AN: 'an';
THAT: 'that';
DOT: '.';
COMMA: ',';
IS: 'is';

RELATION_NAME:
	('a'..'z')(('A'..'Z')|('a'..'z'))+;

NAME:
	('A'..'Z') (('A'..'Z') | ('a'..'z'))+;

VARIABLE_NAME:
	('A'..'Z')
;

INT:
	[0-9]+;

STRING:
	[a-zA-Z]+;

WS   : [ \t\r\n]+ -> skip ;
