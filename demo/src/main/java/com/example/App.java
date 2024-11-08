package com.example;

import jolie.js.JsUtils;
import jolie.lang.parse.context.ParsingContext;
import jolie.lang.parse.util.ParsingUtils;
import jolie.Interpreter;
import jolie.cli.CommandLineParser;

import java.io.*;
import java.net.URI;
import java.nio.file.*;
import java.util.Optional;

import jolie.lang.parse.SemanticVerifier;
import jolie.lang.parse.SemanticVerifier.Configuration;
import jolie.lang.parse.ast.*;
import jolie.lang.parse.ast.Program;
import jolie.lang.parse.ast.ServiceNode;
import jolie.lang.parse.ast.VariablePathNode.Type;
import jolie.lang.parse.util.*;
import jolie.runtime.Value;
import org.json.*;

/**
 * Hello world!
 *
 */
public class App {

    private static boolean deleteDirectory(File directoryToBeDeleted) {
        File[] allContents = directoryToBeDeleted.listFiles();
        if (allContents != null) {
            for (File file : allContents) {
                deleteDirectory(file);
            }
        }
        return directoryToBeDeleted.delete();
    }

    public static void main(String[] args) {
        Path mainFilePath = Paths.get("jolie-program/main.ol");

        String jolieHomePath = System.getenv("JOLIE_HOME");
        System.out.println(jolieHomePath);
        String[] includePaths = new String[] { jolieHomePath + "/include", mainFilePath.getParent().toUri().toString() };
        String[] cliArgs = new String[] {mainFilePath.toUri().toString()};
        
        try (FileReader mainFileReader = new FileReader(
            mainFilePath.toFile()
        )) {
            CommandLineParser cliParser = new CommandLineParser(cliArgs, App.class.getClassLoader(), false);

            Interpreter.Configuration configuration = cliParser.getInterpreterConfiguration();
            Optional<Value> params = Optional.of( Value.create() );
            if( configuration.parametersPath().isPresent() ) {
                Path paramsPath = configuration.parametersPath().get();
                try( Reader fileReader = Files.newBufferedReader( paramsPath ) ) {
                    JsUtils.parseJsonIntoValue( fileReader, params.get(), true );
                }
            }
            System.out.println("includePath = " + configuration.includePaths());
            SemanticVerifier.Configuration semanticVerificationConfiguration = new Configuration(
                configuration.executionTarget());
            URI mainFileUri = mainFilePath.toUri();
            ClassLoader classLoader = configuration.jolieClassLoader();
            InputStream mainFileInputStream = new FileInputStream(mainFilePath.toFile());
            Program mainProgram = ParsingUtils.parseProgram(mainFileInputStream, mainFileUri,
                    mainFileReader.getEncoding(), includePaths, configuration.packagePaths(), classLoader,
                    configuration.constants(), semanticVerificationConfiguration, true);

            //Remove the files in the results directory
            File results = new File("results");
            deleteDirectory(results);
            results.mkdir();

            ParsingContextVisitor parsingContextVisitor = new ParsingContextVisitor();
            JSONObject visitorJSON = mainProgram.accept(parsingContextVisitor, mainProgram.context());
            BufferedWriter output = new BufferedWriter(new FileWriter("results/AST-jolie-program.json", true));
            visitorJSON.write(output);
            output.close();

            //Copy template.md and generate report.md
            Files.copy(Paths.get("template.md"), Paths.get("results/report.md"), StandardCopyOption.REPLACE_EXISTING);

            parsingContextVisitor.getNodes()
                    .forEach(node -> {
                        boolean wrongColumn = parsingContextVisitor.getWrongColumn().contains(node);
                        boolean wrongCode = parsingContextVisitor.getWrongCode().contains(node);
                        String line = "|" + node + "|" + (wrongColumn ? ":x:" : ":white_check_mark:") + "|" + (wrongCode ? ":x:" : ":white_check_mark:") + "|" + "\n";
                        try {
                            Files.writeString(Paths.get("results/report.md"), line, StandardOpenOption.APPEND);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });

            System.out.println(parsingContextVisitor.getNodes().toString());

        } catch (Exception e) {
            e.printStackTrace();
        }

        //
        System.out.println("Hello World!");
    }
}
