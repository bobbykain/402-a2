/*** BNFC-Generated Pretty Printer and Abstract Syntax Viewer ***/

#include "Printer.h"
#include <stdio.h>
#include <string.h>
#include <stdlib.h>

#define INDENT_WIDTH 2

int _n_;
char *buf_;
int cur_;
int buf_size;

/* You may wish to change the renderC functions */
void renderC(Char c)
{
  if (c == '{')
  {
     bufAppendC('\n');
     indent();
     bufAppendC(c);
     _n_ = _n_ + INDENT_WIDTH;
     bufAppendC('\n');
     indent();
  }
  else if (c == '(' || c == '[')
     bufAppendC(c);
  else if (c == ')' || c == ']')
  {
     backup();
     bufAppendC(c);
  }
  else if (c == '}')
  {
     int t;
     _n_ = _n_ - INDENT_WIDTH;
     for(t=0; t<INDENT_WIDTH; t++) {
       backup();
     }
     bufAppendC(c);
     bufAppendC('\n');
     indent();
  }
  else if (c == ',')
  {
     backup();
     bufAppendC(c);
     bufAppendC(' ');
  }
  else if (c == ';')
  {
     backup();
     bufAppendC(c);
     bufAppendC('\n');
     indent();
  }
  else if (c == 0) return;
  else
  {
     bufAppendC(' ');
     bufAppendC(c);
     bufAppendC(' ');
  }
}
void renderS(String s)
{
  if(strlen(s) > 0)
  {
    bufAppendS(s);
    bufAppendC(' ');
  }
}
void indent(void)
{
  int n = _n_;
  while (n > 0)
  {
    bufAppendC(' ');
    n--;
  }
}
void backup(void)
{
  if (buf_[cur_ - 1] == ' ')
  {
    buf_[cur_ - 1] = 0;
    cur_--;
  }
}
char *printProgram(Program p)
{
  _n_ = 0;
  bufReset();
  ppProgram(p, 0);
  return buf_;
}
char *printFunction(Function p)
{
  _n_ = 0;
  bufReset();
  ppFunction(p, 0);
  return buf_;
}
char *printArg(Arg p)
{
  _n_ = 0;
  bufReset();
  ppArg(p, 0);
  return buf_;
}
char *printListFunction(ListFunction p)
{
  _n_ = 0;
  bufReset();
  ppListFunction(p, 0);
  return buf_;
}
char *printListStm(ListStm p)
{
  _n_ = 0;
  bufReset();
  ppListStm(p, 0);
  return buf_;
}
char *printListArg(ListArg p)
{
  _n_ = 0;
  bufReset();
  ppListArg(p, 0);
  return buf_;
}
char *printStm(Stm p)
{
  _n_ = 0;
  bufReset();
  ppStm(p, 0);
  return buf_;
}
char *printType(Type p)
{
  _n_ = 0;
  bufReset();
  ppType(p, 0);
  return buf_;
}
char *printExp(Exp p)
{
  _n_ = 0;
  bufReset();
  ppExp(p, 0);
  return buf_;
}
char *printQualId(QualId p)
{
  _n_ = 0;
  bufReset();
  ppQualId(p, 0);
  return buf_;
}
char *showProgram(Program p)
{
  _n_ = 0;
  bufReset();
  shProgram(p);
  return buf_;
}
char *showFunction(Function p)
{
  _n_ = 0;
  bufReset();
  shFunction(p);
  return buf_;
}
char *showArg(Arg p)
{
  _n_ = 0;
  bufReset();
  shArg(p);
  return buf_;
}
char *showListFunction(ListFunction p)
{
  _n_ = 0;
  bufReset();
  shListFunction(p);
  return buf_;
}
char *showListStm(ListStm p)
{
  _n_ = 0;
  bufReset();
  shListStm(p);
  return buf_;
}
char *showListArg(ListArg p)
{
  _n_ = 0;
  bufReset();
  shListArg(p);
  return buf_;
}
char *showStm(Stm p)
{
  _n_ = 0;
  bufReset();
  shStm(p);
  return buf_;
}
char *showType(Type p)
{
  _n_ = 0;
  bufReset();
  shType(p);
  return buf_;
}
char *showExp(Exp p)
{
  _n_ = 0;
  bufReset();
  shExp(p);
  return buf_;
}
char *showQualId(QualId p)
{
  _n_ = 0;
  bufReset();
  shQualId(p);
  return buf_;
}
void ppProgram(Program _p_, int _i_)
{
  switch(_p_->kind)
  {
  case is_Prog:
    if (_i_ > 0) renderC(_L_PAREN);
    ppListFunction(_p_->u.prog_.listfunction_, 0);

    if (_i_ > 0) renderC(_R_PAREN);
    break;


  default:
    fprintf(stderr, "Error: bad kind field when printing Program!\n");
    exit(1);
  }
}

void ppFunction(Function _p_, int _i_)
{
  switch(_p_->kind)
  {
  case is_DFunc:
    if (_i_ > 0) renderC(_L_PAREN);
    ppType(_p_->u.dfunc_.type_, 0);
    ppIdent(_p_->u.dfunc_.id_, 0);
    renderC('(');
    ppListArg(_p_->u.dfunc_.listarg_, 0);
    renderC(')');
    renderC('{');
    ppListStm(_p_->u.dfunc_.liststm_, 0);
    renderC('}');

    if (_i_ > 0) renderC(_R_PAREN);
    break;


  default:
    fprintf(stderr, "Error: bad kind field when printing Function!\n");
    exit(1);
  }
}

void ppArg(Arg _p_, int _i_)
{
  switch(_p_->kind)
  {
  case is_ADecl:
    if (_i_ > 0) renderC(_L_PAREN);
    ppType(_p_->u.adecl_.type_, 0);
    ppIdent(_p_->u.adecl_.id_, 0);

    if (_i_ > 0) renderC(_R_PAREN);
    break;


  default:
    fprintf(stderr, "Error: bad kind field when printing Arg!\n");
    exit(1);
  }
}

void ppListFunction(ListFunction listfunction, int i)
{
  while(listfunction != 0)
  {
    if (listfunction->listfunction_ == 0)
    {
      ppFunction(listfunction->function_, i);
      renderS("");
      listfunction = 0;
    }
    else
    {
      ppFunction(listfunction->function_, i);
      renderS("");
      listfunction = listfunction->listfunction_;
    }
  }
}

void ppListStm(ListStm liststm, int i)
{
  while(liststm != 0)
  {
    if (liststm->liststm_ == 0)
    {
      ppStm(liststm->stm_, i);
      renderS("");
      liststm = 0;
    }
    else
    {
      ppStm(liststm->stm_, i);
      renderS("");
      liststm = liststm->liststm_;
    }
  }
}

void ppListArg(ListArg listarg, int i)
{
  while(listarg != 0)
  {
    if (listarg->listarg_ == 0)
    {
      ppArg(listarg->arg_, i);

      listarg = 0;
    }
    else
    {
      ppArg(listarg->arg_, i);
      renderC(',');
      listarg = listarg->listarg_;
    }
  }
}

void ppStm(Stm _p_, int _i_)
{
  switch(_p_->kind)
  {
  case is_SExp:
    if (_i_ > 0) renderC(_L_PAREN);
    ppExp(_p_->u.sexp_.exp_, 0);
    renderC(';');

    if (_i_ > 0) renderC(_R_PAREN);
    break;

  case is_SReturn:
    if (_i_ > 0) renderC(_L_PAREN);
    renderS("return");
    ppExp(_p_->u.sreturn_.exp_, 0);
    renderC(';');

    if (_i_ > 0) renderC(_R_PAREN);
    break;


  default:
    fprintf(stderr, "Error: bad kind field when printing Stm!\n");
    exit(1);
  }
}

void ppExp(Exp _p_, int _i_)
{
  switch(_p_->kind)
  {
  case is_EInt:
    if (_i_ > 15) renderC(_L_PAREN);
    ppInteger(_p_->u.eint_.integer_, 0);

    if (_i_ > 15) renderC(_R_PAREN);
    break;

  case is_EStr:
    if (_i_ > 15) renderC(_L_PAREN);
    renderC('"');
    ppIdent(_p_->u.estr_.id_, 0);
    renderC('"');

    if (_i_ > 15) renderC(_R_PAREN);
    break;

  case is_ELs:
    if (_i_ > 9) renderC(_L_PAREN);
    ppExp(_p_->u.els_.exp_1, 9);
    renderS("<<");
    ppExp(_p_->u.els_.exp_2, 10);

    if (_i_ > 9) renderC(_R_PAREN);
    break;


  default:
    fprintf(stderr, "Error: bad kind field when printing Exp!\n");
    exit(1);
  }
}

void ppType(Type _p_, int _i_)
{
  switch(_p_->kind)
  {
  case is_Tint:
    if (_i_ > 0) renderC(_L_PAREN);
    renderS("int");

    if (_i_ > 0) renderC(_R_PAREN);
    break;


  default:
    fprintf(stderr, "Error: bad kind field when printing Type!\n");
    exit(1);
  }
}

void ppQualId(QualId _p_, int _i_)
{
  switch(_p_->kind)
  {
  case is_Iden:
    if (_i_ > 0) renderC(_L_PAREN);
    ppIdent(_p_->u.iden_.ident_, 0);

    if (_i_ > 0) renderC(_R_PAREN);
    break;

  case is_Idens:
    if (_i_ > 0) renderC(_L_PAREN);
    ppQualId(_p_->u.idens_.qualid_, 0);
    renderS("::");
    ppIdent(_p_->u.idens_.ident_, 0);

    if (_i_ > 0) renderC(_R_PAREN);
    break;


  default:
    fprintf(stderr, "Error: bad kind field when printing QualId!\n");
    exit(1);
  }
}

void ppInteger(Integer n, int i)
{
  char tmp[16];
  sprintf(tmp, "%d", n);
  bufAppendS(tmp);
}
void ppDouble(Double d, int i)
{
  char tmp[16];
  sprintf(tmp, "%g", d);
  bufAppendS(tmp);
}
void ppChar(Char c, int i)
{
  bufAppendC('\'');
  bufAppendC(c);
  bufAppendC('\'');
}
void ppString(String s, int i)
{
  bufAppendC('\"');
  bufAppendS(s);
  bufAppendC('\"');
}
void ppIdent(String s, int i)
{
  renderS(s);
}

void ppId(String s, int i)
{
  renderS(s);
}


void ppIds(String s, int i)
{
  renderS(s);
}


void shProgram(Program _p_)
{
  switch(_p_->kind)
  {
  case is_Prog:
    bufAppendC('(');

    bufAppendS("Prog");

    bufAppendC(' ');

    shListFunction(_p_->u.prog_.listfunction_);

    bufAppendC(')');

    break;

  default:
    fprintf(stderr, "Error: bad kind field when showing Program!\n");
    exit(1);
  }
}

void shFunction(Function _p_)
{
  switch(_p_->kind)
  {
  case is_DFunc:
    bufAppendC('(');

    bufAppendS("DFunc");

    bufAppendC(' ');

    shType(_p_->u.dfunc_.type_);
  bufAppendC(' ');
    shIdent(_p_->u.dfunc_.id_);
  bufAppendC(' ');
    shListArg(_p_->u.dfunc_.listarg_);
  bufAppendC(' ');
    shListStm(_p_->u.dfunc_.liststm_);

    bufAppendC(')');

    break;

  default:
    fprintf(stderr, "Error: bad kind field when showing Function!\n");
    exit(1);
  }
}

void shArg(Arg _p_)
{
  switch(_p_->kind)
  {
  case is_ADecl:
    bufAppendC('(');

    bufAppendS("ADecl");

    bufAppendC(' ');

    shType(_p_->u.adecl_.type_);
  bufAppendC(' ');
    shIdent(_p_->u.adecl_.id_);

    bufAppendC(')');

    break;

  default:
    fprintf(stderr, "Error: bad kind field when showing Arg!\n");
    exit(1);
  }
}

void shListFunction(ListFunction listfunction)
{
  bufAppendC('[');
  while(listfunction != 0)
  {
    if (listfunction->listfunction_)
    {
      shFunction(listfunction->function_);
      bufAppendS(", ");
      listfunction = listfunction->listfunction_;
    }
    else
    {
      shFunction(listfunction->function_);
      listfunction = 0;
    }
  }
  bufAppendC(']');
}

void shListStm(ListStm liststm)
{
  bufAppendC('[');
  while(liststm != 0)
  {
    if (liststm->liststm_)
    {
      shStm(liststm->stm_);
      bufAppendS(", ");
      liststm = liststm->liststm_;
    }
    else
    {
      shStm(liststm->stm_);
      liststm = 0;
    }
  }
  bufAppendC(']');
}

void shListArg(ListArg listarg)
{
  bufAppendC('[');
  while(listarg != 0)
  {
    if (listarg->listarg_)
    {
      shArg(listarg->arg_);
      bufAppendS(", ");
      listarg = listarg->listarg_;
    }
    else
    {
      shArg(listarg->arg_);
      listarg = 0;
    }
  }
  bufAppendC(']');
}

void shStm(Stm _p_)
{
  switch(_p_->kind)
  {
  case is_SExp:
    bufAppendC('(');

    bufAppendS("SExp");

    bufAppendC(' ');

    shExp(_p_->u.sexp_.exp_);

    bufAppendC(')');

    break;
  case is_SReturn:
    bufAppendC('(');

    bufAppendS("SReturn");

    bufAppendC(' ');

    shExp(_p_->u.sreturn_.exp_);

    bufAppendC(')');

    break;

  default:
    fprintf(stderr, "Error: bad kind field when showing Stm!\n");
    exit(1);
  }
}

void shExp(Exp _p_)
{
  switch(_p_->kind)
  {
  case is_EInt:
    bufAppendC('(');

    bufAppendS("EInt");

    bufAppendC(' ');

    shInteger(_p_->u.eint_.integer_);

    bufAppendC(')');

    break;
  case is_EStr:
    bufAppendC('(');

    bufAppendS("EStr");

    bufAppendC(' ');

    shIdent(_p_->u.estr_.id_);

    bufAppendC(')');

    break;
  case is_ELs:
    bufAppendC('(');

    bufAppendS("ELs");

    bufAppendC(' ');

    shExp(_p_->u.els_.exp_1);
  bufAppendC(' ');
    shExp(_p_->u.els_.exp_2);

    bufAppendC(')');

    break;

  default:
    fprintf(stderr, "Error: bad kind field when showing Exp!\n");
    exit(1);
  }
}

void shType(Type _p_)
{
  switch(_p_->kind)
  {
  case is_Tint:
  
    bufAppendS("Tint");

  

  
    break;

  default:
    fprintf(stderr, "Error: bad kind field when showing Type!\n");
    exit(1);
  }
}

void shQualId(QualId _p_)
{
  switch(_p_->kind)
  {
  case is_Iden:
    bufAppendC('(');

    bufAppendS("Iden");

    bufAppendC(' ');

    shIdent(_p_->u.iden_.ident_);

    bufAppendC(')');

    break;
  case is_Idens:
    bufAppendC('(');

    bufAppendS("Idens");

    bufAppendC(' ');

    shQualId(_p_->u.idens_.qualid_);
  bufAppendC(' ');
    shIdent(_p_->u.idens_.ident_);

    bufAppendC(')');

    break;

  default:
    fprintf(stderr, "Error: bad kind field when showing QualId!\n");
    exit(1);
  }
}

void shInteger(Integer i)
{
  char tmp[16];
  sprintf(tmp, "%d", i);
  bufAppendS(tmp);
}
void shDouble(Double d)
{
  char tmp[16];
  sprintf(tmp, "%g", d);
  bufAppendS(tmp);
}
void shChar(Char c)
{
  bufAppendC('\'');
  bufAppendC(c);
  bufAppendC('\'');
}
void shString(String s)
{
  bufAppendC('\"');
  bufAppendS(s);
  bufAppendC('\"');
}
void shIdent(String s)
{
  bufAppendC('\"');
  bufAppendS(s);
  bufAppendC('\"');
}

void shId(String s)
{
  bufAppendC('\"');
  bufAppendS(s);
  bufAppendC('\"');
}


void shIds(String s)
{
  bufAppendC('\"');
  bufAppendS(s);
  bufAppendC('\"');
}


void bufAppendS(const char *s)
{
  int len = strlen(s);
  int n;
  while (cur_ + len > buf_size)
  {
    buf_size *= 2; /* Double the buffer size */
    resizeBuffer();
  }
  for(n = 0; n < len; n++)
  {
    buf_[cur_ + n] = s[n];
  }
  cur_ += len;
  buf_[cur_] = 0;
}
void bufAppendC(const char c)
{
  if (cur_ == buf_size)
  {
    buf_size *= 2; /* Double the buffer size */
    resizeBuffer();
  }
  buf_[cur_] = c;
  cur_++;
  buf_[cur_] = 0;
}
void bufReset(void)
{
  cur_ = 0;
  buf_size = BUFFER_INITIAL;
  resizeBuffer();
  memset(buf_, 0, buf_size);
}
void resizeBuffer(void)
{
  char *temp = (char *) malloc(buf_size);
  if (!temp)
  {
    fprintf(stderr, "Error: Out of memory while attempting to grow buffer!\n");
    exit(1);
  }
  if (buf_)
  {
    strncpy(temp, buf_, buf_size); /* peteg: strlcpy is safer, but not POSIX/ISO C. */
    free(buf_);
  }
  buf_ = temp;
}
char *buf_;
int cur_, buf_size;

