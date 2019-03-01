/* -*- c -*- This FLex file was machine-generated by the BNF converter */
%option noyywrap
%{
#define yylval cpp_grammarlval
#define YY_BUFFER_APPEND cpp_grammar_BUFFER_APPEND
#define YY_BUFFER_RESET cpp_grammar_BUFFER_RESET
#define initialize_lexer cpp_grammar_initialize_lexer
#include <string.h>
#include "Parser.h"
#define YY_BUFFER_LENGTH 4096
extern int yy_mylinenumber ;
char YY_PARSED_STRING[YY_BUFFER_LENGTH];
void YY_BUFFER_APPEND(char *s)
{
  strcat(YY_PARSED_STRING, s); //Do something better here!
}
void YY_BUFFER_RESET(void)
{
  int x;
  for(x = 0; x < YY_BUFFER_LENGTH; x++)
    YY_PARSED_STRING[x] = 0;
}

%}

LETTER [a-zA-Z]
CAPITAL [A-Z]
SMALL [a-z]
DIGIT [0-9]
IDENT [a-zA-Z0-9'_]
%START YYINITIAL COMMENT CHAR CHARESC CHAREND STRING ESCAPED
%%

<YYINITIAL>"("      	 return _SYMB_0;
<YYINITIAL>")"      	 return _SYMB_1;
<YYINITIAL>"{"      	 return _SYMB_2;
<YYINITIAL>"}"      	 return _SYMB_3;
<YYINITIAL>","      	 return _SYMB_4;
<YYINITIAL>";"      	 return _SYMB_5;
<YYINITIAL>"\""      	 return _SYMB_6;
<YYINITIAL>"<<"      	 return _SYMB_7;
<YYINITIAL>"::"      	 return _SYMB_8;
<YYINITIAL>"int"      	 return _SYMB_9;
<YYINITIAL>"return"      	 return _SYMB_10;

<YYINITIAL>"//"[^\n]*\n ++yy_mylinenumber; // BNFC: comment "//";
<YYINITIAL>"#"[^\n]*\n ++yy_mylinenumber; // BNFC: comment "#";
<YYINITIAL>"/*" BEGIN COMMENT; // BNFC: comment "/*" "*/";
<COMMENT>"*/" BEGIN YYINITIAL;
<COMMENT>. /* skip */;
<COMMENT>[\n] ++yy_mylinenumber;

<YYINITIAL>{LETTER}({LETTER}|{DIGIT}|\_)*     	 yylval.string_ = strdup(yytext); return _SYMB_11;
<YYINITIAL>{LETTER}*     	 yylval.string_ = strdup(yytext); return _SYMB_12;
<YYINITIAL>{DIGIT}+      	 yylval.int_ = atoi(yytext); return _INTEGER_;
<YYINITIAL>{LETTER}{IDENT}*      	 yylval.string_ = strdup(yytext); return _IDENT_;
\n ++yy_mylinenumber ;
<YYINITIAL>[ \t\r\n\f]      	 /* ignore white space. */;
<YYINITIAL>.      	 return _ERROR_;
%%
void initialize_lexer(FILE *inp) { yyrestart(inp); BEGIN YYINITIAL; }