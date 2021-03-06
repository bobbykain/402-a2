package cpp_grammar.Absyn; // Java Package generated by the BNF Converter.

public class ADecl  extends Arg {
  public final Type type_;
  public final String ident_;
  public ADecl(Type p1, String p2) { type_ = p1; ident_ = p2; }

  public <R,A> R accept(cpp_grammar.Absyn.Arg.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o instanceof cpp_grammar.Absyn.ADecl) {
      cpp_grammar.Absyn.ADecl x = (cpp_grammar.Absyn.ADecl)o;
      return this.type_.equals(x.type_) && this.ident_.equals(x.ident_);
    }
    return false;
  }

  public int hashCode() {
    return 37*(this.type_.hashCode())+this.ident_.hashCode();
  }


}
