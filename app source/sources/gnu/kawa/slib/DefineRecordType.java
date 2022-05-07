package gnu.kawa.slib;

import com.microsoft.appcenter.ingestion.models.CommonProperties;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.kawa.functions.GetNamedPart;
import gnu.kawa.lispexpr.LispLanguage;
import gnu.lists.Consumer;
import gnu.lists.LList;
import gnu.lists.PairWithPosition;
import gnu.mapping.CallContext;
import gnu.mapping.SimpleSymbol;
import kawa.lang.Macro;
import kawa.lang.SyntaxPattern;
import kawa.lang.SyntaxRule;
import kawa.lang.SyntaxRules;

/* compiled from: DefineRecordType.scm */
public class DefineRecordType extends ModuleBody {
    public static final Macro $Prvt$$Pcdefine$Mnrecord$Mnfield = Macro.make(Lit2, Lit3, $instance);
    public static final DefineRecordType $instance;
    static final SimpleSymbol Lit0;
    static final SyntaxRules Lit1;
    static final SimpleSymbol Lit10;
    static final SimpleSymbol Lit11;
    static final SimpleSymbol Lit12;
    static final SimpleSymbol Lit2;
    static final SyntaxRules Lit3;
    static final SimpleSymbol Lit4;
    static final SimpleSymbol Lit5;
    static final SimpleSymbol Lit6;
    static final SimpleSymbol Lit7;
    static final SimpleSymbol Lit8;
    static final SimpleSymbol Lit9;
    public static final Macro define$Mnrecord$Mntype = Macro.make(Lit0, Lit1, $instance);

    public DefineRecordType() {
        ModuleInfo.register(this);
    }

    static {
        SimpleSymbol simpleSymbol;
        SimpleSymbol simpleSymbol2;
        SimpleSymbol simpleSymbol3;
        SimpleSymbol simpleSymbol4;
        SimpleSymbol simpleSymbol5;
        SimpleSymbol simpleSymbol6;
        SimpleSymbol simpleSymbol7;
        SimpleSymbol simpleSymbol8;
        SimpleSymbol simpleSymbol9;
        SyntaxRules syntaxRules;
        SimpleSymbol simpleSymbol10;
        SyntaxRule syntaxRule;
        SyntaxPattern syntaxPattern;
        SyntaxRule syntaxRule2;
        SyntaxPattern syntaxPattern2;
        SimpleSymbol simpleSymbol11;
        SyntaxRules syntaxRules2;
        SimpleSymbol simpleSymbol12;
        SyntaxRule syntaxRule3;
        SyntaxPattern syntaxPattern3;
        SimpleSymbol simpleSymbol13;
        SimpleSymbol simpleSymbol14;
        SimpleSymbol simpleSymbol15;
        SimpleSymbol simpleSymbol16;
        SimpleSymbol simpleSymbol17;
        DefineRecordType defineRecordType;
        new SimpleSymbol("tmp");
        Lit12 = (SimpleSymbol) simpleSymbol.readResolve();
        new SimpleSymbol("slot-set!");
        Lit11 = (SimpleSymbol) simpleSymbol2.readResolve();
        new SimpleSymbol("begin");
        Lit10 = (SimpleSymbol) simpleSymbol3.readResolve();
        new SimpleSymbol(CommonProperties.VALUE);
        Lit9 = (SimpleSymbol) simpleSymbol4.readResolve();
        new SimpleSymbol(LispLanguage.quote_sym);
        Lit8 = (SimpleSymbol) simpleSymbol5.readResolve();
        new SimpleSymbol("slot-ref");
        Lit7 = (SimpleSymbol) simpleSymbol6.readResolve();
        new SimpleSymbol("::");
        Lit6 = (SimpleSymbol) simpleSymbol7.readResolve();
        new SimpleSymbol("obj");
        Lit5 = (SimpleSymbol) simpleSymbol8.readResolve();
        new SimpleSymbol("define");
        Lit4 = (SimpleSymbol) simpleSymbol9.readResolve();
        SyntaxRules syntaxRules3 = syntaxRules;
        Object[] objArr = new Object[1];
        Object[] objArr2 = objArr;
        Object[] objArr3 = objArr;
        new SimpleSymbol("%define-record-field");
        SimpleSymbol simpleSymbol18 = (SimpleSymbol) simpleSymbol10.readResolve();
        Lit2 = simpleSymbol18;
        objArr3[0] = simpleSymbol18;
        SyntaxRule[] syntaxRuleArr = new SyntaxRule[2];
        SyntaxRule[] syntaxRuleArr2 = syntaxRuleArr;
        SyntaxRule[] syntaxRuleArr3 = syntaxRuleArr;
        SyntaxRule syntaxRule4 = syntaxRule;
        SyntaxPattern syntaxPattern4 = syntaxPattern;
        new SyntaxPattern("\f\u0018\f\u0007\f\u000f\f\u0017\b", new Object[0], 3);
        Object[] objArr4 = new Object[5];
        objArr4[0] = Lit4;
        Object[] objArr5 = objArr4;
        objArr5[1] = Lit5;
        Object[] objArr6 = objArr5;
        objArr6[2] = Lit6;
        Object[] objArr7 = objArr6;
        objArr7[3] = Lit7;
        Object[] objArr8 = objArr7;
        objArr8[4] = Lit8;
        new SyntaxRule(syntaxPattern4, "\u0001\u0001\u0001", "\u0011\u0018\u0004Y\t\u0013\b\u0011\u0018\f\u0011\u0018\u0014\b\u0003\b\u0011\u0018\u001c\u0011\u0018\f\b\u0011\u0018$\b\u000b", objArr8, 0);
        syntaxRuleArr3[0] = syntaxRule4;
        SyntaxRule[] syntaxRuleArr4 = syntaxRuleArr2;
        SyntaxRule[] syntaxRuleArr5 = syntaxRuleArr4;
        SyntaxRule[] syntaxRuleArr6 = syntaxRuleArr4;
        SyntaxRule syntaxRule5 = syntaxRule2;
        SyntaxPattern syntaxPattern5 = syntaxPattern2;
        new SyntaxPattern("\f\u0018\f\u0007\f\u000f\f\u0017\f\u001f\b", new Object[0], 4);
        Object[] objArr9 = new Object[10];
        objArr9[0] = Lit10;
        Object[] objArr10 = objArr9;
        objArr10[1] = Lit4;
        Object[] objArr11 = objArr10;
        objArr11[2] = Lit5;
        Object[] objArr12 = objArr11;
        objArr12[3] = Lit6;
        Object[] objArr13 = objArr12;
        objArr13[4] = Lit7;
        Object[] objArr14 = objArr13;
        objArr14[5] = Lit8;
        Object[] objArr15 = objArr14;
        objArr15[6] = PairWithPosition.make(Lit9, LList.Empty, "/u2/home/jis/ai2-kawa/gnu/kawa/slib/DefineRecordType.scm", 208936);
        Object[] objArr16 = objArr15;
        new SimpleSymbol("<void>");
        objArr16[7] = (SimpleSymbol) simpleSymbol11.readResolve();
        Object[] objArr17 = objArr16;
        objArr17[8] = Lit11;
        Object[] objArr18 = objArr17;
        objArr18[9] = PairWithPosition.make(Lit9, LList.Empty, "/u2/home/jis/ai2-kawa/gnu/kawa/slib/DefineRecordType.scm", 213021);
        new SyntaxRule(syntaxPattern5, "\u0001\u0001\u0001\u0001", "\u0011\u0018\u0004á\u0011\u0018\fY\t\u0013\b\u0011\u0018\u0014\u0011\u0018\u001c\b\u0003\b\u0011\u0018$\u0011\u0018\u0014\b\u0011\u0018,\b\u000b\b\u0011\u0018\fi\t\u001bA\u0011\u0018\u0014\u0011\u0018\u001c\b\u0003\u00184\u0011\u0018\u001c\u0011\u0018<\b\u0011\u0018D\u0011\u0018\u0014)\u0011\u0018,\b\u000b\u0018L", objArr18, 0);
        syntaxRuleArr6[1] = syntaxRule5;
        new SyntaxRules(objArr2, syntaxRuleArr5, 4);
        Lit3 = syntaxRules3;
        SyntaxRules syntaxRules4 = syntaxRules2;
        Object[] objArr19 = new Object[1];
        Object[] objArr20 = objArr19;
        Object[] objArr21 = objArr19;
        new SimpleSymbol("define-record-type");
        SimpleSymbol simpleSymbol19 = (SimpleSymbol) simpleSymbol12.readResolve();
        Lit0 = simpleSymbol19;
        objArr21[0] = simpleSymbol19;
        SyntaxRule[] syntaxRuleArr7 = new SyntaxRule[1];
        SyntaxRule[] syntaxRuleArr8 = syntaxRuleArr7;
        SyntaxRule[] syntaxRuleArr9 = syntaxRuleArr7;
        SyntaxRule syntaxRule6 = syntaxRule3;
        SyntaxPattern syntaxPattern6 = syntaxPattern3;
        new SyntaxPattern("\f\u0018\f\u0007<\f\u000f\r\u0017\u0010\b\b\f\u001f-\f'\f/3 \u0018\b", new Object[0], 7);
        Object[] objArr22 = new Object[15];
        objArr22[0] = Lit10;
        Object[] objArr23 = objArr22;
        new SimpleSymbol("define-simple-class");
        objArr23[1] = (SimpleSymbol) simpleSymbol13.readResolve();
        Object[] objArr24 = objArr23;
        objArr24[2] = Lit4;
        Object[] objArr25 = objArr24;
        objArr25[3] = PairWithPosition.make(Lit5, LList.Empty, "/u2/home/jis/ai2-kawa/gnu/kawa/slib/DefineRecordType.scm", 122907);
        Object[] objArr26 = objArr25;
        objArr26[4] = Lit6;
        Object[] objArr27 = objArr26;
        new SimpleSymbol("<boolean>");
        objArr27[5] = (SimpleSymbol) simpleSymbol14.readResolve();
        Object[] objArr28 = objArr27;
        new SimpleSymbol(GetNamedPart.INSTANCEOF_METHOD_NAME);
        objArr28[6] = (SimpleSymbol) simpleSymbol15.readResolve();
        Object[] objArr29 = objArr28;
        objArr29[7] = Lit5;
        Object[] objArr30 = objArr29;
        new SimpleSymbol("let");
        objArr30[8] = (SimpleSymbol) simpleSymbol16.readResolve();
        Object[] objArr31 = objArr30;
        objArr31[9] = Lit12;
        Object[] objArr32 = objArr31;
        new SimpleSymbol("make");
        objArr32[10] = (SimpleSymbol) simpleSymbol17.readResolve();
        Object[] objArr33 = objArr32;
        objArr33[11] = Lit11;
        Object[] objArr34 = objArr33;
        objArr34[12] = Lit8;
        Object[] objArr35 = objArr34;
        objArr35[13] = PairWithPosition.make(Lit12, LList.Empty, "/u2/home/jis/ai2-kawa/gnu/kawa/slib/DefineRecordType.scm", 143365);
        Object[] objArr36 = objArr35;
        objArr36[14] = Lit2;
        new SyntaxRule(syntaxPattern6, "\u0001\u0001\u0003\u0001\u0003\u0003\u0002", "\u0011\u0018\u0004Y\u0011\u0018\f\t\u0003\t\u0010\b%\b#¹\u0011\u0018\u0014!\t\u001b\u0018\u001c\u0011\u0018$\u0011\u0018,\b\u0011\u00184\u0011\u0018<\b\u0003ǁ\u0011\u0018\u0014)\t\u000b\b\u0015\u0013\u0011\u0018$\t\u0003\b\u0011\u0018Dy\b\u0011\u0018L\u0011\u0018$\t\u0003\b\u0011\u0018T\b\u0003\u0011\u0018\u0004\b\u0015\u0011\u0018\\\u0011\u0018L)\u0011\u0018d\b\u0013\b\u0013\u0018l\b%\u0011\u0018t\t\u0003\t#\t+2", objArr36, 1);
        syntaxRuleArr9[0] = syntaxRule6;
        new SyntaxRules(objArr20, syntaxRuleArr8, 7);
        Lit1 = syntaxRules4;
        new DefineRecordType();
        $instance = defineRecordType;
        $instance.run();
    }

    public final void run(CallContext $ctx) {
        Consumer consumer = $ctx.consumer;
    }
}
