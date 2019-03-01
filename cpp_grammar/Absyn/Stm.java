package cpp_grammar.Absyn; // Java Package generated by the BNF Converter.

public abstract class Stm implements java.io.Serializable {
  public abstract <R,A> R accept(Stm.Visitor<R,A> v, A arg);
  public interface Visitor <R,A> {
    public R visit(cpp_grammar.Absyn.SDecl p, A arg);
    public R visit(cpp_grammar.Absyn.SExp p, A arg);
    public R visit(cpp_grammar.Absyn.SReturn p, A arg);
    public R visit(cpp_grammar.Absyn.SBlock p, A arg);

  }

}