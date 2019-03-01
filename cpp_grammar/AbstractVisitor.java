package cpp_grammar;
import cpp_grammar.Absyn.*;
/** BNFC-Generated Abstract Visitor */
public class AbstractVisitor<R,A> implements AllVisitor<R,A> {
/* Program */
    public R visit(cpp_grammar.Absyn.Prog p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(cpp_grammar.Absyn.Program p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* Function */
    public R visit(cpp_grammar.Absyn.Fun p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(cpp_grammar.Absyn.Function p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* Arg */
    public R visit(cpp_grammar.Absyn.Dec p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(cpp_grammar.Absyn.Arg p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* Stm */
    public R visit(cpp_grammar.Absyn.SDecl p, A arg) { return visitDefault(p, arg); }
    public R visit(cpp_grammar.Absyn.SExp p, A arg) { return visitDefault(p, arg); }
    public R visit(cpp_grammar.Absyn.SReturn p, A arg) { return visitDefault(p, arg); }
    public R visit(cpp_grammar.Absyn.SBlock p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(cpp_grammar.Absyn.Stm p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* Exp */
    public R visit(cpp_grammar.Absyn.EInt p, A arg) { return visitDefault(p, arg); }
    public R visit(cpp_grammar.Absyn.EStr p, A arg) { return visitDefault(p, arg); }
    public R visit(cpp_grammar.Absyn.EId p, A arg) { return visitDefault(p, arg); }

    public R visit(cpp_grammar.Absyn.ELs p, A arg) { return visitDefault(p, arg); }

    public R visit(cpp_grammar.Absyn.EAss p, A arg) { return visitDefault(p, arg); }

    public R visitDefault(cpp_grammar.Absyn.Exp p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* Type */
    public R visit(cpp_grammar.Absyn.Tint p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(cpp_grammar.Absyn.Type p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }

}
