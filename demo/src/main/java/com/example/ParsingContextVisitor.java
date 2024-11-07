package com.example;
import jolie.lang.parse.OLVisitor;
import jolie.lang.parse.ast.*;
import jolie.lang.parse.ast.types.TypeDefinition;
import jolie.lang.parse.context.ParsingContext;
import jolie.lang.parse.ast.courier.CourierChoiceStatement;
import jolie.lang.parse.ast.courier.CourierDefinitionNode;
import jolie.lang.parse.ast.courier.NotificationForwardStatement;
import jolie.lang.parse.ast.courier.SolicitResponseForwardStatement;
import jolie.lang.parse.ast.expression.*;
import jolie.lang.parse.ast.types.TypeChoiceDefinition;
import jolie.lang.parse.ast.types.TypeDefinitionLink;
import jolie.lang.parse.ast.types.TypeInlineDefinition;
import jolie.util.Pair;
import org.json.*;

import java.util.Map;

public class ParsingContextVisitor implements OLVisitor<ParsingContext, JSONObject> {
    public static JSONObject parsingContextToJSON(ParsingContext context){
        JSONObject inner = new JSONObject();
        inner.put("startLine", context.startLine());
        inner.put("source", context.source());
        inner.put("endLine", context.endLine());
        inner.put("startColumn", context.startColumn());
        inner.put("endColumn", context.endColumn());
        inner.put("code", context.enclosingCode());

        JSONObject outer = new JSONObject();
        outer.put("ParsingContext", inner);

        return outer;
    }

    public static JSONObject wrap(Object node, JSONObject obj) {
        JSONObject wrapper = new JSONObject();
        wrapper.put(node.getClass().getSimpleName(), obj);
        return wrapper;
    }

    private JSONObject operationMapToJSON(InterfaceDefinition n) {
        JSONObject operationsMapObj = new JSONObject();
        for (Map.Entry<String, OperationDeclaration> entry : n.operationsMap().entrySet()) {
            operationsMapObj.put(entry.getKey(), entry.getValue().accept(this, null));
        }
        return operationsMapObj;
    }

    @Override
    public JSONObject visit(Program n, ParsingContext ctx) {
        JSONObject obj = parsingContextToJSON(n.context());
        JSONArray children = new JSONArray();
        for (var child : n.children()) {
            children.put(child.accept(this, null));
        }

        obj.put("children", children);

        return wrap(n, obj);
    }

    @Override
    public JSONObject visit(OneWayOperationDeclaration decl, ParsingContext ctx) {
        JSONObject obj = parsingContextToJSON(decl.context());
        JSONObject requestType = decl.requestType().accept(this, null);

        obj.put("requestType", requestType);

        return wrap(decl, obj);
    }

    @Override
    public JSONObject visit(RequestResponseOperationDeclaration decl, ParsingContext ctx) {
        JSONObject obj = parsingContextToJSON(decl.context());
        JSONObject requestType = decl.requestType().accept(this, null);
        JSONObject responseType = decl.responseType().accept(this, null);
        obj.put("requestType", requestType);
        obj.put("responseType", responseType);
        return wrap(decl, obj);
    }

    @Override
    public JSONObject visit(DefinitionNode n, ParsingContext ctx) {
        JSONObject obj = parsingContextToJSON(n.context());
        return wrap(n, obj);
    }

    @Override
    public JSONObject visit(ParallelStatement n, ParsingContext ctx) {
        JSONObject obj = parsingContextToJSON(n.context());
        JSONArray children = new JSONArray();
        for (var child : n.children()) {
            children.put(child.accept(this, null));
        }
        obj.put("children", children);

        return wrap(n, obj);
    }

    @Override
    public JSONObject visit(SequenceStatement n, ParsingContext ctx) {
        JSONObject obj = parsingContextToJSON(n.context());
        JSONArray children = new JSONArray();
        for (var child : n.children()) {
            children.put(child.accept(this, null));
        }
        obj.put("children", children);

        return wrap(n, obj);
    }

    @Override
    public JSONObject visit(NDChoiceStatement n, ParsingContext ctx) {
        JSONObject obj = parsingContextToJSON(n.context());
        JSONArray children = new JSONArray();
        for (Pair<OLSyntaxNode, OLSyntaxNode> child : n.children()) {
            JSONObject childObj = new JSONObject();
            childObj.put("key", child.key().accept(this, null));
            childObj.put("value", child.value().accept(this, null));
            children.put(childObj);
        }
        obj.put("children", children);

        return wrap(n, obj);
    }

    @Override
    public JSONObject visit(OneWayOperationStatement n, ParsingContext ctx) {
        JSONObject obj = parsingContextToJSON(n.context());
        obj.put("inputVarPath", n.inputVarPath());
        return wrap(n, obj);
    }

    @Override
    public JSONObject visit(RequestResponseOperationStatement n, ParsingContext ctx) {
        JSONObject obj = parsingContextToJSON(n.context());
        obj.put("inputVarPath", n.inputVarPath().accept(this, null));
        obj.put("outputExpression", n.outputExpression().accept(this, null));
        obj.put("process", n.process().accept(this, null));
        return wrap(n, obj);
    }

    @Override
    public JSONObject visit(NotificationOperationStatement n, ParsingContext ctx) {
        JSONObject obj = parsingContextToJSON(n.context());
        obj.put("outputExpression", n.outputExpression().accept(this, null));
        return wrap(n, obj);
    }

    @Override
    public JSONObject visit(SolicitResponseOperationStatement n, ParsingContext ctx) {
        JSONObject obj = parsingContextToJSON(n.context());
        obj.put("inputVarPath",n.inputVarPath().accept(this, null));
        obj.put("outputExpression",n.outputExpression().accept(this, null));
        JSONArray handlersFunctionArray = new JSONArray();
        for (var pair : n.handlersFunction().pairs()) {
            JSONObject pairObj = new JSONObject();
            pairObj.put(pair.key(), pair.value().accept(this, null));
            handlersFunctionArray.put(pairObj);
        }
        obj.put("handlersFunction", handlersFunctionArray);
        return wrap(n, obj);
    }

    @Override
    public JSONObject visit(LinkInStatement n, ParsingContext ctx) {
        JSONObject obj = parsingContextToJSON(n.context());
        return wrap(n, obj);
    }

    @Override
    public JSONObject visit(LinkOutStatement n, ParsingContext ctx) {
        JSONObject obj = parsingContextToJSON(n.context());
        return wrap(n, obj);
    }

    @Override
    public JSONObject visit(AssignStatement n, ParsingContext ctx) {
        JSONObject obj = parsingContextToJSON(n.context());
        obj.put("expression", n.expression().accept(this, null));
        obj.put("variablePath", n.variablePath().accept(this, null));
        return wrap(n, obj);
    }

    @Override
    public JSONObject visit(AddAssignStatement n, ParsingContext ctx) {
        JSONObject obj = parsingContextToJSON(n.context());
        obj.put("expression", n.expression().accept(this, null));
        obj.put("variablePath", n.variablePath().accept(this, null));
        return wrap(n, obj);
    }

    @Override
    public JSONObject visit(SubtractAssignStatement n, ParsingContext ctx) {
        JSONObject obj = parsingContextToJSON(n.context());
        obj.put("expression", n.expression().accept(this, null));
        obj.put("variablePath", n.variablePath().accept(this, null));
        return wrap(n, obj);
    }

    @Override
    public JSONObject visit(MultiplyAssignStatement n, ParsingContext ctx) {
        JSONObject obj = parsingContextToJSON(n.context());
        obj.put("expression", n.expression().accept(this, null));
        obj.put("variablePath", n.variablePath().accept(this, null));
        return wrap(n, obj);
    }

    @Override
    public JSONObject visit(DivideAssignStatement n, ParsingContext ctx) {
        JSONObject obj = parsingContextToJSON(n.context());
        obj.put("expression", n.expression().accept(this, null));
        obj.put("variablePath", n.variablePath().accept(this, null));
        return wrap(n, obj);
    }

    @Override
    public JSONObject visit(IfStatement n, ParsingContext ctx) {
        JSONObject obj = parsingContextToJSON(n.context());
        obj.put("elseProcess", n.elseProcess().accept(this, null));
        JSONArray children = new JSONArray();
        for (var child : n.children()) {
            JSONObject childObj = new JSONObject();
            childObj.put("key", child.key().accept(this, null));
            childObj.put("value", child.value().accept(this, null));
            children.put(childObj);
        }
        obj.put("children", children);

        return wrap(n, obj);
    }

    @Override
    public JSONObject visit(DefinitionCallStatement n, ParsingContext ctx) {
        JSONObject obj = parsingContextToJSON(n.context());
        return wrap(n, obj);
    }

    @Override
    public JSONObject visit(WhileStatement n, ParsingContext ctx) {
        JSONObject obj = parsingContextToJSON(n.context());
        obj.put("condition", n.condition().accept(this, null));
        obj.put("body", n.body().accept(this, null));
        return wrap(n, obj);
    }

    @Override
    public JSONObject visit(OrConditionNode n, ParsingContext ctx) {
        JSONObject obj = parsingContextToJSON(n.context());
        JSONArray children = new JSONArray();
        for (var child : n.children()) {
            children.put(child.accept(this, null));
        }
        obj.put("children", children);

        return wrap(n, obj);
    }

    @Override
    public JSONObject visit(AndConditionNode n, ParsingContext ctx) {
        JSONObject obj = parsingContextToJSON(n.context());
        JSONArray children = new JSONArray();
        for (var child : n.children()) {
            children.put(child.accept(this, null));
        }
        obj.put("children", children);

        return wrap(n, obj);
    }

    @Override
    public JSONObject visit(NotExpressionNode n, ParsingContext ctx) {
        JSONObject obj = parsingContextToJSON(n.context());
        obj.put("expression", n.expression().accept(this, null));
        return wrap(n, obj);
    }

    @Override
    public JSONObject visit(CompareConditionNode n, ParsingContext ctx) {
        JSONObject obj = parsingContextToJSON(n.context());
        obj.put("leftExpression", n.leftExpression().accept(this, null));
        obj.put("rightExpression", n.rightExpression().accept(this, null));
        return wrap(n, obj);
    }

    @Override
    public JSONObject visit(ConstantIntegerExpression n, ParsingContext ctx) {
        JSONObject obj = parsingContextToJSON(n.context());
        return wrap(n, obj);
    }

    @Override
    public JSONObject visit(ConstantDoubleExpression n, ParsingContext ctx) {
        JSONObject obj = parsingContextToJSON(n.context());
        return wrap(n, obj);
    }

    @Override
    public JSONObject visit(ConstantBoolExpression n, ParsingContext ctx) {
        JSONObject obj = parsingContextToJSON(n.context());
        return wrap(n, obj);
    }

    @Override
    public JSONObject visit(ConstantLongExpression n, ParsingContext ctx) {
        JSONObject obj = parsingContextToJSON(n.context());
        return wrap(n, obj);
    }

    @Override
    public JSONObject visit(ConstantStringExpression n, ParsingContext ctx) {
        JSONObject obj = parsingContextToJSON(n.context());
        return wrap(n, obj);
    }

    @Override
    public JSONObject visit(ProductExpressionNode n, ParsingContext ctx) {
        JSONObject obj = parsingContextToJSON(n.context());
        JSONArray operands = new JSONArray();
        n.operands().forEach((operandTypeOLSyntaxNodePair -> {
            JSONObject pair = new JSONObject();
            pair.put(operandTypeOLSyntaxNodePair.key().name(), operandTypeOLSyntaxNodePair.value().accept(this, null));
            operands.put(pair);
        }));
        obj.put("operands", operands);

        return wrap(n, obj);
    }

    @Override
    public JSONObject visit(SumExpressionNode n, ParsingContext ctx) {
        JSONObject obj = parsingContextToJSON(n.context());
        JSONArray operands = new JSONArray();
        n.operands().forEach((operandTypeOLSyntaxNodePair -> {
            JSONObject pair = new JSONObject();
            pair.put(operandTypeOLSyntaxNodePair.key().name(), operandTypeOLSyntaxNodePair.value().accept(this, null));
            operands.put(pair);
        }));
        obj.put("operands", operands);

        return wrap(n, obj);
    }

    @Override
    public JSONObject visit(VariableExpressionNode n, ParsingContext ctx) {
        JSONObject obj = parsingContextToJSON(n.context());
        obj.put("variablePath", n.variablePath().accept(this, null));
        return wrap(n, obj);
    }

    @Override
    public JSONObject visit(NullProcessStatement n, ParsingContext ctx) {
        JSONObject obj = parsingContextToJSON(n.context());
        return wrap(n, obj);
    }

    @Override
    public JSONObject visit(Scope n, ParsingContext ctx) {
        JSONObject obj = parsingContextToJSON(n.context());
        obj.put("body", n.body().accept(this, null));
        return wrap(n, obj);
    }

    @Override
    public JSONObject visit(InstallStatement n, ParsingContext ctx) {
        JSONObject obj = parsingContextToJSON(n.context());
        JSONArray handlersFunctionArray = new JSONArray();
        for (var pair : n.handlersFunction().pairs()) {
            JSONObject pairObj = new JSONObject();
            pairObj.put(pair.key(), pair.value().accept(this, null));
            handlersFunctionArray.put(pairObj);
        }
        obj.put("handlersFunction", handlersFunctionArray);

        return wrap(n, obj);

    }

    @Override
    public JSONObject visit(CompensateStatement n, ParsingContext ctx) {
        JSONObject obj = parsingContextToJSON(n.context());
        return wrap(n, obj);
    }

    @Override
    public JSONObject visit(ThrowStatement n, ParsingContext ctx) {
        JSONObject obj = parsingContextToJSON(n.context());
        obj.put("expression", n.expression().accept(this, null));
        return wrap(n, obj);
    }

    @Override
    public JSONObject visit(ExitStatement n, ParsingContext ctx) {
        JSONObject obj = parsingContextToJSON(n.context());
        return wrap(n, obj);
    }

    @Override
    public JSONObject visit(ExecutionInfo n, ParsingContext ctx) {
        JSONObject obj = parsingContextToJSON(n.context());
        return wrap(n, obj);
    }

    @Override
    public JSONObject visit(CorrelationSetInfo n, ParsingContext ctx) {
        JSONObject obj = parsingContextToJSON(n.context());
        JSONArray variables = new JSONArray();
        for (CorrelationSetInfo.CorrelationVariableInfo variable : n.variables()) {
            JSONObject variableObj = new JSONObject();
            variableObj.put("correlationVariablePath", variable.correlationVariablePath().accept(this, null));
            variable.aliases().forEach(correlationAliasInfo -> {
                JSONObject aliasObj = new JSONObject();
                aliasObj.put("guardName", correlationAliasInfo.guardName().accept(this, null));
                aliasObj.put("variablePath", correlationAliasInfo.variablePath().accept(this, null));
                variableObj.put("aliases", aliasObj);
            });
            variables.put(variableObj);
        }
        obj.put("variables", variables);

        return wrap(n, obj);
    }

    @Override
    public JSONObject visit(InputPortInfo n, ParsingContext ctx) {
        JSONObject obj = parsingContextToJSON(n.context());
        obj.put("location", n.location().accept(this, null));
        obj.put("protocol", n.protocol().accept(this, null));

        //OutputPortInfo::operations not included because it's the same as the map only with less information

        JSONArray interfaceList = new JSONArray();
        for (InterfaceDefinition child : n.getInterfaceList()) {
            interfaceList.put(child.accept(this, null));
        }
        obj.put("getInterfaceList", interfaceList);

        JSONObject operationsMapObj = new JSONObject();
        for (Map.Entry<String, OperationDeclaration> entry : n.operationsMap().entrySet()) {
            operationsMapObj.put(entry.getKey(), entry.getValue().accept(this, null));
        }
        obj.put("operationsMap", operationsMapObj);

        JSONArray aggregationsListObj = new JSONArray();
        for (InputPortInfo.AggregationItemInfo child : n.aggregationList()) {
            aggregationsListObj.put(child.interfaceExtender().accept(this, null));
        }

        return wrap(n, obj);
    }

    @Override
    public JSONObject visit(OutputPortInfo n, ParsingContext ctx) {
        JSONObject obj = parsingContextToJSON(n.context());
        obj.put("location", n.location().accept(this, null));
        obj.put("protocol", n.protocol().accept(this, null));

        //OutputPortInfo::operations not included because it's the same as the map only with less information

        JSONArray interfaceList = new JSONArray();
        for (InterfaceDefinition child : n.getInterfaceList()) {
            interfaceList.put(child.accept(this, null));
        }
        obj.put("getInterfaceList", interfaceList);

        JSONObject operationsMapObj = new JSONObject();
        for (Map.Entry<String, OperationDeclaration> entry : n.operationsMap().entrySet()) {
            operationsMapObj.put(entry.getKey(), entry.getValue().accept(this, null));
        }
        obj.put("operationsMap", operationsMapObj);

        return wrap(n, obj);
    }

    @Override
    public JSONObject visit(PointerStatement n, ParsingContext ctx) {
        JSONObject obj = parsingContextToJSON(n.context());
        obj.put("leftPath", n.leftPath().accept(this, null));
        obj.put("rightPath", n.rightPath().accept(this, null));

        return wrap(n, obj);
    }

    @Override
    public JSONObject visit(DeepCopyStatement n, ParsingContext ctx) {
        JSONObject obj = parsingContextToJSON(n.context());
        obj.put("leftPath", n.leftPath().accept(this, null));
        obj.put("rightExpression", n.rightExpression().accept(this, null));

        return wrap(n, obj);
    }

    @Override
    public JSONObject visit(RunStatement n, ParsingContext ctx) {
        JSONObject obj = parsingContextToJSON(n.context());
        obj.put("expression", n.expression().accept(this, null));

        return wrap(n, obj);
    }

    @Override
    public JSONObject visit(UndefStatement n, ParsingContext ctx) {
        JSONObject obj = parsingContextToJSON(n.context());
        obj.put("variablePath", n.variablePath().accept(this, null));

        return wrap(n, obj);
    }

    @Override
    public JSONObject visit(ValueVectorSizeExpressionNode n, ParsingContext ctx) {
        JSONObject obj = parsingContextToJSON(n.context());
        obj.put("variablePath", n.variablePath().accept(this, null));

        return wrap(n, obj);
    }

    @Override
    public JSONObject visit(PreIncrementStatement n, ParsingContext ctx) {
        JSONObject obj = parsingContextToJSON(n.context());
        obj.put("variablePath", n.variablePath().accept(this, null));

        return wrap(n, obj);
    }

    @Override
    public JSONObject visit(PostIncrementStatement n, ParsingContext ctx) {
        JSONObject obj = parsingContextToJSON(n.context());
        obj.put("variablePath", n.variablePath().accept(this, null));

        return wrap(n, obj);
    }

    @Override
    public JSONObject visit(PreDecrementStatement n, ParsingContext ctx) {
        JSONObject obj = parsingContextToJSON(n.context());
        obj.put("variablePath", n.variablePath().accept(this, null));

        return wrap(n, obj);
    }

    @Override
    public JSONObject visit(PostDecrementStatement n, ParsingContext ctx) {
        JSONObject obj = parsingContextToJSON(n.context());
        obj.put("variablePath", n.variablePath().accept(this, null));

        return wrap(n, obj);
    }

    @Override
    public JSONObject visit(ForStatement n, ParsingContext ctx) {
        JSONObject obj = parsingContextToJSON(n.context());
        obj.put("body", n.body().accept(this, null));
        obj.put("condition", n.condition().accept(this, null));
        obj.put("init", n.init().accept(this, null));
        obj.put("post", n.post().accept(this, null));

        return wrap(n, obj);
    }

    @Override
    public JSONObject visit(ForEachSubNodeStatement n, ParsingContext ctx) {
        JSONObject obj = parsingContextToJSON(n.context());
        obj.put("body", n.body().accept(this, null));
        obj.put("keyPath", n.keyPath().accept(this, null));
        obj.put("targetPath", n.targetPath().accept(this, null));

        return wrap(n, obj);
    }

    @Override
    public JSONObject visit(ForEachArrayItemStatement n, ParsingContext ctx) {
        JSONObject obj = parsingContextToJSON(n.context());
        obj.put("body", n.body().accept(this, null));
        obj.put("keyPath", n.keyPath().accept(this, null));
        obj.put("targetPath", n.targetPath().accept(this, null));

        return wrap(n, obj);
    }

    @Override
    public JSONObject visit(SpawnStatement n, ParsingContext ctx) {
        JSONObject obj = parsingContextToJSON(n.context());
        obj.put("indexVariablePath", n.indexVariablePath().accept(this, null));
        obj.put("inVariablePath", n.inVariablePath().accept(this, null));
        obj.put("body", n.body().accept(this, null));
        obj.put("upperBoundExpression", n.upperBoundExpression().accept(this, null));

        return wrap(n, obj);
    }

    @Override
    public JSONObject visit(IsTypeExpressionNode n, ParsingContext ctx) {
        JSONObject obj = parsingContextToJSON(n.context());
        obj.put("variablePath", n.variablePath().accept(this, null));

        return wrap(n, obj);
    }

    @Override
    public JSONObject visit(InstanceOfExpressionNode n, ParsingContext ctx) {
        JSONObject obj = parsingContextToJSON(n.context());
        obj.put("type", n.type().accept(this, null));
        obj.put("expression", n.expression().accept(this, null));
        return wrap(n, obj);
    }

    @Override
    public JSONObject visit(TypeCastExpressionNode n, ParsingContext ctx) {
        JSONObject obj = parsingContextToJSON(n.context());
        obj.put("expression", n.expression().accept(this, null));
        return wrap(n, obj);
    }

    @Override
    public JSONObject visit(SynchronizedStatement n, ParsingContext ctx) {
        JSONObject obj = parsingContextToJSON(n.context());
        obj.put("body", n.body().accept(this, null));
        return wrap(n, obj);
    }

    @Override
    public JSONObject visit(CurrentHandlerStatement n, ParsingContext ctx) {
        JSONObject obj = parsingContextToJSON(n.context());
        return wrap(n, obj);
    }

    @Override
    public JSONObject visit(EmbeddedServiceNode n, ParsingContext ctx) {
        JSONObject obj = parsingContextToJSON(n.context());
        obj.put("program", n.program().accept(this, null));
        return wrap(n, obj);
    }

    @Override
    public JSONObject visit(InstallFixedVariableExpressionNode n, ParsingContext ctx) {
        JSONObject obj = parsingContextToJSON(n.context());
        obj.put("variablePath", n.variablePath().accept(this, null));
        return wrap(n, obj);
    }

    @Override
    public JSONObject visit(VariablePathNode n, ParsingContext ctx) {
        JSONObject obj = parsingContextToJSON(n.context());

        JSONArray pathList = new JSONArray();
        for (Pair< OLSyntaxNode, OLSyntaxNode > child: n.path()) {
            JSONObject pairObj = new JSONObject();
            pairObj.put("key", child.key().accept(this, null));
            if (child.value() != null) {
                pairObj.put("value", child.value().accept(this, null));
            }
            pathList.put(pairObj);
        }

        return wrap(n, obj);
    }

    @Override
    public JSONObject visit(TypeInlineDefinition n, ParsingContext ctx) {
        JSONObject obj = parsingContextToJSON(n.context());

        JSONObject subTypesSetObj = new JSONObject();
        if (n.subTypes() != null) {
            for (Map.Entry<String, TypeDefinition> entry : n.subTypes()) {
                subTypesSetObj.put(entry.getKey(), entry.getValue().accept(this, null));
            }
            obj.put("subTypes", subTypesSetObj);
        }

        return wrap(n, obj);
    }

    @Override
    public JSONObject visit(TypeDefinitionLink n, ParsingContext ctx) {
        JSONObject obj = parsingContextToJSON(n.context());
        obj.put("linkedType", n.linkedType().accept(this, null));
        return wrap(n, obj);
    }

    @Override
    public JSONObject visit(InterfaceDefinition n, ParsingContext ctx) {
        JSONObject obj = parsingContextToJSON(n.context());
        obj.put("operationsMap", operationMapToJSON(n));

        return wrap(n, obj);
    }

    @Override
    public JSONObject visit(DocumentationComment n, ParsingContext ctx) {
        JSONObject obj = parsingContextToJSON(n.context());
        return wrap(n, obj);
    }

    @Override
    public JSONObject visit(FreshValueExpressionNode n, ParsingContext ctx) {
        JSONObject obj = parsingContextToJSON(n.context());
        return wrap(n, obj);
    }

    @Override
    public JSONObject visit(CourierDefinitionNode n, ParsingContext ctx) {
        JSONObject obj = parsingContextToJSON(n.context());
        obj.put("body", n.body().accept(this, null));
        return wrap(n, obj);
    }

    @Override
    public JSONObject visit(CourierChoiceStatement n, ParsingContext ctx) {
        JSONObject obj = parsingContextToJSON(n.context());

        JSONArray interfaceOneWayBranchesObj = new JSONArray();
        for (CourierChoiceStatement.InterfaceOneWayBranch child : n.interfaceOneWayBranches()) {
            JSONObject interfaceOneWayBranchObj = new JSONObject();
            interfaceOneWayBranchObj.put("interfaceDefinition", child.interfaceDefinition.accept(this, null));
            interfaceOneWayBranchObj.put("inputVariablePath", child.inputVariablePath.accept(this, null));
            interfaceOneWayBranchObj.put("body", child.body.accept(this, null));
            interfaceOneWayBranchesObj.put(interfaceOneWayBranchObj);
        }
        obj.put("interfaceOneWayBranches", interfaceOneWayBranchesObj);

        JSONArray interfaceRequestResponseBranchesObj = new JSONArray();
        for (CourierChoiceStatement.InterfaceRequestResponseBranch child : n.interfaceRequestResponseBranches()) {
            JSONObject interfaceRequestResponseBranchObj = new JSONObject();
            interfaceRequestResponseBranchObj.put("interfaceDefinition", child.interfaceDefinition.accept(this, null));
            interfaceRequestResponseBranchObj.put("inputVariablePath", child.inputVariablePath.accept(this, null));
            interfaceRequestResponseBranchObj.put("outputVariablePath", child.outputVariablePath.accept(this, null));
            interfaceRequestResponseBranchObj.put("body", child.body.accept(this, null));
            interfaceRequestResponseBranchesObj.put(interfaceRequestResponseBranchObj);
        }
        obj.put("interfaceRequestResponseBranches", interfaceRequestResponseBranchesObj);

        JSONArray operationOneWayBranchesObj = new JSONArray();
        for (CourierChoiceStatement.OperationOneWayBranch child : n.operationOneWayBranches()) {
            JSONObject operationOneWayBranchObj = new JSONObject();
            operationOneWayBranchObj.put("inputVariablePath", child.inputVariablePath.accept(this, null));
            operationOneWayBranchObj.put("body", child.body.accept(this, null));
            operationOneWayBranchesObj.put(operationOneWayBranchObj);
        }
        obj.put("operationOneWayBranches", operationOneWayBranchesObj);

        JSONArray operationRequestResponseBranchesObj = new JSONArray();
        for (CourierChoiceStatement.InterfaceRequestResponseBranch child : n.interfaceRequestResponseBranches()) {
            JSONObject operationRequestResponseBranchObj = new JSONObject();
            operationRequestResponseBranchObj.put("inputVariablePath", child.inputVariablePath.accept(this, null));
            operationRequestResponseBranchObj.put("outputVariablePath", child.outputVariablePath.accept(this, null));
            operationRequestResponseBranchObj.put("body", child.body.accept(this, null));
            operationRequestResponseBranchesObj.put(operationRequestResponseBranchObj);
        }
        obj.put("interfaceRequestResponseBranches", operationRequestResponseBranchesObj);

        return wrap(n, obj);
    }

    @Override
    public JSONObject visit(NotificationForwardStatement n, ParsingContext ctx) {
        JSONObject obj = parsingContextToJSON(n.context());
        obj.put("outputVariablePath", n.outputVariablePath().accept(this, null));

        return wrap(n, obj);
    }

    @Override
    public JSONObject visit(SolicitResponseForwardStatement n, ParsingContext ctx) {
        JSONObject obj = parsingContextToJSON(n.context());
        obj.put("inputVariablePath", n.inputVariablePath().accept(this, null));
        obj.put("outputVariablePath", n.outputVariablePath().accept(this, null));

        return wrap(n, obj);
    }

    @Override
    public JSONObject visit(InterfaceExtenderDefinition n, ParsingContext ctx) {
        JSONObject obj = parsingContextToJSON(n.context());
        obj.put("defaultOneWayOperation", n.defaultOneWayOperation().accept(this, null));
        obj.put("defaultRequestResponseOperation", n.defaultRequestResponseOperation().accept(this, null));
        obj.put("operationsMap", operationMapToJSON(n));

        return wrap(n, obj);
    }

    @Override
    public JSONObject visit(InlineTreeExpressionNode n, ParsingContext ctx) {
        JSONObject obj = parsingContextToJSON(n.context());
        obj.put("rootExpression", n.rootExpression().accept(this, null));

        JSONArray operations = new JSONArray();
        for (var child : n.operations()) {
            if (child instanceof InlineTreeExpressionNode.AssignmentOperation) {
                JSONObject assignmentOperationObj = new JSONObject();
                assignmentOperationObj.put("path", ((InlineTreeExpressionNode.AssignmentOperation) child).path().accept(this, null));
                assignmentOperationObj.put("expression", ((InlineTreeExpressionNode.AssignmentOperation) child).expression().accept(this, null));
                operations.put(wrap(child, assignmentOperationObj));
            } else if (child instanceof InlineTreeExpressionNode.DeepCopyOperation) {
                JSONObject deepCopyOperation = new JSONObject();
                deepCopyOperation.put("path", ((InlineTreeExpressionNode.DeepCopyOperation) child).path().accept(this, null));
                deepCopyOperation.put("expression", ((InlineTreeExpressionNode.DeepCopyOperation) child).expression().accept(this, null));
                operations.put(wrap(child, deepCopyOperation));
            } else if (child instanceof InlineTreeExpressionNode.PointsToOperation) {
                JSONObject pointsToOperation = new JSONObject();
                pointsToOperation.put("path", ((InlineTreeExpressionNode.PointsToOperation) child).path().accept(this, null));
                pointsToOperation.put("target", ((InlineTreeExpressionNode.PointsToOperation) child).target().accept(this, null));
                operations.put(wrap(child, pointsToOperation));
            }
        }

        obj.put("operations", operations);

        return wrap(n, obj);
    }

    @Override
    public JSONObject visit(VoidExpressionNode n, ParsingContext ctx) {
        return wrap(n, parsingContextToJSON(n.context()));
    }

    @Override
    public JSONObject visit(ProvideUntilStatement n, ParsingContext ctx) {
        JSONObject obj = parsingContextToJSON(n.context());
        obj.put("provide", n.provide().accept(this, null));
        obj.put("until", n.until().accept(this, null));

        return wrap(n, obj);
    }

    @Override
    public JSONObject visit(TypeChoiceDefinition n, ParsingContext ctx) {
        JSONObject obj = parsingContextToJSON(n.context());
        obj.put("left", n.left().accept(this, null));
        obj.put("right", n.right().accept(this, null));

        return wrap(n, obj);
    }

    @Override
    public JSONObject visit(ImportStatement n, ParsingContext ctx) {
        return wrap(n, parsingContextToJSON(n.context()));
    }

    @Override
    public JSONObject visit(ServiceNode n, ParsingContext ctx) {
        JSONObject obj = parsingContextToJSON(n.context());
        obj.put("Program", n.program().accept(this, null));

        return wrap(n, obj);
    }

    @Override
    public JSONObject visit(EmbedServiceNode n, ParsingContext ctx) {
        JSONObject obj = parsingContextToJSON(n.context());
        obj.put("passingParameter", n.passingParameter().accept(this, null));
        obj.put("service", n.service().accept(this, null));

        return wrap(n, obj);
    }

    @Override
    public JSONObject visit(SolicitResponseExpressionNode n, ParsingContext ctx) {
        JSONObject obj = parsingContextToJSON(n.context());
        obj.put("outputExpression", n.outputExpression().accept(this, null));

        return wrap(n, obj);
    }

    @Override
    public JSONObject visit(IfExpressionNode n, ParsingContext Ctx) {
        JSONObject obj = parsingContextToJSON(n.context());
        obj.put("elseExpression", n.elseExpression().accept(this, null));
        obj.put("thenExpression", n.thenExpression().accept(this, null));
        obj.put("guard", n.guard().accept(this, null));

        return wrap(n, obj);
    }
}
