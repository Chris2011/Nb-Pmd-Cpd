/*
 * ModelFactory.java
 *
 * Created on 21. April 2007, 20:24
 * Edited on 11. April 2014, 10:00
 */
package org.huberb.cpd.options;

import edu.emory.mathcs.backport.java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import net.sourceforge.pmd.cpd.LanguageFactory;

/**
 * A factory for creating ComboBoxModels.
 *
 * @author HuberB1
 */
public class ModelFactory {

    /**
     * Creates a new instance of ModelFactory
     */
    private ModelFactory() {
    }

    /**
     * Create a combobox model for a language accepted by CPD
     */
    public static ComboBoxModel createLanguageComboBoxModel() {
        // java, jsp, cpp, c, php, ruby, fortran, ecmascript, cs, plsql
        final List<String> supportedLanguages = new ArrayList<>(Arrays.asList(LanguageFactory.supportedLanguages));
        supportedLanguages.add(LanguageFactory.BY_EXTENSION);

        final DefaultComboBoxModel dcbm = new DefaultComboBoxModel(supportedLanguages.toArray());

        return dcbm;
    }

    /**
     * Create a combobox model for a renderer
     */
    public static ComboBoxModel createRendererComboBoxModel() {
        final CpdSettings.RendererEnum[] items = CpdSettings.RendererEnum.values();
        final DefaultComboBoxModel dcbm = new DefaultComboBoxModel(items);

        return dcbm;
    }
}