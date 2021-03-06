package cpp_grammar;
import cpp_grammar.Absyn.*;

public class PrettyPrinter
{
  //For certain applications increasing the initial size of the buffer may improve performance.
  private static final int INITIAL_BUFFER_SIZE = 128;
  private static final int INDENT_WIDTH = 2;
  //You may wish to change the parentheses used in precedence.
  private static final String _L_PAREN = new String("(");
  private static final String _R_PAREN = new String(")");
  //You may wish to change render
  private static void render(String s)
  {
    if (s.equals("{"))
    {
       buf_.append("\n");
       indent();
       buf_.append(s);
       _n_ = _n_ + INDENT_WIDTH;
       buf_.append("\n");
       indent();
    }
    else if (s.equals("(") || s.equals("["))
       buf_.append(s);
    else if (s.equals(")") || s.equals("]"))
    {
       backup();
       buf_.append(s);
       buf_.append(" ");
    }
    else if (s.equals("}"))
    {
       int t;
       _n_ = _n_ - INDENT_WIDTH;
       for(t=0; t<INDENT_WIDTH; t++) {
         backup();
       }
       buf_.append(s);
       buf_.append("\n");
       indent();
    }
    else if (s.equals(","))
    {
       backup();
       buf_.append(s);
       buf_.append(" ");
    }
    else if (s.equals(";"))
    {
       backup();
       buf_.append(s);
       buf_.append("\n");
       indent();
    }
    else if (s.equals("")) return;
    else
    {
       buf_.append(s);
       buf_.append(" ");
    }
  }


  //  print and show methods are defined for each category.
  public static String print(cpp_grammar.Absyn.Program foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(cpp_grammar.Absyn.Program foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(cpp_grammar.Absyn.Function foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(cpp_grammar.Absyn.Function foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(cpp_grammar.Absyn.Arg foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(cpp_grammar.Absyn.Arg foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(cpp_grammar.Absyn.ListFunction foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(cpp_grammar.Absyn.ListFunction foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(cpp_grammar.Absyn.ListStm foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(cpp_grammar.Absyn.ListStm foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(cpp_grammar.Absyn.ListArg foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(cpp_grammar.Absyn.ListArg foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(cpp_grammar.Absyn.ListIdent foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(cpp_grammar.Absyn.ListIdent foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(cpp_grammar.Absyn.Stm foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(cpp_grammar.Absyn.Stm foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(cpp_grammar.Absyn.Exp foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(cpp_grammar.Absyn.Exp foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(cpp_grammar.Absyn.ListExp foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(cpp_grammar.Absyn.ListExp foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(cpp_grammar.Absyn.Type foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(cpp_grammar.Absyn.Type foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  /***   You shouldn't need to change anything beyond this point.   ***/

  private static void pp(cpp_grammar.Absyn.Program foo, int _i_)
  {
    if (foo instanceof cpp_grammar.Absyn.Prog)
    {
       cpp_grammar.Absyn.Prog _prog = (cpp_grammar.Absyn.Prog) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_prog.listfunction_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(cpp_grammar.Absyn.Function foo, int _i_)
  {
    if (foo instanceof cpp_grammar.Absyn.Fun)
    {
       cpp_grammar.Absyn.Fun _fun = (cpp_grammar.Absyn.Fun) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_fun.type_, 0);
       pp(_fun.ident_, 0);
       render("(");
       pp(_fun.listarg_, 0);
       render(")");
       render("{");
       pp(_fun.liststm_, 0);
       render("}");
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(cpp_grammar.Absyn.Arg foo, int _i_)
  {
    if (foo instanceof cpp_grammar.Absyn.Dec)
    {
       cpp_grammar.Absyn.Dec _dec = (cpp_grammar.Absyn.Dec) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_dec.type_, 0);
       pp(_dec.listident_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(cpp_grammar.Absyn.ListFunction foo, int _i_)
  {
     for (java.util.Iterator<Function> it = foo.iterator(); it.hasNext();)
     {
       pp(it.next(), _i_);
       if (it.hasNext()) {
         render("");
       } else {
         render("");
       }
     }  }

  private static void pp(cpp_grammar.Absyn.ListStm foo, int _i_)
  {
     for (java.util.Iterator<Stm> it = foo.iterator(); it.hasNext();)
     {
       pp(it.next(), _i_);
       if (it.hasNext()) {
         render("");
       } else {
         render("");
       }
     }  }

  private static void pp(cpp_grammar.Absyn.ListArg foo, int _i_)
  {
     for (java.util.Iterator<Arg> it = foo.iterator(); it.hasNext();)
     {
       pp(it.next(), _i_);
       if (it.hasNext()) {
         render(",");
       } else {
         render("");
       }
     }  }

  private static void pp(cpp_grammar.Absyn.ListIdent foo, int _i_)
  {
     for (java.util.Iterator<String> it = foo.iterator(); it.hasNext();)
     {
       pp(it.next(), _i_);
       if (it.hasNext()) {
         render("::");
       } else {
         render("");
       }
     }  }

  private static void pp(cpp_grammar.Absyn.Stm foo, int _i_)
  {
    if (foo instanceof cpp_grammar.Absyn.SDecl)
    {
       cpp_grammar.Absyn.SDecl _sdecl = (cpp_grammar.Absyn.SDecl) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_sdecl.arg_, 0);
       render(";");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof cpp_grammar.Absyn.SExp)
    {
       cpp_grammar.Absyn.SExp _sexp = (cpp_grammar.Absyn.SExp) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_sexp.exp_, 0);
       render(";");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof cpp_grammar.Absyn.SReturn)
    {
       cpp_grammar.Absyn.SReturn _sreturn = (cpp_grammar.Absyn.SReturn) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("return");
       pp(_sreturn.exp_, 0);
       render(";");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof cpp_grammar.Absyn.SBlock)
    {
       cpp_grammar.Absyn.SBlock _sblock = (cpp_grammar.Absyn.SBlock) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("{");
       pp(_sblock.liststm_, 0);
       render("}");
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(cpp_grammar.Absyn.Exp foo, int _i_)
  {
    if (foo instanceof cpp_grammar.Absyn.EInt)
    {
       cpp_grammar.Absyn.EInt _eint = (cpp_grammar.Absyn.EInt) foo;
       if (_i_ > 2) render(_L_PAREN);
       pp(_eint.integer_, 0);
       if (_i_ > 2) render(_R_PAREN);
    }
    else     if (foo instanceof cpp_grammar.Absyn.EStr)
    {
       cpp_grammar.Absyn.EStr _estr = (cpp_grammar.Absyn.EStr) foo;
       if (_i_ > 2) render(_L_PAREN);
       printQuoted(_estr.string_);
       if (_i_ > 2) render(_R_PAREN);
    }
    else     if (foo instanceof cpp_grammar.Absyn.EId)
    {
       cpp_grammar.Absyn.EId _eid = (cpp_grammar.Absyn.EId) foo;
       if (_i_ > 2) render(_L_PAREN);
       pp(_eid.ident_, 0);
       if (_i_ > 2) render(_R_PAREN);
    }
    else     if (foo instanceof cpp_grammar.Absyn.ELs)
    {
       cpp_grammar.Absyn.ELs _els = (cpp_grammar.Absyn.ELs) foo;
       if (_i_ > 1) render(_L_PAREN);
       pp(_els.exp_1, 0);
       render("<<");
       pp(_els.exp_2, 0);
       if (_i_ > 1) render(_R_PAREN);
    }
    else     if (foo instanceof cpp_grammar.Absyn.EAss)
    {
       cpp_grammar.Absyn.EAss _eass = (cpp_grammar.Absyn.EAss) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_eass.ident_, 0);
       render("=");
       pp(_eass.exp_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(cpp_grammar.Absyn.ListExp foo, int _i_)
  {
     for (java.util.Iterator<Exp> it = foo.iterator(); it.hasNext();)
     {
       pp(it.next(), _i_);
       if (it.hasNext()) {
         render(",");
       } else {
         render("");
       }
     }  }

  private static void pp(cpp_grammar.Absyn.Type foo, int _i_)
  {
    if (foo instanceof cpp_grammar.Absyn.Tint)
    {
       cpp_grammar.Absyn.Tint _tint = (cpp_grammar.Absyn.Tint) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("int");
       if (_i_ > 0) render(_R_PAREN);
    }
  }


  private static void sh(cpp_grammar.Absyn.Program foo)
  {
    if (foo instanceof cpp_grammar.Absyn.Prog)
    {
       cpp_grammar.Absyn.Prog _prog = (cpp_grammar.Absyn.Prog) foo;
       render("(");
       render("Prog");
       render("[");
       sh(_prog.listfunction_);
       render("]");
       render(")");
    }
  }

  private static void sh(cpp_grammar.Absyn.Function foo)
  {
    if (foo instanceof cpp_grammar.Absyn.Fun)
    {
       cpp_grammar.Absyn.Fun _fun = (cpp_grammar.Absyn.Fun) foo;
       render("(");
       render("Fun");
       sh(_fun.type_);
       sh(_fun.ident_);
       render("[");
       sh(_fun.listarg_);
       render("]");
       render("[");
       sh(_fun.liststm_);
       render("]");
       render(")");
    }
  }

  private static void sh(cpp_grammar.Absyn.Arg foo)
  {
    if (foo instanceof cpp_grammar.Absyn.Dec)
    {
       cpp_grammar.Absyn.Dec _dec = (cpp_grammar.Absyn.Dec) foo;
       render("(");
       render("Dec");
       sh(_dec.type_);
       render("[");
       sh(_dec.listident_);
       render("]");
       render(")");
    }
  }

  private static void sh(cpp_grammar.Absyn.ListFunction foo)
  {
     for (java.util.Iterator<Function> it = foo.iterator(); it.hasNext();)
     {
       sh(it.next());
       if (it.hasNext())
         render(",");
     }
  }

  private static void sh(cpp_grammar.Absyn.ListStm foo)
  {
     for (java.util.Iterator<Stm> it = foo.iterator(); it.hasNext();)
     {
       sh(it.next());
       if (it.hasNext())
         render(",");
     }
  }

  private static void sh(cpp_grammar.Absyn.ListArg foo)
  {
     for (java.util.Iterator<Arg> it = foo.iterator(); it.hasNext();)
     {
       sh(it.next());
       if (it.hasNext())
         render(",");
     }
  }

  private static void sh(cpp_grammar.Absyn.ListIdent foo)
  {
     for (java.util.Iterator<String> it = foo.iterator(); it.hasNext();)
     {
       sh(it.next());
       if (it.hasNext())
         render(",");
     }
  }

  private static void sh(cpp_grammar.Absyn.Stm foo)
  {
    if (foo instanceof cpp_grammar.Absyn.SDecl)
    {
       cpp_grammar.Absyn.SDecl _sdecl = (cpp_grammar.Absyn.SDecl) foo;
       render("(");
       render("SDecl");
       sh(_sdecl.arg_);
       render(")");
    }
    if (foo instanceof cpp_grammar.Absyn.SExp)
    {
       cpp_grammar.Absyn.SExp _sexp = (cpp_grammar.Absyn.SExp) foo;
       render("(");
       render("SExp");
       sh(_sexp.exp_);
       render(")");
    }
    if (foo instanceof cpp_grammar.Absyn.SReturn)
    {
       cpp_grammar.Absyn.SReturn _sreturn = (cpp_grammar.Absyn.SReturn) foo;
       render("(");
       render("SReturn");
       sh(_sreturn.exp_);
       render(")");
    }
    if (foo instanceof cpp_grammar.Absyn.SBlock)
    {
       cpp_grammar.Absyn.SBlock _sblock = (cpp_grammar.Absyn.SBlock) foo;
       render("(");
       render("SBlock");
       render("[");
       sh(_sblock.liststm_);
       render("]");
       render(")");
    }
  }

  private static void sh(cpp_grammar.Absyn.Exp foo)
  {
    if (foo instanceof cpp_grammar.Absyn.EInt)
    {
       cpp_grammar.Absyn.EInt _eint = (cpp_grammar.Absyn.EInt) foo;
       render("(");
       render("EInt");
       sh(_eint.integer_);
       render(")");
    }
    if (foo instanceof cpp_grammar.Absyn.EStr)
    {
       cpp_grammar.Absyn.EStr _estr = (cpp_grammar.Absyn.EStr) foo;
       render("(");
       render("EStr");
       sh(_estr.string_);
       render(")");
    }
    if (foo instanceof cpp_grammar.Absyn.EId)
    {
       cpp_grammar.Absyn.EId _eid = (cpp_grammar.Absyn.EId) foo;
       render("(");
       render("EId");
       sh(_eid.ident_);
       render(")");
    }
    if (foo instanceof cpp_grammar.Absyn.ELs)
    {
       cpp_grammar.Absyn.ELs _els = (cpp_grammar.Absyn.ELs) foo;
       render("(");
       render("ELs");
       sh(_els.exp_1);
       sh(_els.exp_2);
       render(")");
    }
    if (foo instanceof cpp_grammar.Absyn.EAss)
    {
       cpp_grammar.Absyn.EAss _eass = (cpp_grammar.Absyn.EAss) foo;
       render("(");
       render("EAss");
       sh(_eass.ident_);
       sh(_eass.exp_);
       render(")");
    }
  }

  private static void sh(cpp_grammar.Absyn.ListExp foo)
  {
     for (java.util.Iterator<Exp> it = foo.iterator(); it.hasNext();)
     {
       sh(it.next());
       if (it.hasNext())
         render(",");
     }
  }

  private static void sh(cpp_grammar.Absyn.Type foo)
  {
    if (foo instanceof cpp_grammar.Absyn.Tint)
    {
       cpp_grammar.Absyn.Tint _tint = (cpp_grammar.Absyn.Tint) foo;
       render("Tint");
    }
  }


  private static void pp(Integer n, int _i_) { buf_.append(n); buf_.append(" "); }
  private static void pp(Double d, int _i_) { buf_.append(d); buf_.append(" "); }
  private static void pp(String s, int _i_) { buf_.append(s); buf_.append(" "); }
  private static void pp(Character c, int _i_) { buf_.append("'" + c.toString() + "'"); buf_.append(" "); }
  private static void sh(Integer n) { render(n.toString()); }
  private static void sh(Double d) { render(d.toString()); }
  private static void sh(Character c) { render(c.toString()); }
  private static void sh(String s) { printQuoted(s); }
  private static void printQuoted(String s) { render("\"" + s + "\""); }
  private static void indent()
  {
    int n = _n_;
    while (n > 0)
    {
      buf_.append(" ");
      n--;
    }
  }
  private static void backup()
  {
     if (buf_.charAt(buf_.length() - 1) == ' ') {
      buf_.setLength(buf_.length() - 1);
    }
  }
  private static void trim()
  {
     while (buf_.length() > 0 && buf_.charAt(0) == ' ')
        buf_.deleteCharAt(0); 
    while (buf_.length() > 0 && buf_.charAt(buf_.length()-1) == ' ')
        buf_.deleteCharAt(buf_.length()-1);
  }
  private static int _n_ = 0;
  private static StringBuilder buf_ = new StringBuilder(INITIAL_BUFFER_SIZE);
}

