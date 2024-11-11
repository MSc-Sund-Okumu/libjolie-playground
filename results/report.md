# Parsing Context Errors

WrongColumn :x: means that the ParsingContext has the same startColumn and endColumn, :white_check_mark: means that they differ.

Wrongcode :x: means that the ParsingContext has an empty list of code strings, :white_check_mark: means that atleast one code string exists.

Note that these are very simple tests and the ParsingContext may still be wrong.


## Report for folder: analytics

| OLSyntaxNode | WrongColumn | WrongCode |
|--------------|-------------|-----------|
|ServiceNodeJava|:white_check_mark:|:white_check_mark:|
|ServiceNode|:white_check_mark:|:white_check_mark:|
|Program|:x:|:x:|
|OneWayOperationDeclaration|:white_check_mark:|:white_check_mark:|
|OutputPortInfo|:white_check_mark:|:white_check_mark:|
|InterfaceDefinition|:white_check_mark:|:white_check_mark:|
|ExecutionInfo|:white_check_mark:|:white_check_mark:|
|TypeDefinitionLink|:white_check_mark:|:white_check_mark:|
|ImportStatement|:white_check_mark:|:white_check_mark:|
|InputPortInfo|:white_check_mark:|:white_check_mark:|
|VariablePathNode|:white_check_mark:|:white_check_mark:|
|ConstantStringExpression|:x:|:white_check_mark:|
|SolicitResponseOperationStatement|:white_check_mark:|:white_check_mark:|
|EmbedServiceNode|:white_check_mark:|:white_check_mark:|
|OneWayOperationStatement|:x:|:white_check_mark:|
|DefinitionNode|:x:|:white_check_mark:|
|RequestResponseOperationDeclaration|:x:|:white_check_mark:|
|SumExpressionNode|:white_check_mark:|:white_check_mark:|
|TypeDefinitionUndefined|:x:|:x:|
|TypeInlineDefinition|:x:|:x:|
|VariableExpressionNode|:white_check_mark:|:white_check_mark:|
|NDChoiceStatement|:x:|:white_check_mark:|

## Report for folder: courier-api-key

| OLSyntaxNode | WrongColumn | WrongCode |
|--------------|-------------|-----------|
|ServiceNode|:white_check_mark:|:white_check_mark:|
|InterfaceDefinition|:white_check_mark:|:white_check_mark:|
|ExecutionInfo|:white_check_mark:|:white_check_mark:|
|ImportStatement|:white_check_mark:|:white_check_mark:|
|InputPortInfo|:white_check_mark:|:white_check_mark:|
|SolicitResponseOperationStatement|:white_check_mark:|:white_check_mark:|
|SumExpressionNode|:white_check_mark:|:white_check_mark:|
|TypeDefinitionUndefined|:x:|:x:|
|TypeInlineDefinition|:x:|:x:|
|RequestResponseOperationStatement|:x:|:white_check_mark:|
|VariableExpressionNode|:white_check_mark:|:white_check_mark:|
|ServiceNodeJava|:white_check_mark:|:white_check_mark:|
|Program|:x:|:x:|
|OutputPortInfo|:white_check_mark:|:white_check_mark:|
|CompareConditionNode|:x:|:white_check_mark:|
|VariablePathNode|:x:|:white_check_mark:|
|ConstantStringExpression|:x:|:white_check_mark:|
|AssignStatement|:white_check_mark:|:white_check_mark:|
|EmbedServiceNode|:white_check_mark:|:white_check_mark:|
|ConstantIntegerExpression|:white_check_mark:|:white_check_mark:|
|DefinitionNode|:white_check_mark:|:white_check_mark:|
|RequestResponseOperationDeclaration|:x:|:white_check_mark:|
|TypeChoiceDefinition|:white_check_mark:|:white_check_mark:|
|ProductExpressionNode|:white_check_mark:|:white_check_mark:|
|CourierDefinitionNode|:x:|:white_check_mark:|
|CourierChoiceStatement|:x:|:white_check_mark:|
|SequenceStatement|:white_check_mark:|:white_check_mark:|

## Report for folder: exceptions

| OLSyntaxNode | WrongColumn | WrongCode |
|--------------|-------------|-----------|
|ServiceNode|:white_check_mark:|:white_check_mark:|
|InterfaceDefinition|:white_check_mark:|:white_check_mark:|
|ExecutionInfo|:white_check_mark:|:white_check_mark:|
|ImportStatement|:white_check_mark:|:white_check_mark:|
|InputPortInfo|:white_check_mark:|:white_check_mark:|
|SolicitResponseOperationStatement|:white_check_mark:|:white_check_mark:|
|TypeDefinitionUndefined|:x:|:x:|
|TypeInlineDefinition|:x:|:x:|
|ThrowStatement|:x:|:white_check_mark:|
|RequestResponseOperationStatement|:x:|:white_check_mark:|
|VariableExpressionNode|:white_check_mark:|:white_check_mark:|
|ServiceNodeJava|:white_check_mark:|:white_check_mark:|
|Program|:x:|:x:|
|OutputPortInfo|:white_check_mark:|:white_check_mark:|
|InstallStatement|:x:|:white_check_mark:|
|VariablePathNode|:x:|:white_check_mark:|
|ConstantStringExpression|:x:|:white_check_mark:|
|AssignStatement|:white_check_mark:|:white_check_mark:|
|EmbedServiceNode|:white_check_mark:|:white_check_mark:|
|DefinitionNode|:x:|:white_check_mark:|
|RequestResponseOperationDeclaration|:x:|:white_check_mark:|
|Scope|:white_check_mark:|:white_check_mark:|
|NullProcessStatement|:x:|:white_check_mark:|
|NDChoiceStatement|:x:|:white_check_mark:|
|SequenceStatement|:white_check_mark:|:white_check_mark:|

## Report for folder: notification

| OLSyntaxNode | WrongColumn | WrongCode |
|--------------|-------------|-----------|
|ServiceNode|:white_check_mark:|:white_check_mark:|
|Program|:x:|:x:|
|OneWayOperationDeclaration|:white_check_mark:|:white_check_mark:|
|InterfaceDefinition|:white_check_mark:|:white_check_mark:|
|ExecutionInfo|:white_check_mark:|:white_check_mark:|
|TypeDefinitionLink|:white_check_mark:|:white_check_mark:|
|ImportStatement|:white_check_mark:|:white_check_mark:|
|InputPortInfo|:white_check_mark:|:white_check_mark:|
|VariablePathNode|:white_check_mark:|:white_check_mark:|
|ConstantStringExpression|:white_check_mark:|:white_check_mark:|
|OneWayOperationStatement|:x:|:white_check_mark:|
|DefinitionNode|:x:|:white_check_mark:|
|TypeInlineDefinition|:x:|:white_check_mark:|
|NullProcessStatement|:x:|:white_check_mark:|
|VariableExpressionNode|:white_check_mark:|:white_check_mark:|
|NDChoiceStatement|:x:|:white_check_mark:|

## Report for folder: order

| OLSyntaxNode | WrongColumn | WrongCode |
|--------------|-------------|-----------|
|ServiceNode|:white_check_mark:|:white_check_mark:|
|Program|:x:|:x:|
|OutputPortInfo|:white_check_mark:|:white_check_mark:|
|OneWayOperationDeclaration|:white_check_mark:|:white_check_mark:|
|InterfaceDefinition|:white_check_mark:|:white_check_mark:|
|ExecutionInfo|:white_check_mark:|:white_check_mark:|
|TypeDefinitionLink|:x:|:white_check_mark:|
|ImportStatement|:white_check_mark:|:white_check_mark:|
|InputPortInfo|:white_check_mark:|:white_check_mark:|
|VariablePathNode|:x:|:white_check_mark:|
|ConstantStringExpression|:x:|:white_check_mark:|
|DefinitionNode|:x:|:white_check_mark:|
|RequestResponseOperationDeclaration|:x:|:white_check_mark:|
|TypeInlineDefinition|:x:|:white_check_mark:|
|NullProcessStatement|:x:|:white_check_mark:|
|RequestResponseOperationStatement|:x:|:white_check_mark:|
|VariableExpressionNode|:white_check_mark:|:white_check_mark:|
|NDChoiceStatement|:x:|:white_check_mark:|

## Report for folder: parameterized-service

| OLSyntaxNode | WrongColumn | WrongCode |
|--------------|-------------|-----------|
|ServiceNode|:white_check_mark:|:white_check_mark:|
|Program|:x:|:x:|
|InterfaceDefinition|:white_check_mark:|:white_check_mark:|
|ExecutionInfo|:white_check_mark:|:white_check_mark:|
|InputPortInfo|:white_check_mark:|:white_check_mark:|
|VariablePathNode|:x:|:white_check_mark:|
|ConstantStringExpression|:x:|:white_check_mark:|
|AssignStatement|:white_check_mark:|:white_check_mark:|
|DefinitionNode|:white_check_mark:|:white_check_mark:|
|RequestResponseOperationDeclaration|:x:|:white_check_mark:|
|TypeInlineDefinition|:x:|:x:|
|ProductExpressionNode|:white_check_mark:|:white_check_mark:|
|RequestResponseOperationStatement|:x:|:white_check_mark:|
|VariableExpressionNode|:white_check_mark:|:white_check_mark:|

## Report for folder: payment

| OLSyntaxNode | WrongColumn | WrongCode |
|--------------|-------------|-----------|
|ServiceNode|:white_check_mark:|:white_check_mark:|
|Program|:x:|:x:|
|OutputPortInfo|:white_check_mark:|:white_check_mark:|
|OneWayOperationDeclaration|:white_check_mark:|:white_check_mark:|
|InterfaceDefinition|:white_check_mark:|:white_check_mark:|
|ExecutionInfo|:white_check_mark:|:white_check_mark:|
|InlineTreeExpressionNode|:white_check_mark:|:white_check_mark:|
|TypeDefinitionLink|:x:|:white_check_mark:|
|NotificationOperationStatement|:white_check_mark:|:white_check_mark:|
|ImportStatement|:white_check_mark:|:white_check_mark:|
|InputPortInfo|:white_check_mark:|:white_check_mark:|
|VariablePathNode|:x:|:white_check_mark:|
|ConstantStringExpression|:x:|:white_check_mark:|
|DefinitionNode|:x:|:white_check_mark:|
|VoidExpressionNode|:x:|:white_check_mark:|
|RequestResponseOperationDeclaration|:x:|:white_check_mark:|
|TypeInlineDefinition|:x:|:white_check_mark:|
|NullProcessStatement|:x:|:white_check_mark:|
|RequestResponseOperationStatement|:x:|:white_check_mark:|
|VariableExpressionNode|:white_check_mark:|:white_check_mark:|
|NDChoiceStatement|:x:|:white_check_mark:|
|SequenceStatement|:white_check_mark:|:white_check_mark:|

## Report for folder: product

| OLSyntaxNode | WrongColumn | WrongCode |
|--------------|-------------|-----------|
|ServiceNode|:white_check_mark:|:white_check_mark:|
|ConstantBoolExpression|:white_check_mark:|:white_check_mark:|
|OneWayOperationDeclaration|:white_check_mark:|:white_check_mark:|
|InterfaceDefinition|:white_check_mark:|:white_check_mark:|
|ExecutionInfo|:white_check_mark:|:white_check_mark:|
|TypeDefinitionLink|:x:|:white_check_mark:|
|NotificationOperationStatement|:white_check_mark:|:white_check_mark:|
|ImportStatement|:white_check_mark:|:white_check_mark:|
|InputPortInfo|:white_check_mark:|:white_check_mark:|
|VoidExpressionNode|:x:|:white_check_mark:|
|SumExpressionNode|:white_check_mark:|:white_check_mark:|
|TypeInlineDefinition|:x:|:white_check_mark:|
|RequestResponseOperationStatement|:x:|:white_check_mark:|
|VariableExpressionNode|:white_check_mark:|:white_check_mark:|
|Program|:x:|:x:|
|OutputPortInfo|:white_check_mark:|:white_check_mark:|
|InlineTreeExpressionNode|:white_check_mark:|:white_check_mark:|
|VariablePathNode|:x:|:white_check_mark:|
|ConstantStringExpression|:x:|:white_check_mark:|
|AssignStatement|:x:|:white_check_mark:|
|ConstantIntegerExpression|:white_check_mark:|:white_check_mark:|
|DefinitionNode|:x:|:white_check_mark:|
|RequestResponseOperationDeclaration|:x:|:white_check_mark:|
|NullProcessStatement|:x:|:white_check_mark:|
|NDChoiceStatement|:x:|:white_check_mark:|
|SequenceStatement|:white_check_mark:|:white_check_mark:|

## Report for folder: recommendation

| OLSyntaxNode | WrongColumn | WrongCode |
|--------------|-------------|-----------|
|ServiceNode|:white_check_mark:|:white_check_mark:|
|Program|:x:|:x:|
|InterfaceDefinition|:white_check_mark:|:white_check_mark:|
|ExecutionInfo|:white_check_mark:|:white_check_mark:|
|TypeDefinitionLink|:x:|:white_check_mark:|
|ImportStatement|:white_check_mark:|:white_check_mark:|
|InputPortInfo|:white_check_mark:|:white_check_mark:|
|VariablePathNode|:x:|:white_check_mark:|
|ConstantStringExpression|:x:|:white_check_mark:|
|DefinitionNode|:x:|:white_check_mark:|
|RequestResponseOperationDeclaration|:x:|:white_check_mark:|
|TypeInlineDefinition|:x:|:white_check_mark:|
|NullProcessStatement|:x:|:white_check_mark:|
|RequestResponseOperationStatement|:x:|:white_check_mark:|
|VariableExpressionNode|:white_check_mark:|:white_check_mark:|
|NDChoiceStatement|:x:|:white_check_mark:|

## Report for folder: test1

| OLSyntaxNode | WrongColumn | WrongCode |
|--------------|-------------|-----------|
|ServiceNodeJava|:white_check_mark:|:white_check_mark:|
|ServiceNode|:white_check_mark:|:white_check_mark:|
|Program|:x:|:x:|
|OutputPortInfo|:white_check_mark:|:white_check_mark:|
|InterfaceDefinition|:white_check_mark:|:white_check_mark:|
|ExecutionInfo|:white_check_mark:|:white_check_mark:|
|ImportStatement|:white_check_mark:|:white_check_mark:|
|InputPortInfo|:white_check_mark:|:white_check_mark:|
|VariablePathNode|:x:|:white_check_mark:|
|ConstantStringExpression|:x:|:white_check_mark:|
|SolicitResponseOperationStatement|:white_check_mark:|:white_check_mark:|
|AssignStatement|:white_check_mark:|:white_check_mark:|
|EmbedServiceNode|:white_check_mark:|:white_check_mark:|
|DefinitionNode|:x:|:white_check_mark:|
|RequestResponseOperationDeclaration|:x:|:white_check_mark:|
|TypeDefinitionUndefined|:x:|:x:|
|TypeInlineDefinition|:x:|:x:|
|NullProcessStatement|:x:|:white_check_mark:|
|RequestResponseOperationStatement|:x:|:white_check_mark:|
|VariableExpressionNode|:white_check_mark:|:white_check_mark:|
|NDChoiceStatement|:x:|:white_check_mark:|
|SequenceStatement|:white_check_mark:|:white_check_mark:|

## Report for folder: test2

| OLSyntaxNode | WrongColumn | WrongCode |
|--------------|-------------|-----------|
|ServiceNode|:white_check_mark:|:white_check_mark:|
|Program|:x:|:x:|
|OneWayOperationDeclaration|:white_check_mark:|:white_check_mark:|
|OutputPortInfo|:white_check_mark:|:white_check_mark:|
|InterfaceDefinition|:white_check_mark:|:white_check_mark:|
|ExecutionInfo|:white_check_mark:|:white_check_mark:|
|ImportStatement|:white_check_mark:|:white_check_mark:|
|InputPortInfo|:white_check_mark:|:white_check_mark:|
|VariablePathNode|:x:|:white_check_mark:|
|EmbeddedServiceNode|:x:|:white_check_mark:|
|ConstantStringExpression|:x:|:white_check_mark:|
|SolicitResponseOperationStatement|:white_check_mark:|:white_check_mark:|
|AssignStatement|:white_check_mark:|:white_check_mark:|
|DefinitionNode|:x:|:white_check_mark:|
|RequestResponseOperationDeclaration|:x:|:white_check_mark:|
|TypeDefinitionUndefined|:x:|:x:|
|TypeInlineDefinition|:x:|:x:|
|NullProcessStatement|:x:|:white_check_mark:|
|RequestResponseOperationStatement|:x:|:white_check_mark:|
|VariableExpressionNode|:white_check_mark:|:white_check_mark:|
|NDChoiceStatement|:x:|:white_check_mark:|
|SequenceStatement|:white_check_mark:|:white_check_mark:|

## Report for folder: user

| OLSyntaxNode | WrongColumn | WrongCode |
|--------------|-------------|-----------|
|ServiceNode|:white_check_mark:|:white_check_mark:|
|ConstantBoolExpression|:white_check_mark:|:white_check_mark:|
|OneWayOperationDeclaration|:white_check_mark:|:white_check_mark:|
|InterfaceDefinition|:white_check_mark:|:white_check_mark:|
|ExecutionInfo|:white_check_mark:|:white_check_mark:|
|TypeDefinitionLink|:x:|:white_check_mark:|
|NotificationOperationStatement|:white_check_mark:|:white_check_mark:|
|ImportStatement|:white_check_mark:|:white_check_mark:|
|InputPortInfo|:white_check_mark:|:white_check_mark:|
|VoidExpressionNode|:x:|:white_check_mark:|
|SumExpressionNode|:white_check_mark:|:white_check_mark:|
|TypeInlineDefinition|:x:|:white_check_mark:|
|RequestResponseOperationStatement|:x:|:white_check_mark:|
|VariableExpressionNode|:white_check_mark:|:white_check_mark:|
|Program|:x:|:x:|
|OutputPortInfo|:white_check_mark:|:white_check_mark:|
|InlineTreeExpressionNode|:white_check_mark:|:white_check_mark:|
|VariablePathNode|:x:|:white_check_mark:|
|ConstantStringExpression|:x:|:white_check_mark:|
|AssignStatement|:x:|:white_check_mark:|
|ConstantIntegerExpression|:white_check_mark:|:white_check_mark:|
|DefinitionNode|:x:|:white_check_mark:|
|RequestResponseOperationDeclaration|:x:|:white_check_mark:|
|NullProcessStatement|:x:|:white_check_mark:|
|NDChoiceStatement|:x:|:white_check_mark:|
|SequenceStatement|:white_check_mark:|:white_check_mark:|

