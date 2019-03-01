#ifndef PRINTER_HEADER
#define PRINTER_HEADER

#include "Absyn.h"

/* Certain applications may improve performance by changing the buffer size */
#define BUFFER_INITIAL 2000
/* You may wish to change _L_PAREN or _R_PAREN */
#define _L_PAREN '('
#define _R_PAREN ')'

/* The following are simple heuristics for rendering terminals */
/* You may wish to change them */
void renderCC(Char c);
void renderCS(String s);
void indent(void);
void backup(void);


char *printProgram(Program p);
char *printFunction(Function p);
char *printArg(Arg p);
char *printListFunction(ListFunction p);
char *printListStm(ListStm p);
char *printListArg(ListArg p);
char *printStm(Stm p);
char *printType(Type p);
char *printExp(Exp p);
char *printQualId(QualId p);

void ppProgram(Program p, int i);
void ppFunction(Function p, int i);
void ppArg(Arg p, int i);
void ppListFunction(ListFunction p, int i);
void ppListStm(ListStm p, int i);
void ppListArg(ListArg p, int i);
void ppStm(Stm p, int i);
void ppExp(Exp p, int i);
void ppType(Type p, int i);
void ppQualId(QualId p, int i);

char *showProgram(Program p);
char *showFunction(Function p);
char *showArg(Arg p);
char *showListFunction(ListFunction p);
char *showListStm(ListStm p);
char *showListArg(ListArg p);
char *showStm(Stm p);
char *showType(Type p);
char *showExp(Exp p);
char *showQualId(QualId p);

void shProgram(Program p);
void shFunction(Function p);
void shArg(Arg p);
void shListFunction(ListFunction p);
void shListStm(ListStm p);
void shListArg(ListArg p);
void shStm(Stm p);
void shExp(Exp p);
void shType(Type p);
void shQualId(QualId p);

void ppId(String s, int i);
void ppIds(String s, int i);
void shId(String s);
void shIds(String s);
void ppInteger(Integer n, int i);
void ppDouble(Double d, int i);
void ppChar(Char c, int i);
void ppString(String s, int i);
void ppIdent(String s, int i);
void shInteger(Integer n);
void shDouble(Double d);
void shChar(Char c);
void shString(String s);
void shIdent(String s);
void bufAppendS(const char *s);
void bufAppendC(const char c);
void bufReset(void);
void resizeBuffer(void);

#endif

