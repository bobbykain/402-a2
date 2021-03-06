JAVAC=javac
JAVAC_FLAGS=-sourcepath .
JAVA=java
JAVA_FLAGS=
PARSER=${JAVA} ${JAVA_FLAGS} java_cup.Main
PARSER_FLAGS=-nopositions -expect 100
LEXER=${JAVA} ${JAVA_FLAGS} JLex.Main
LEXER_FLAGS=
all: test

test: absyn cpp_grammar/Yylex.class cpp_grammar/PrettyPrinter.class cpp_grammar/Test.class cpp_grammar/ComposVisitor.class cpp_grammar/AbstractVisitor.class cpp_grammar/FoldVisitor.class cpp_grammar/AllVisitor.class cpp_grammar/parser.class cpp_grammar/sym.class cpp_grammar/Test.class

.PHONY: absyn

%.class: %.java
	${JAVAC} ${JAVAC_FLAGS} $^

absyn: cpp_grammar/Absyn/Program.java cpp_grammar/Absyn/Prog.java cpp_grammar/Absyn/Function.java cpp_grammar/Absyn/Fun.java cpp_grammar/Absyn/Arg.java cpp_grammar/Absyn/Dec.java cpp_grammar/Absyn/ListFunction.java cpp_grammar/Absyn/ListStm.java cpp_grammar/Absyn/ListArg.java cpp_grammar/Absyn/ListIdent.java cpp_grammar/Absyn/Stm.java cpp_grammar/Absyn/SDecl.java cpp_grammar/Absyn/SExp.java cpp_grammar/Absyn/SReturn.java cpp_grammar/Absyn/SBlock.java cpp_grammar/Absyn/Exp.java cpp_grammar/Absyn/EInt.java cpp_grammar/Absyn/EStr.java cpp_grammar/Absyn/EId.java cpp_grammar/Absyn/ELs.java cpp_grammar/Absyn/EAss.java cpp_grammar/Absyn/ListExp.java cpp_grammar/Absyn/Type.java cpp_grammar/Absyn/Tint.java
	${JAVAC} ${JAVAC_FLAGS} $^

cpp_grammar/Yylex.java: cpp_grammar/Yylex
	${LEXER} ${LEXER_FLAGS} cpp_grammar/Yylex

cpp_grammar/parser.java cpp_grammar/sym.java: cpp_grammar/_cup.cup
	${PARSER} ${PARSER_FLAGS} cpp_grammar/_cup.cup
	mv parser.java sym.java cpp_grammar/

cpp_grammar/Yylex.class: cpp_grammar/Yylex.java cpp_grammar/parser.java cpp_grammar/sym.java

cpp_grammar/sym.class: cpp_grammar/sym.java

cpp_grammar/parser.class: cpp_grammar/parser.java cpp_grammar/sym.java

cpp_grammar/PrettyPrinter.class: cpp_grammar/PrettyPrinter.java

clean:
	rm -f cpp_grammar/Absyn/*.class cpp_grammar/*.class

distclean: vclean

vclean:
	 rm -f cpp_grammar/Absyn/Program.java cpp_grammar/Absyn/Prog.java cpp_grammar/Absyn/Function.java cpp_grammar/Absyn/Fun.java cpp_grammar/Absyn/Arg.java cpp_grammar/Absyn/Dec.java cpp_grammar/Absyn/ListFunction.java cpp_grammar/Absyn/ListStm.java cpp_grammar/Absyn/ListArg.java cpp_grammar/Absyn/ListIdent.java cpp_grammar/Absyn/Stm.java cpp_grammar/Absyn/SDecl.java cpp_grammar/Absyn/SExp.java cpp_grammar/Absyn/SReturn.java cpp_grammar/Absyn/SBlock.java cpp_grammar/Absyn/Exp.java cpp_grammar/Absyn/EInt.java cpp_grammar/Absyn/EStr.java cpp_grammar/Absyn/EId.java cpp_grammar/Absyn/ELs.java cpp_grammar/Absyn/EAss.java cpp_grammar/Absyn/ListExp.java cpp_grammar/Absyn/Type.java cpp_grammar/Absyn/Tint.java cpp_grammar/Absyn/Program.class cpp_grammar/Absyn/Prog.class cpp_grammar/Absyn/Function.class cpp_grammar/Absyn/Fun.class cpp_grammar/Absyn/Arg.class cpp_grammar/Absyn/Dec.class cpp_grammar/Absyn/ListFunction.class cpp_grammar/Absyn/ListStm.class cpp_grammar/Absyn/ListArg.class cpp_grammar/Absyn/ListIdent.class cpp_grammar/Absyn/Stm.class cpp_grammar/Absyn/SDecl.class cpp_grammar/Absyn/SExp.class cpp_grammar/Absyn/SReturn.class cpp_grammar/Absyn/SBlock.class cpp_grammar/Absyn/Exp.class cpp_grammar/Absyn/EInt.class cpp_grammar/Absyn/EStr.class cpp_grammar/Absyn/EId.class cpp_grammar/Absyn/ELs.class cpp_grammar/Absyn/EAss.class cpp_grammar/Absyn/ListExp.class cpp_grammar/Absyn/Type.class cpp_grammar/Absyn/Tint.class
	 rm -f cpp_grammar/Absyn/*.class
	 rmdir cpp_grammar/Absyn/
	 rm -f cpp_grammar/Yylex cpp_grammar/_cup.cup cpp_grammar/Yylex.java cpp_grammar/VisitSkel.java cpp_grammar/ComposVisitor.java cpp_grammar/AbstractVisitor.java cpp_grammar/FoldVisitor.java cpp_grammar/AllVisitor.java cpp_grammar/PrettyPrinter.java cpp_grammar/Skeleton.java cpp_grammar/Test.java cpp_grammar/parser.java cpp_grammar/sym.java cpp_grammar/*.class
	 rm -f Makefile
	 rmdir -p cpp_grammar/
