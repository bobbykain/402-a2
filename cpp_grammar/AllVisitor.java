package cpp_grammar;

import cpp_grammar.Absyn.*;

/** BNFC-Generated All Visitor */
public interface AllVisitor<R,A> extends
  cpp_grammar.Absyn.Program.Visitor<R,A>,
  cpp_grammar.Absyn.Function.Visitor<R,A>,
  cpp_grammar.Absyn.Arg.Visitor<R,A>,
  cpp_grammar.Absyn.Stm.Visitor<R,A>,
  cpp_grammar.Absyn.Exp.Visitor<R,A>,
  cpp_grammar.Absyn.Type.Visitor<R,A>
{}
