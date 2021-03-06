#ifndef PARSER_HEADER_FILE
#define PARSER_HEADER_FILE

#include "Absyn.h"

typedef union
{
  int int_;
  char char_;
  double double_;
  char* string_;
  Program program_;
  Function function_;
  Arg arg_;
  ListFunction listfunction_;
  ListStm liststm_;
  ListArg listarg_;
  Stm stm_;
  Type type_;
  Exp exp_;
  QualId qualid_;
} YYSTYPE;

#define _ERROR_ 258
#define _SYMB_0 259
#define _SYMB_1 260
#define _SYMB_2 261
#define _SYMB_3 262
#define _SYMB_4 263
#define _SYMB_5 264
#define _SYMB_6 265
#define _SYMB_7 266
#define _SYMB_8 267
#define _SYMB_9 268
#define _SYMB_10 269
#define _SYMB_11 270
#define _SYMB_12 271
#define _INTEGER_ 272
#define _IDENT_ 273

extern YYSTYPE yylval;
Program pProgram(FILE *inp);
Function pFunction(FILE *inp);
Arg pArg(FILE *inp);
ListFunction pListFunction(FILE *inp);
ListStm pListStm(FILE *inp);
ListArg pListArg(FILE *inp);
Stm pStm(FILE *inp);
Type pType(FILE *inp);
Exp pExp(FILE *inp);
QualId pQualId(FILE *inp);


#endif
