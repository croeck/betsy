package betsy.executables.analytics

import betsy.executables.analytics.html.HtmlAnalytics
import betsy.executables.analytics.model.CsvReport
import betsy.executables.analytics.texresults.LatexAnalytics
import betsy.executables.analytics.textables.TechReportBpelTable


class Analyzer {

    AntBuilder ant = new AntBuilder()

    String csvFilePath
    String reportsFolderPath

    public void createAnalytics() {
        // load model
        CsvReport csvModel = new CsvReportLoader(csvFile: csvFilePath).load()

        // analytics
        new HtmlAnalytics(report: csvModel).toHtmlReport("${reportsFolderPath}/results.html")
        new LatexAnalytics(report: csvModel).toLatexReport("${reportsFolderPath}/results.tex")
        new TechReportBpelTable(report: csvModel).toLatexReport("${reportsFolderPath}/tables.tex")
    }

}
