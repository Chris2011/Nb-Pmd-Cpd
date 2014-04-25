/*
 * CpdSettings.java
 *
 * Created on 13. September 2006, 21:23
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package org.huberb.cpd.options;

import java.util.prefs.Preferences;
import net.sourceforge.pmd.cpd.CSVRenderer;
//import net.sourceforge.pmd.cpd.LanguageFactory;
import net.sourceforge.pmd.cpd.Renderer;
import net.sourceforge.pmd.cpd.SimpleRenderer;
import net.sourceforge.pmd.cpd.XMLRenderer;
import org.huberb.cpd.cpdlib.CpdInternalRenderer;
import org.openide.util.NbPreferences;
import org.openide.util.NbBundle;
import org.openide.util.SharedClassObject;

/**
 * Options of the CPD module.
 *
 * @author HuberB1
 */
public class CpdSettings extends SharedClassObject {

    private static final long serialVersionUID = 20060913215300L;

    private final static String IGNORE_IDENTIFIERS_PROP = "ignoreIdentifiers";
    private final static String IGNORE_LITERALS_PROP = "ignoreLiterals";
    private final static String LANGUAGE_PROP = "language";
    private final static String LANGUAGE_EXT_PROP = "languagExt";
    private final static String MINIMAL_TOKEN_COUNT_PROP = "minimalTokenCount";
    private final static String RECURSIVLY_PROP = "recursivly";
    private final static String RENDERER_ENUM_PROP = "rendererEnum";

//    private final Preferences _pref;
    private final String[] _supportedStrings;

    /**
     * Creates a new instance of CpdSettings
     */
    public CpdSettings() {
//        this._pref = NbPreferences.forModule(CpdSettings.class);
        this._supportedStrings = new String[]{"java", "jsp", "cpp", "c", "php", "ruby", "fortran", "ecmascript", "cs", "plsql"};
    }

    public String displayName() {
        return NbBundle.getMessage(CpdSettings.class, "AdvancedOption_DisplayName");
    }

    /**
     * Initialize shared state. Should use {@link #putProperty} to set up variables. Subclasses should always call the
     * super method.
     * <p>
     * This method need <em>not</em> be called explicitly; it will be called once the first time a given shared class is
     * used (not for each instance!).
     */
    protected void initialize() {
        super.initialize();

        setIgnoreIdentifiers(Boolean.FALSE);
        setIgnoreLiterals(Boolean.FALSE);
//        setLanguage(LanguageFactory.JAVA_KEY);
        setLanguage(this._supportedStrings[0]); // Default langauge.
        setLanguageExt("text");
        setMinimalTokenCount(75);
        setRecursivly(Boolean.TRUE);

        setRendererEnum(RendererEnum.Text);
    }

    public static CpdSettings getDefault() {
//        return (CpdSettings)SystemOption.findObject( CpdSettings.class, true );
        return SharedClassObject.findObject(CpdSettings.class, true);
    }

    //----
    public Boolean getIgnoreIdentifiers() {
//        return this._pref.getBoolean("IGNORE_IDENTIFIERS_PROP", false);
        return (Boolean)this.getProperty("IGNORE_IDENTIFIERS_PROP");
    }

    public void setIgnoreIdentifiers(Boolean newValue) {
        this.putProperty(IGNORE_IDENTIFIERS_PROP, newValue);
    }

    //----
    public Boolean getIgnoreLiterals() {
        return (Boolean)this.getProperty(IGNORE_LITERALS_PROP);
    }

    public void setIgnoreLiterals(Boolean newValue) {
        this.putProperty(IGNORE_LITERALS_PROP, newValue);
    }

    //----
    public String getLanguage() {
        return (String)this.getProperty(LANGUAGE_PROP);
    }

    public void setLanguage(String newValue) {
        this.putProperty(LANGUAGE_PROP, newValue);
    }

    //----
    public String getLanguageExt() {
        return (String)this.getProperty(LANGUAGE_EXT_PROP);
    }

    public void setLanguageExt(String newValue) {
        this.putProperty(LANGUAGE_EXT_PROP, newValue);
    }

    //----
    public Integer getMinimalTokenCount() {
//        return this._pref.getInt(MINIMAL_TOKEN_COUNT_PROP, 3);
        return (Integer)this.getProperty(MINIMAL_TOKEN_COUNT_PROP);
    }

    public void setMinimalTokenCount(Integer newValue) {
//        this._pref.putInt(MINIMAL_TOKEN_COUNT_PROP, newValue);
        this.putProperty(MINIMAL_TOKEN_COUNT_PROP, newValue);
    }

    //----
    public Boolean getRecursivly() {
        return (Boolean)this.getProperty(RECURSIVLY_PROP);
    }

    public void setRecursivly(Boolean newValue) {
        this.putProperty(RECURSIVLY_PROP, newValue);
    }

    public static enum RendererEnum {

        Text, Xml, Csv, Internal;

        private final static long serialVersionUID = 2007042100L;

        public Renderer createRenderer() {
            Renderer renderer = null;
            switch (this) {
                case Text:
                    renderer = new SimpleRenderer();
                    break;
                case Csv:
                    renderer = new CSVRenderer();
                    break;
                case Xml:
                    renderer = new XMLRenderer();
                    break;
                case Internal:
                default:
                    renderer = new CpdInternalRenderer();
                    break;
            }
            return renderer;
        }
    }

    //----
    public RendererEnum getRendererEnum() {
        RendererEnum value = (RendererEnum) this.getProperty(RENDERER_ENUM_PROP);
        return value;
    }

    public void setRendererEnum(RendererEnum newValue) {
        this.putProperty(RENDERER_ENUM_PROP, newValue, true);
    }
}