//=================================================================
//Copyright (C) 2010 Pierre Lison (plison@dfki.de)

//This library is free software; you can redistribute it and/or
//modify it under the terms of the GNU Lesser General Public License
//as published by the Free Software Foundation; either version 2.1 of
//the License, or (at your option) any later version.

//This library is distributed in the hope that it will be useful, but
//WITHOUT ANY WARRANTY; without even the implied warranty of
//MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
//Lesser General Public License for more details.

//You should have received a copy of the GNU Lesser General Public
//License along with this program; if not, write to the Free Software
//Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA
//02111-1307, USA.
//=================================================================

//=================================================================
//PACKAGE DEFINITION
package de.dfki.lt.tr.dialogue.parse.examplegeneration;

//=================================================================
//IMPORTS

// Dialogue API
import de.dfki.lt.tr.dialogue.util.*;

/* Generated By:JavaCC: Do not edit this line. SemCorpusParser.java */
import java.util.Vector ;
import java.util.Enumeration ;
import java.io.* ;
import java.util.Hashtable;


public class SemCorpusParser implements SemCorpusParserConstants {

        static Hashtable<String, Integer> counts = new Hashtable<String, Integer>();
               public static void main(String args[]) throws ParseException {
          try {
                File f = new File ("data/CosyGrammar_classbased.txt") ;
        SemCorpusParser parser = new SemCorpusParser((new FileInputStream(f)));
        CFG cfg = parser.Input();
                log(cfg.toString());
      }
      catch (Exception e) {e.printStackTrace();}
      }

private static int getIndex(String str) {
        int index= 1;
        if (counts.containsKey(str)) {
                counts.put(str, new Integer(counts.get(str)+1));
                index = counts.get(str);
        }
        else {
                counts.put(str, new Integer(1));
        }
        return index;
}

  private static void log(String s) {
        System.out.println("[SemCorpusParser] " +s) ;
  }

  static int increment=0 ;

  static int semIncrement=1;

  static final public String Ontology() throws ParseException {
        String result = "";
        Token tok;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case COLON:
      jj_consume_token(COLON);
      tok = jj_consume_token(T);
         result = ":" + tok.toString();
      break;
    default:
      jj_la1[0] = jj_gen;
      ;
    }
{if (true) return result;}
    throw new Error("Missing return statement in function");
  }

  static final public String Semantics() throws ParseException {
        String semantics = "";
        Token tok;
        String sub;
        String onto;
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case LPAR:
      case NT:
      case T:
      case MOD:
      case IND:
      case LAND:
      case NOMINAL:
        ;
        break;
      default:
        jj_la1[1] = jj_gen;
        break label_1;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case T:
        tok = jj_consume_token(T);
         semantics = semantics + tok.toString();
        break;
      case NT:
        tok = jj_consume_token(NT);
         semantics = semantics + tok.toString();
        break;
      case LPAR:
        tok = jj_consume_token(LPAR);
        sub = Semantics();
        jj_consume_token(RPAR);
         semantics = semantics + "(" + sub + ")";
        break;
      case MOD:
        tok = jj_consume_token(MOD);
         semantics = semantics + " " + tok.toString() ;
        break;
      case LAND:
        tok = jj_consume_token(LAND);
         semantics = semantics + " " + tok.toString()  + " ";
        break;
      case IND:
        tok = jj_consume_token(IND);
         semantics = semantics + " " + tok.toString();
        break;
      case NOMINAL:
        tok = jj_consume_token(NOMINAL);
        onto = Ontology();
         semantics = semantics + tok.toString() + onto;
        break;
      default:
        jj_la1[2] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
         {if (true) return semantics.trim();}
    throw new Error("Missing return statement in function");
  }

  static final public Vector<Rule> ParPath() throws ParseException {
        Vector<Rule> RHSs = new Vector<Rule>();
                String sem ;
    jj_consume_token(LPAR);
    RHSs = Path();
    jj_consume_token(RPAR);
    jj_consume_token(COLON);
    jj_consume_token(LBRACKET);
    sem = Semantics();
    jj_consume_token(RBRACKET);
        for(Enumeration<Rule> e = RHSs.elements(); e.hasMoreElements(); ) {
                Rule RHS = e.nextElement();
                RHS.setSemantics(sem);
        }
        {if (true) return RHSs;}
    throw new Error("Missing return statement in function");
  }

  static final public Vector<Rule> Path() throws ParseException {
        Vector<Rule> RHSs = new Vector<Rule>();
        Rule firstRHS = new Rule();
        RHSs.add(firstRHS);
        Vector<Rule> RHSs2 ;
        Token tok ;
    label_2:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case T:
        tok = jj_consume_token(T);
                        for(Enumeration<Rule> e = RHSs.elements(); e.hasMoreElements(); ) {
                                Rule RHS = e.nextElement();
                                RHS.addToRHS(tok.toString());
                        }
        break;
      case NT:
        tok = jj_consume_token(NT);
                        for(Enumeration<Rule> e = RHSs.elements(); e.hasMoreElements(); ) {
                                Rule RHS = e.nextElement();
                                RHS.addToRHS(tok.toString());
                        }
        break;
      case LPAR:
        jj_consume_token(LPAR);
        RHSs2 = Path();
        jj_consume_token(RPAR);
                        for(Enumeration<Rule> e = RHSs.elements(); e.hasMoreElements(); ) {
                                Rule RHS = e.nextElement();
                                for(Enumeration<Rule> f = RHSs2.elements(); f.hasMoreElements(); ) {
                                        Rule RHS2 = f.nextElement();
                                        RHS.addToRHS(RHS2);
                                }
                        }
        break;
      case 18:
        jj_consume_token(18);
        jj_consume_token(LPAR);
        RHSs2 = Path();
        jj_consume_token(RPAR);
                                        Vector<Rule> newRHSs = new Vector<Rule>();
                        for(Enumeration<Rule> e = RHSs.elements(); e.hasMoreElements(); ) {
                            Rule RHS = e.nextElement();
                                Rule newRHS = new Rule();
                                newRHS.addToRHS(RHS);
                                newRHSs.add(newRHS);
                                for(Enumeration<Rule> f = RHSs2.elements(); f.hasMoreElements(); ) {
                                    Rule RHS2 = f.nextElement();

                                        RHS.addToRHS(RHS2);
                                }
                        }
                        RHSs.addAll(newRHSs);
        break;
      default:
        jj_la1[3] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case LPAR:
      case NT:
      case T:
      case 18:
        ;
        break;
      default:
        jj_la1[4] = jj_gen;
        break label_2;
      }
    }
                        {if (true) return RHSs;}
    throw new Error("Missing return statement in function");
  }

  static final public Vector<Rule> AlterList() throws ParseException {
        Vector<Rule> RHSs = new Vector<Rule>();
        Rule RHS;
        Vector<Rule> RHSs2 ;
        Token tok ;
    label_3:
    while (true) {
      RHSs2 = ParPath();
                RHSs.addAll(RHSs2);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case LPAR:
        ;
        break;
      default:
        jj_la1[5] = jj_gen;
        break label_3;
      }
    }
             {if (true) return RHSs;}
    throw new Error("Missing return statement in function");
  }

  static final public CFG NTSpecification() throws ParseException {
        CFG cfg = new CFG();
        Token Id;
        Vector<Rule> RHSs;
    Id = jj_consume_token(NT);
                String NonTerm = Id.toString();
                cfg.setStartSymbol(NonTerm);
    jj_consume_token(LBRACKET);
    RHSs = AlterList();
                cfg.addRules2(NonTerm, RHSs);
    jj_consume_token(RBRACKET);
                         {if (true) return cfg;}
    throw new Error("Missing return statement in function");
  }

  static final public CFG Input() throws ParseException {
        CFG cfg = new CFG();
        CFG initCFG ;
        CFG subCFG ;
    initCFG = NTSpecification();
                cfg.setStartSymbol(initCFG.getStartSymbol());
                cfg.addRules(initCFG.getRules());
    label_4:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case NT:
        ;
        break;
      default:
        jj_la1[6] = jj_gen;
        break label_4;
      }
      subCFG = NTSpecification();
                cfg.addRules(subCFG.getRules());
    }
                {if (true) return cfg;}
    throw new Error("Missing return statement in function");
  }

  static private boolean jj_initialized_once = false;
  static public SemCorpusParserTokenManager token_source;
  static SimpleCharStream jj_input_stream;
  static public Token token, jj_nt;
  static private int jj_ntk;
  static private int jj_gen;
  static final private int[] jj_la1 = new int[7];
  static private int[] jj_la1_0;
  static {
      jj_la1_0();
   }
   private static void jj_la1_0() {
      jj_la1_0 = new int[] {0x40,0x3f400,0x3f400,0x43400,0x43400,0x400,0x1000,};
   }

  public SemCorpusParser(java.io.InputStream stream) {
     this(stream, null);
  }
  public SemCorpusParser(java.io.InputStream stream, String encoding) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser.  You must");
      System.out.println("       either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new SemCorpusParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 7; i++) jj_la1[i] = -1;
  }

  static public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  static public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 7; i++) jj_la1[i] = -1;
  }

  public SemCorpusParser(java.io.Reader stream) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser.  You must");
      System.out.println("       either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new SemCorpusParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 7; i++) jj_la1[i] = -1;
  }

  static public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 7; i++) jj_la1[i] = -1;
  }

  public SemCorpusParser(SemCorpusParserTokenManager tm) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser.  You must");
      System.out.println("       either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 7; i++) jj_la1[i] = -1;
  }

  public void ReInit(SemCorpusParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 7; i++) jj_la1[i] = -1;
  }

  static final private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }

  static final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

  static final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  static final private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  static private java.util.Vector jj_expentries = new java.util.Vector();
  static private int[] jj_expentry;
  static private int jj_kind = -1;

  static public ParseException generateParseException() {
    jj_expentries.removeAllElements();
    boolean[] la1tokens = new boolean[19];
    for (int i = 0; i < 19; i++) {
      la1tokens[i] = false;
    }
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 7; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 19; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.addElement(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = (int[])jj_expentries.elementAt(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  static final public void enable_tracing() {
  }

  static final public void disable_tracing() {
  }

}
