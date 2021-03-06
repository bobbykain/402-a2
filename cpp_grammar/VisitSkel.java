package cpp_grammar;
import cpp_grammar.Absyn.*;
/*** BNFC-Generated Visitor Design Pattern Skeleton. ***/
/* This implements the common visitor design pattern.
   Tests show it to be slightly less efficient than the
   instanceof method, but easier to use. 
   Replace the R and A parameters with the desired return
   and context types.*/

public class VisitSkel
{
  public class ProgramVisitor<R,A> implements Program.Visitor<R,A>
  {
    public R visit(cpp_grammar.Absyn.Prog p, A arg)
    { /* Code For Prog Goes Here */
      for (Function x: p.listfunction_)
      { /* ... */ }
      return null;
    }
  }
  public class FunctionVisitor<R,A> implements Function.Visitor<R,A>
  {
    public R visit(cpp_grammar.Absyn.Fun p, A arg)
    { /* Code For Fun Goes Here */
      p.type_.accept(new TypeVisitor<R,A>(), arg);
      //p.ident_;
      for (Arg x: p.listarg_)
      { /* ... */ }
      for (Stm x: p.liststm_)
      { /* ... */ }
      return null;
    }
  }
  public class ArgVisitor<R,A> implements Arg.Visitor<R,A>
  {
    public R visit(cpp_grammar.Absyn.Dec p, A arg)
    { /* Code For Dec Goes Here */
      p.type_.accept(new TypeVisitor<R,A>(), arg);
      for (String x: p.listident_)
      { /* ... */ }
      return null;
    }
  }
  public class StmVisitor<R,A> implements Stm.Visitor<R,A>
  {
    public R visit(cpp_grammar.Absyn.SDecl p, A arg)
    { /* Code For SDecl Goes Here */
      p.arg_.accept(new ArgVisitor<R,A>(), arg);
      return null;
    }    public R visit(cpp_grammar.Absyn.SExp p, A arg)
    { /* Code For SExp Goes Here */
      p.exp_.accept(new ExpVisitor<R,A>(), arg);
      return null;
    }    public R visit(cpp_grammar.Absyn.SReturn p, A arg)
    { /* Code For SReturn Goes Here */
      p.exp_.accept(new ExpVisitor<R,A>(), arg);
      return null;
    }    public R visit(cpp_grammar.Absyn.SBlock p, A arg)
    { /* Code For SBlock Goes Here */
      for (Stm x: p.liststm_)
      { /* ... */ }
      return null;
    }
  }
  public class ExpVisitor<R,A> implements Exp.Visitor<R,A>
  {
    public R visit(cpp_grammar.Absyn.EInt p, A arg)
    { /* Code For EInt Goes Here */
      //p.integer_;
      return null;
    }    public R visit(cpp_grammar.Absyn.EStr p, A arg)
    { /* Code For EStr Goes Here */
      //p.string_;
      return null;
    }    public R visit(cpp_grammar.Absyn.EId p, A arg)
    { /* Code For EId Goes Here */
      //p.ident_;
      return null;
    }        public R visit(cpp_grammar.Absyn.ELs p, A arg)
    { /* Code For ELs Goes Here */
      p.exp_1.accept(new ExpVisitor<R,A>(), arg);
      p.exp_2.accept(new ExpVisitor<R,A>(), arg);
      return null;
    }        public R visit(cpp_grammar.Absyn.EAss p, A arg)
    { /* Code For EAss Goes Here */
      //p.ident_;
      p.exp_.accept(new ExpVisitor<R,A>(), arg);
      return null;
    }    
  }
  public class TypeVisitor<R,A> implements Type.Visitor<R,A>
  {
    public R visit(cpp_grammar.Absyn.Tint p, A arg)
    { /* Code For Tint Goes Here */
      return null;
    }
  }
}