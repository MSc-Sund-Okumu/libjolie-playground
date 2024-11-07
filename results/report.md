# Parsing Context Errors

WrongColumn :x: means that the ParsingContext has the same startColumn and endColumn, :white_check_mark: means that they differ.

Wrongcode :x: means that the ParsingContext has an empty list of code strings, :white_check_mark: means that atleast one code string exists.

Note that these are very simple tests and the ParsingContext may still be wrong.

| OLSyntaxNode | WrongColumn | WrongCode |
|--------------|-------------|-----------|
|ServiceNode|:white_check_mark:|:white_check_mark:|
|DefinitionNode|:x:|:white_check_mark:|
|RequestResponseOperationDeclaration|:x:|:white_check_mark:|
|Program|:x:|:x:|
|TypeInlineDefinition|:x:|:x:|
|InterfaceDefinition|:white_check_mark:|:white_check_mark:|
|ExecutionInfo|:white_check_mark:|:white_check_mark:|
|ImportStatement|:white_check_mark:|:white_check_mark:|
|InputPortInfo|:white_check_mark:|:white_check_mark:|
|VariablePathNode|:white_check_mark:|:white_check_mark:|
|ConstantStringExpression|:white_check_mark:|:white_check_mark:|
|VariableExpressionNode|:white_check_mark:|:white_check_mark:|
