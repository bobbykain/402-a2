#ifndef SKELETON_HEADER
#define SKELETON_HEADER
/* You might want to change the above name. */

#include "Absyn.h"


void visitProgram(Program p);
void visitFunction(Function p);
void visitArg(Arg p);
void visitListFunction(ListFunction p);
void visitListStm(ListStm p);
void visitListArg(ListArg p);
void visitStm(Stm p);
void visitExp(Exp p);
void visitType(Type p);
void visitQualId(QualId p);

void visitId(Id p);void visitIds(Ids p);
void visitIdent(Ident i);
void visitInteger(Integer i);
void visitDouble(Double d);
void visitChar(Char c);
void visitString(String s);

#endif

