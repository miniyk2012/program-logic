package jacoco;

import org.jacoco.core.analysis.Analyzer;
import org.jacoco.core.analysis.CoverageBuilder;
import org.jacoco.core.analysis.IClassCoverage;
import org.jacoco.core.analysis.ICounter;
import org.jacoco.core.data.ExecutionDataStore;
import org.jacoco.core.data.SessionInfoStore;
import org.jacoco.core.instr.Instrumenter;
import org.jacoco.core.runtime.IRuntime;
import org.jacoco.core.runtime.LoggerRuntime;
import org.jacoco.core.runtime.RuntimeData;
import org.jacoco.report.DirectorySourceFileLocator;
import org.jacoco.report.FileMultiReportOutput;
import org.jacoco.report.IReportVisitor;
import org.jacoco.report.html.HTMLFormatter;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Example usage of the JaCoCo core API. In this tutorial a single target class
 * will be instrumented and executed. Finally the coverage information will be
 * dumped.
 */
public final class CoreTutorial {

    /**
     * The test target we want to see code coverage for.
     */
    public static class TestTarget implements Runnable {

        public void run() {
            isPrime(7);
        }

        private boolean isPrime(final int n) {
            for (int i = 2; i * i <= n; i++) {
                if ((n ^ i) == 0) {
                    return false;
                }
            }
            return true;
        }

    }

    /**
     * A class loader that loads classes from in-memory data.
     */
    public static class MemoryClassLoader extends ClassLoader {

        private final Map<String, byte[]> definitions = new HashMap<String, byte[]>();

        /**
         * Add a in-memory representation of a class.
         *
         * @param name  name of the class
         * @param bytes class definition
         */
        public void addDefinition(final String name, final byte[] bytes) {
            definitions.put(name, bytes);
        }

        @Override
        protected Class<?> loadClass(final String name, final boolean resolve)
                throws ClassNotFoundException {
            final byte[] bytes = definitions.get(name);
            if (bytes != null) {
                return defineClass(name, bytes, 0, bytes.length);
            }
            return super.loadClass(name, resolve);
        }

    }

    private final PrintStream out;

    /**
     * Creates a new example instance printing to the given stream.
     *
     * @param out stream for outputs
     */
    public CoreTutorial(final PrintStream out) {
        this.out = out;
    }

    /**
     * Run this example.
     *
     * @throws Exception in case of errors
     */
    public void execute() throws Exception {
        final String targetName = TestTarget.class.getName();

        // For instrumentation and runtime we need a IRuntime instance
        // to collect execution data:
        final IRuntime runtime = new LoggerRuntime();

        // The Instrumenter creates a modified version of our test target class
        // that contains additional probes for execution data recording:
        final Instrumenter instr = new Instrumenter(runtime);
        InputStream original = getTargetClass(targetName);
        // instrumented是打桩后的字节码
        final byte[] instrumented = instr.instrument(original, targetName);
        original.close();

        // Now we're ready to run our instrumented class and need to startup the
        // runtime first:
        final RuntimeData data = new RuntimeData();
        runtime.startup(data);

        // In this tutorial we use a special class loader to directly load the
        // instrumented class definition from a byte[] instances.
        final MemoryClassLoader memoryClassLoader = new MemoryClassLoader();
        memoryClassLoader.addDefinition(targetName, instrumented);
        final Class<?> targetClass = memoryClassLoader.loadClass(targetName);

        // Here we execute our test target class through its Runnable interface:
        final Runnable targetInstance = (Runnable) targetClass.newInstance();
        targetInstance.run();

        // At the end of test execution we collect execution data and shutdown
        // the runtime:
        final ExecutionDataStore executionData = new ExecutionDataStore();
        final SessionInfoStore sessionInfos = new SessionInfoStore();
        data.collect(executionData, sessionInfos, false);
        runtime.shutdown();

        // Together with the original class definition we can calculate coverage
        // information:
        final CoverageBuilder coverageBuilder = new CoverageBuilder();
        final Analyzer analyzer = new Analyzer(executionData, coverageBuilder);
        original = getTargetClass(targetName);
        analyzer.analyzeClass(original, targetName);
        original.close();

        // Let's dump some metrics and line coverage information:
        for (final IClassCoverage cc : coverageBuilder.getClasses()) {
            out.printf("Coverage of class %s%n", cc.getName());

            printCounter("instructions", cc.getInstructionCounter());
            printCounter("branches", cc.getBranchCounter());
            printCounter("lines", cc.getLineCounter());
            printCounter("methods", cc.getMethodCounter());
            printCounter("complexity", cc.getComplexityCounter());

            for (int i = cc.getFirstLine(); i <= cc.getLastLine(); i++) {
                out.printf("Line %s: %s%n", Integer.valueOf(i),
                        getColor(cc.getLine(i).getStatus()));
            }
        }
        generate_report(executionData, sessionInfos, coverageBuilder);
        return;

    }

    private void generate_report(ExecutionDataStore executionData, SessionInfoStore sessionInfos, CoverageBuilder coverageBuilder) throws IOException {
        // Create a concrete report visitor based on some supplied
        // configuration. In this case we use the defaults
        final HTMLFormatter htmlFormatter = new HTMLFormatter();
        final IReportVisitor visitor = htmlFormatter
                .createVisitor(new FileMultiReportOutput(new File("/Users/admin/Documents/javaprojects/program-logic/src/main/resources", "coveragereport")));

        // Initialize the report with all of the execution and session
        // information. At this point the report doesn't know about the
        // structure of the report being created
        visitor.visitInfo(sessionInfos.getInfos(),
                executionData.getContents());

        // Populate the report structure with the bundle coverage information.
        // Call visitGroup if you need groups in your report.
        visitor.visitBundle(coverageBuilder.getBundle("xxx"),
                new DirectorySourceFileLocator(new File("/Users/admin/Documents/javaprojects/program-logic/src/main/java"), "utf-8", 4));

        // Signal end of structure information to allow report to write all
        // information out
        visitor.visitEnd();
    }

    private InputStream getTargetClass(final String name) {
        final String resource = '/' + name.replace('.', '/') + ".class";
        out.printf("%s%n", resource);
        return getClass().getResourceAsStream(resource);
    }

    private void printCounter(final String unit, final ICounter counter) {
        final Integer missed = Integer.valueOf(counter.getMissedCount());
        final Integer total = Integer.valueOf(counter.getTotalCount());
        out.printf("%s of %s %s missed%n", missed, total, unit);
    }

    private String getColor(final int status) {
        switch (status) {
            case ICounter.NOT_COVERED:
                return "red";
            case ICounter.PARTLY_COVERED:
                return "yellow";
            case ICounter.FULLY_COVERED:
                return "green";
        }
        return "";
    }

    /**
     * Entry point to run this examples as a Java application.
     *
     * @param args list of program arguments
     * @throws Exception in case of errors
     */
    public static void main(final String[] args) throws Exception {
        new CoreTutorial(System.out).execute();
    }

}
