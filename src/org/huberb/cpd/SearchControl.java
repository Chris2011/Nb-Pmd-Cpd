package org.huberb.cpd;

//import org.netbeans.api.annotations.common.NonNull;
//import org.netbeans.api.annotations.common.NullAllowed;
//import org.netbeans.api.search.SearchPattern;
//import org.netbeans.api.search.SearchScopeOptions;
//import org.netbeans.modules.search.BasicSearchProvider;
//import org.netbeans.modules.search.ResultView;
//import org.netbeans.modules.search.SearchPanel;
import org.netbeans.spi.search.provider.SearchProvider;

/**
 * This class enables users to show search dialog and start searches
 * programatically.
 *
 * @author jhavlin
 */
public final class SearchControl {

    private SearchControl() {
        // hiding default constructor
    }

    /**
     * Shows dialog for basic search task.
     *
     * If options are not specified (null is passed), previous or default values
     * are used.
     */
//    public static void openFindDialog(
//            @NullAllowed SearchPattern searchPattern,
//            @NullAllowed SearchScopeOptions searchScopeOptions,
//            @NullAllowed Boolean useIgnoreList,
//            @NullAllowed String scopeId) {
//
//        SearchControl.openFindDialog(BasicSearchProvider.createBasicPresenter(
//                false, searchPattern, null, false, searchScopeOptions,
//                useIgnoreList, scopeId));
//    }

    /**
     * Show find dialog with a concrete presenter for one of providers.
     *
     * @param presenter Presenter to use, possibly initialized with proper
     * values.
     */
    public static void openFindDialog(SearchProvider.Presenter presenter) {
        SearchControl.openDialog(false, presenter);
    }

    /**
     * Open dialog with one explicit presenter.
     */
    private static void openDialog(boolean replaceMode, SearchProvider.Presenter presenter)
    {
        SearchPanel current = SearchPanel.getCurrentlyShown();
        if (current != null) {
            current.close();
        }
//        if (ResultView.getInstance().isFocused()) {
//            ResultView.getInstance().markCurrentTabAsReusable();
//        }
        new SearchPanel(replaceMode, presenter).showDialog();
    }

    /**
     * Start basic search for specified parameters.
     *
     * @param scopeId Identifier of search scope (e.g. "main project", "open
     * projects", "node selection", "browse"). If not specified, the default one
     * is used.
     * @throws IllegalArgumentException if neither non-trivial file name pattern
     * nor non-empty text search pattern is specified.
     */
//    public static void startBasicSearch(
//            @NonNull SearchPattern searchPattern,
//            @NonNull SearchScopeOptions searchScopeOptions,
//            @NullAllowed String scopeId) throws IllegalArgumentException {
//        BasicSearchProvider.startSearch(searchPattern, searchScopeOptions,
//                scopeId);
//    }
}
