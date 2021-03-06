package betsy.executables.analytics.html

import betsy.executables.analytics.CsvReportLoader
import betsy.executables.analytics.model.CsvReport
import groovy.text.SimpleTemplateEngine

class HtmlAnalytics {

    CsvReport report

    public static void main(String[] args) {
        new HtmlAnalytics(report: new CsvReportLoader(csvFile: "test/reports/results.csv").load()).toHtmlReport("test/reports/myreport.html")
    }

    void toHtmlReport(String filename) {
        def engine = new SimpleTemplateEngine()
        def template = engine.createTemplate(new File("src\\main\\groovy\\betsy\\executables\\analytics\\html\\HtmlAnalytics.template").text).make([
                "report": report
        ])

        new File(filename).withWriter("UTF-8") { it.write(template.toString()) }
    }

}
