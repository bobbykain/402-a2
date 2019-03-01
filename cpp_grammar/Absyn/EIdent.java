package cpp_grammar.Absyn; // Java Package generated by the BNF Converter.

public class EIdent  extends Exp {
  public final String ident_;
  public EIdent(String p1) { ident_ = p1; }

  public <R,A> R accept(cpp_grammar.Absyn.Exp.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o instanceof cpp_grammar.Absyn.EIdent) {
      cpp_grammar.Absyn.EIdent x = (cpp_grammar.Absyn.EIdent)o;
      return this.ident_.equals(x.ident_);
    }
    return false;
  }

  public int hashCode() {
    return this.ident_.hashCode();
  }


}