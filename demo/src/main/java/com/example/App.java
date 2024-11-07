package com.example;

import jolie.lang.parse.context.ParsingContext;
import jolie.lang.parse.util.ParsingUtils;
import jolie.Interpreter;
import jolie.cli.CommandLineParser;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.net.URI;

import jolie.lang.parse.SemanticVerifier;
import jolie.lang.parse.SemanticVerifier.Configuration;
import jolie.lang.parse.ast.*;
import jolie.lang.parse.ast.Program;
import jolie.lang.parse.ast.ServiceNode;
import jolie.lang.parse.ast.VariablePathNode.Type;
import jolie.lang.parse.util.*;
import org.json.*;

/**
 * Hello world!
 *
 */
public class App {


    public static void main(String[] args) {
        String mainFilePath = "file:///Users/99sun/Documents/GitHub/libjolie-playground/jolie-program/main.ol";
        String jolieHomePath = System.getenv("JOLIE_HOME");
        String programFolder = "file:///Users/99sun/Documents/GitHub/libjolie-playground/jolie-program";
        String[] includePaths = new String[] { jolieHomePath, programFolder };
        String[] cliArgs = new String[] {mainFilePath};
        
        try (FileReader mainFileReader = new FileReader(
            "/Users/99sun/Documents/GitHub/libjolie-playground/jolie-program/main.ol"
        )) {
            CommandLineParser cliParser = new CommandLineParser(cliArgs, App.class.getClassLoader());
            Interpreter.Configuration configuration = cliParser.getInterpreterConfiguration();
            SemanticVerifier.Configuration semanticVerificationConfiguration = new Configuration(
                configuration.executionTarget());
            URI mainFileUri = new URI(mainFilePath);
            ClassLoader classLoader = configuration.jolieClassLoader();
            InputStream mainFileInputStream = new FileInputStream("/Users/99sun/Documents/GitHub/libjolie-playground/jolie-program/main.ol");
            Program mainProgram = ParsingUtils.parseProgram(mainFileInputStream, mainFileUri,
                    mainFileReader.getEncoding(), includePaths, configuration.packagePaths(), classLoader,
                    configuration.constants(), semanticVerificationConfiguration, true);

            ParsingContextVisitor parsingContextVisitor = new ParsingContextVisitor();

            JSONObject visitorJSON = mainProgram.accept(parsingContextVisitor, mainProgram.context());
            ParsingContext mainContext = mainProgram.context();
            JSONObject contextObject = new JSONObject();
            contextObject.put("parsingContext", mainContext);
            System.out.println(contextObject);

            //JSONObject context2Object = new JSONObject();
            //context2Object.put("parsingContext", parsingContextToJSON(mainContext));
            System.out.println(visitorJSON.toString(2));

            /*SemanticVerifier semanticVerifier = ParsingUtils.parseProgramModule(
                    mainFileInputStream, mainFileUri,
                    mainFileReader.getEncoding(), includePaths, configuration.packagePaths(), classLoader,
                    configuration.constants(), semanticVerificationConfiguration, true
            );
            */
            //ProgramInspector inspector = ParsingUtils.createInspector(mainProgram);
            
            //ProgramBuilder programBuilder = new ProgramBuilder(mainProgram.context());
            //ImportStatement importStatement = (ImportStatement)mainProgram.children().get(0);
            System.out.println("UwU");
            /* ServiceNode serviceNode = (ServiceNode)mainProgram.children().get(1);
            //for (var child: serviceNode.program().children())
            //    System.out.println(child.toString());
            DefinitionNode definitionNode = (DefinitionNode)serviceNode.program().children().get(2);
            NDChoiceStatement ndChoiceStatement = (NDChoiceStatement)definitionNode.body();
            RequestResponseOperationStatement rrOperationStatement = (RequestResponseOperationStatement)ndChoiceStatement.children().get(0).key();
            VariablePathNode variablePathNode = rrOperationStatement.inputVarPath();
            
            System.out.println(variablePathNode); */


        } catch (Exception e) {
            e.printStackTrace();
        }

        //
        System.out.println("Hello World!");
    }
}
