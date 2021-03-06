/*** BNFC-Generated Visitor Traversal Skeleton. ***/
/* This traverses the abstract syntax tree.
   To use, copy Skeleton.h and Skeleton.c to
   new files. */

#include <stdlib.h>
#include <stdio.h>

#include "Skeleton.h"

void visitProgram(Program _p_)
{
  switch(_p_->kind)
  {
  case is_Prog:
    /* Code for Prog Goes Here */
    visitListFunction(_p_->u.prog_.listfunction_);
    break;

  default:
    fprintf(stderr, "Error: bad kind field when printing Program!\n");
    exit(1);
  }
}

void visitFunction(Function _p_)
{
  switch(_p_->kind)
  {
  case is_DFunc:
    /* Code for DFunc Goes Here */
    visitType(_p_->u.dfunc_.type_);
    visitId(_p_->u.dfunc_.id_);
    visitListArg(_p_->u.dfunc_.listarg_);
    visitListStm(_p_->u.dfunc_.liststm_);
    break;

  default:
    fprintf(stderr, "Error: bad kind field when printing Function!\n");
    exit(1);
  }
}

void visitArg(Arg _p_)
{
  switch(_p_->kind)
  {
  case is_ADecl:
    /* Code for ADecl Goes Here */
    visitType(_p_->u.adecl_.type_);
    visitId(_p_->u.adecl_.id_);
    break;

  default:
    fprintf(stderr, "Error: bad kind field when printing Arg!\n");
    exit(1);
  }
}

void visitListFunction(ListFunction listfunction)
{
  while(listfunction  != 0)
  {
    /* Code For ListFunction Goes Here */
    visitFunction(listfunction->function_);
    listfunction = listfunction->listfunction_;
  }
}

void visitListStm(ListStm liststm)
{
  while(liststm  != 0)
  {
    /* Code For ListStm Goes Here */
    visitStm(liststm->stm_);
    liststm = liststm->liststm_;
  }
}

void visitListArg(ListArg listarg)
{
  while(listarg  != 0)
  {
    /* Code For ListArg Goes Here */
    visitArg(listarg->arg_);
    listarg = listarg->listarg_;
  }
}

void visitStm(Stm _p_)
{
  switch(_p_->kind)
  {
  case is_SExp:
    /* Code for SExp Goes Here */
    visitExp(_p_->u.sexp_.exp_);
    break;
  case is_SReturn:
    /* Code for SReturn Goes Here */
    visitExp(_p_->u.sreturn_.exp_);
    break;

  default:
    fprintf(stderr, "Error: bad kind field when printing Stm!\n");
    exit(1);
  }
}

void visitExp(Exp _p_)
{
  switch(_p_->kind)
  {
  case is_EInt:
    /* Code for EInt Goes Here */
    visitInteger(_p_->u.eint_.integer_);
    break;
  case is_EStr:
    /* Code for EStr Goes Here */
    visitId(_p_->u.estr_.id_);
    break;
  case is_ELs:
    /* Code for ELs Goes Here */
    visitExp(_p_->u.els_.exp_1);
    visitExp(_p_->u.els_.exp_2);
    break;

  default:
    fprintf(stderr, "Error: bad kind field when printing Exp!\n");
    exit(1);
  }
}

void visitType(Type _p_)
{
  switch(_p_->kind)
  {
  case is_Tint:
    /* Code for Tint Goes Here */
    break;

  default:
    fprintf(stderr, "Error: bad kind field when printing Type!\n");
    exit(1);
  }
}

void visitQualId(QualId _p_)
{
  switch(_p_->kind)
  {
  case is_Iden:
    /* Code for Iden Goes Here */
    visitIdent(_p_->u.iden_.ident_);
    break;
  case is_Idens:
    /* Code for Idens Goes Here */
    visitQualId(_p_->u.idens_.qualid_);
    visitIdent(_p_->u.idens_.ident_);
    break;

  default:
    fprintf(stderr, "Error: bad kind field when printing QualId!\n");
    exit(1);
  }
}

void visitId(Id p)
{
  /* Code for Id Goes Here */
}
void visitIds(Ids p)
{
  /* Code for Ids Goes Here */
}
void visitIdent(Ident i)
{
  /* Code for Ident Goes Here */
}
void visitInteger(Integer i)
{
  /* Code for Integer Goes Here */
}
void visitDouble(Double d)
{
  /* Code for Double Goes Here */
}
void visitChar(Char c)
{
  /* Code for Char Goes Here */
}
void visitString(String s)
{
  /* Code for String Goes Here */
}

