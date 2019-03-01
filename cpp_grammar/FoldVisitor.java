package cpp_grammar;

import cpp_grammar.Absyn.*;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

/** BNFC-Generated Fold Visitor */
public abstract class FoldVisitor<R,A> implements AllVisitor<R,A> {
    public abstract R leaf(A arg);
    public abstract R combine(R x, R y, A arg);

/* Program */
    public R visit(cpp_grammar.Absyn.Prog p, A arg) {
      R r = leaf(arg);
      for (Function x : p.listfunction_)
      {
        r = combine(x.accept(this, arg), r, arg);
      }
      return r;
    }

/* Function */
    public R visit(cpp_grammar.Absyn.Fun p, A arg) {
      R r = leaf(arg);
      r = combine(p.type_.accept(this, arg), r, arg);
      for (Arg x : p.listarg_)
      {
        r = combine(x.accept(this, arg), r, arg);
      }
      for (Stm x : p.liststm_)
      {
        r = combine(x.accept(this, arg), r, arg);
      }
      return r;
    }

/* Arg */
    public R visit(cpp_grammar.Absyn.Dec p, A arg) {
      R r = leaf(arg);
      r = combine(p.type_.accept(this, arg), r, arg);
      return r;
    }

/* Stm */
    public R visit(cpp_grammar.Absyn.SDecl p, A arg) {
      R r = leaf(arg);
      r = combine(p.arg_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(cpp_grammar.Absyn.SExp p, A arg) {
      R r = leaf(arg);
      r = combine(p.exp_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(cpp_grammar.Absyn.SReturn p, A arg) {
      R r = leaf(arg);
      r = combine(p.exp_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(cpp_grammar.Absyn.SBlock p, A arg) {
      R r = leaf(arg);
      for (Stm x : p.liststm_)
      {
        r = combine(x.accept(this, arg), r, arg);
      }
      return r;
    }

/* Exp */
    public R visit(cpp_grammar.Absyn.EInt p, A arg) {
      R r = leaf(arg);
      return r;
    }
    public R visit(cpp_grammar.Absyn.EStr p, A arg) {
      R r = leaf(arg);
      return r;
    }
    public R visit(cpp_grammar.Absyn.EId p, A arg) {
      R r = leaf(arg);
      return r;
    }
    public R visit(cpp_grammar.Absyn.ELs p, A arg) {
      R r = leaf(arg);
      r = combine(p.exp_1.accept(this, arg), r, arg);
      r = combine(p.exp_2.accept(this, arg), r, arg);
      return r;
    }
    public R visit(cpp_grammar.Absyn.EAss p, A arg) {
      R r = leaf(arg);
      r = combine(p.exp_.accept(this, arg), r, arg);
      return r;
    }

/* Type */
    public R visit(cpp_grammar.Absyn.Tint p, A arg) {
      R r = leaf(arg);
      return r;
    }


}
